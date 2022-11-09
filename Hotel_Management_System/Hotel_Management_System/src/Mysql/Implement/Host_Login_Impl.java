package Mysql.Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mysql.Dao.Host_Login_Dao;
import javafx.scene.control.Alert;
import Tools.SHA.EncryptSha256Util;

public class Host_Login_Impl extends Implement_Parent implements Host_Login_Dao {
    @Override
    public int login(String username_input, String password_input) {
        try {

            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from admin where user_name=? and password=?");
            pstm.setString(1, username_input);
            pstm.setString(2, EncryptSha256Util.getSha256Str(password_input));

            // 4.查询
            ResultSet rs = pstm.executeQuery();

            boolean bl = rs.next();
            // 5.关闭资源
            rs.close();
            pstm.close();
            return bl == true ? 1 : 0;
        } catch (Exception ee) {
            ee.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库连接失败");
            alert.setHeaderText("数据库连接失败");
            alert.setContentText("本数据库使用的是远端数据库，请检查你的互联网连接是否成功!");
            alert.showAndWait();
            return -1;
        }
    }
}