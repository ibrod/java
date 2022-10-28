package Mysql.Implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mysql.Dao.Host_Login_Dao;
import javafx.scene.control.Alert;
import Tools.SHA.EncryptSha256Util;

public class Host_Login_Impl implements Host_Login_Dao {
    String url;
    String user;
    String password;
    Connection conn;

    public Host_Login_Impl() {
        url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/hotel_management_system?useSSL=false";
        user = "hotel_admin";
        password = "Jk20_2bj_java";
    }

    @Override
    public int login(String username_input, String password_input) {
        try {
            // 1.注册驱动
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");// 新版本的加载方式
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                Class.forName("com.mysql.jdbc.Driver");// 旧版本的加载方式
            }
            // 2.获取连接
            conn = DriverManager.getConnection(url, user, password);

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
            conn.close();
            return bl==true?1:0;

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