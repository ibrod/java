package com.Implement;
import java.sql.*;
public class SqlConnectionParent {
    String url;
    String user;
    String password;
    Connection conn;

    public SqlConnectionParent() {
        url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/sql_test?useSSL=false";
        user = "java_lab";
        password = "jk_20_2bj_XJ";
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
        }
    }
}
