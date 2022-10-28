package Mysql.Implement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mysql.Dao.Admin_Account_Dao;
import Mysql.Mysql_Obj.Admin_Account;
import javafx.scene.control.Alert;
import Tools.SHA.EncryptSha256Util;

public class Admin_Account_Dao_Impl implements Admin_Account_Dao { 
    String url;
    String user;
    String password;
    Connection conn;

    public Admin_Account_Dao_Impl() {
        url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/hotel_management_system?useSSL=false";
        user = "hotel_admin";
        password = "Jk20_2bj_java";
        init();
    }

    @Override
    public boolean init() {
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
            return false;
        }
        return true;
    }

    @Override
    public Admin_Account query(int idx) {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from admin Limit ?,1");
            pstm.setInt(1, idx);
            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            if (rs.next()) {
                Admin_Account Admin_Account = new Admin_Account();
                Admin_Account.id = rs.getInt("admin_id");
                Admin_Account.username = rs.getString("user_name");
                return Admin_Account;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }
        return null;
    }

    @Override
    public boolean insert(Admin_Account Admin_Account) {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("insert into admin(user_name,password) values(?,?)");
            pstm.setString(1, Admin_Account.username);
            pstm.setString(2, Admin_Account.password);
            // 4.执行SQL语句
            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }

        return false;
    }

    @Override
    public boolean delete(String username) {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("delete from admin where user_name=?");
            pstm.setString(1,username );
            // 4.执行SQL语句
            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }
        return false;
    }

    @Override
    public boolean update(Admin_Account Admin_Account) {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn
                    .prepareStatement("update admin set password=? where user_name=?");
            pstm.setString(1,EncryptSha256Util.getSha256Str(Admin_Account.password));
            pstm.setString(2, Admin_Account.username);
            // 4.执行SQL语句
            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }
        return false;
    }

    @Override
    public int count() {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select count(*) from admin");
            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }
        return 0;
    }
}