package Mysql.Implement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mysql.Dao.Control_Panel_Dao;
import Mysql.Mysql_Obj.Control_Panel_Obj;
import javafx.scene.control.Alert;

public class Control_Panel_Dao_Impl implements Control_Panel_Dao {
    String url;
    String user;
    String password;
    Connection conn;

    public Control_Panel_Dao_Impl() {
        url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/hotel_management_system?useSSL=false";
        user = "hotel_admin";
        password = "Jk20_2bj_java";
        init_connection();
    }

    void init_connection() {
        // 1.注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");// 新版本的加载方式
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            try {
                Class.forName("com.mysql.jdbc.Driver");// 旧版本的加载方式
            } catch (Exception ee) {
                ee.printStackTrace();
            }
        }
        try {
            // 2.获取连接
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
