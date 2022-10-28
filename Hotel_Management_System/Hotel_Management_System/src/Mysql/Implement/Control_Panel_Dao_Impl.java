package Mysql.Implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mysql.Dao.Control_Panel_Dao;
import Mysql.Mysql_Obj.Control_Panel_Obj;
import javafx.scene.control.Alert;

public class Control_Panel_Dao_Impl extends Implement_Parent implements Control_Panel_Dao {
    @Override
    public Control_Panel_Obj query() {
        try {
            // 查询有多少房间
            PreparedStatement pstm = conn.prepareStatement("select count(*) from room");
            ResultSet rs = pstm.executeQuery();
            rs.next();
            int total = rs.getInt(1);

            // 查询有多少房间被占用
            pstm = conn.prepareStatement("select count(*) from room where guest_id>0");
            rs = pstm.executeQuery();
            rs.next();
            int occupied = rs.getInt(1);
            int surplus = total - occupied;

            // 查询有多少用户
            pstm = conn.prepareStatement("select count(*) from user");
            rs = pstm.executeQuery();
            rs.next();
            int user_num = rs.getInt(1);

            // 查询有多少管理员
            pstm = conn.prepareStatement("select count(*) from admin");
            rs = pstm.executeQuery();
            rs.next();
            int admin_num = rs.getInt(1);

            return new Control_Panel_Obj(surplus, occupied, user_num, admin_num);

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库连接失败");
            alert.setHeaderText("数据库连接失败");
            alert.setContentText("本数据库使用的是远端数据库，请检查你的互联网连接是否成功!");
            alert.showAndWait();
            return null;
        }
    }
}
