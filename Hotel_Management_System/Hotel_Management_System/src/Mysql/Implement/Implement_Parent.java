package Mysql.Implement;

import java.sql.Connection;
import java.sql.DriverManager;

import javafx.scene.control.Alert;

public class Implement_Parent {
    String url;
    String user;
    String password;
    Connection conn;

    public Implement_Parent() {
        url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/hotel_management_system?useSSL=false";
        user = "hotel_admin";
        password = "Jk20_2bj_java";
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
        } catch (Exception ee) {
            ee.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库连接失败");
            alert.setHeaderText("数据库连接失败");
            alert.setContentText("本数据库使用的是远端数据库，请检查你的互联网连接是否成功!");
            alert.showAndWait();
        }
    }

}
