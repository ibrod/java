package Mysql.Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Mysql.Dao.User_Info_Manage_Dao;
import Mysql.Mysql_Obj.User_Info;
import javafx.scene.control.Alert;

public class User_Info_Manage_Dao_Impl extends Implement_Parent implements User_Info_Manage_Dao {

    @Override
    public User_Info get_user_info(String phone) {
        try {
            PreparedStatement pstm = conn.prepareStatement("select * from user where phone=?");
            pstm.setString(1, phone);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                User_Info user_info = new User_Info(rs.getString("phone"), rs.getString("gender"), rs.getString("name"),
                        rs.getString("id_card"), rs.getString("email"));
                return user_info;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User_Info get_user_info_send_by_user(String phone) {
        try {
            PreparedStatement pstm = conn.prepareStatement("select * from user where phone=? and type!='临时'");
            pstm.setString(1, phone);

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                User_Info user_info = new User_Info(rs.getString("phone"), rs.getString("gender"), rs.getString("name"),
                        rs.getString("id_card"), rs.getString("email"));
                return user_info;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update_by_phone(User_Info user_Info) {
        try {
            PreparedStatement pstm = conn
                    .prepareStatement("update user set gender=?,name=?,id_card=?,email=? where phone=? and type!='临时'");
            pstm.setString(1, user_Info.getGender());
            pstm.setString(2, user_Info.getName());
            pstm.setString(3, user_Info.getId_card());
            pstm.setString(4, user_Info.getEmail());
            pstm.setString(5, user_Info.getPhone_number());

            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean insert_by_phone(String phone) {
        try {
            // System.out.println(phone);
            PreparedStatement pstm = conn
                    .prepareStatement("insert into user(phone,type) values(?,'普通')");
            pstm.setString(1, phone);
            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete_by_id(int id) {
        try {
            PreparedStatement pstm = conn.prepareStatement("delete from user where user_id=?");
            pstm.setInt(1, id);
            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("删除失败");
            alert.setContentText("请检查数据库连接");
        }
        return false;
    }

    @Override
    public boolean update_by_id(int id, String field, String value) {
        try {
            PreparedStatement pstm = conn.prepareStatement("update user set " + field + "=? where user_id=?");
            pstm.setString(1, value);
            pstm.setInt(2, id);
            int count = pstm.executeUpdate();
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("更新失败");
            alert.setContentText("请检查数据库连接");
        }
        return false;
    }

    @Override
    public int insert_by_id() {
        try {
            int id = -1;
            PreparedStatement pstm = conn.prepareStatement("insert into user() values()",
                    PreparedStatement.RETURN_GENERATED_KEYS);

            pstm.executeUpdate();

            ResultSet rs = pstm.getGeneratedKeys();

            if (rs.next()) {
                id = rs.getInt(1);
            }
            pstm.close();
            return id;

        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }
        return -1;
    }

    @Override
    public boolean select_data(Vector<User_Info> arr_User, User_Info value, boolean[] is_added) {
        try {
            // System.out.println(sql_command);
            // 3.获取操作数据库的预处理对象

            String sql_command = "select * from user where 1=1";
            if (is_added[0]) {
                sql_command += " and user_id=?";
            }
            if (is_added[1]) {
                sql_command += " and name=?";
            }
            if (is_added[2]) {
                sql_command += " and gender=?";
            }
            if (is_added[3]) {
                sql_command += " and phone=?";
            }
            if (is_added[4]) {
                sql_command += " and id_card=?";
            }
            if (is_added[5]) {
                sql_command += " and email=?";
            }
            if (is_added[6]) {
                sql_command += " and type=?";
            }

            // System.out.println(sql_command);
            PreparedStatement pstm = conn.prepareStatement(sql_command);

            int cnt = 1;
            if (is_added[0]) {
                pstm.setInt(cnt, value.getUser_id());
                cnt++;
            }
            if (is_added[1]) {
                pstm.setString(cnt, value.getName());
                cnt++;
            }
            if (is_added[2]) {
                pstm.setString(cnt, value.getGender());
                cnt++;
            }
            if (is_added[3]) {
                pstm.setString(cnt, value.getPhone_number());
                cnt++;
            }
            if (is_added[4]) {
                pstm.setString(cnt, value.getId_card());
                cnt++;
            }
            if (is_added[5]) {
                pstm.setString(cnt, value.getEmail());
                cnt++;
            }
            if (is_added[6]) {
                pstm.setString(cnt, value.getType());
                cnt++;
            }

            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                User_Info user_Info = new User_Info(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getString("id_card"),
                        rs.getString("email"),
                        rs.getString("type"));
                arr_User.add(user_Info);
            }
            // 6.释放资源
            if (rs != null) {
                pstm.close();
                rs.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常!");
            alert.showAndWait();
        }
        return false;
    }

    @Override
    public boolean read_data(Vector<User_Info> arr_User_Info) {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from user");
            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                User_Info user_Info = new User_Info(
                        rs.getInt("user_id"),
                        rs.getString("name"),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getString("id_card"),
                        rs.getString("email"),
                        rs.getString("type")
                        );
                arr_User_Info.add(user_Info);
            }

            // 6.释放资源
            if (rs != null) {
                pstm.close();
                rs.close();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常!");
            alert.showAndWait();
            return false;
        }
    }

}