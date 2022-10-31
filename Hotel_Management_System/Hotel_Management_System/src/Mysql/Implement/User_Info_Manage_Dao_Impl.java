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
    public boolean update_by_phone(User_Info user_Info) {
        try {
            PreparedStatement pstm = conn
                    .prepareStatement("update user set gender=?,name=?,id_card=?,email=? where phone=?");
            pstm.setString(1, user_Info.getGender());
            pstm.setString(2, user_Info.getName());
            pstm.setString(3, user_Info.getId());
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
            PreparedStatement pstm = conn
                    .prepareStatement("insert into user(phone) values(?)");
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
            PreparedStatement pstm = conn.prepareStatement("delete from user where id=?");
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
    public boolean update_by_id(int id, User_Info user_Info,boolean is_add[]) {
        
        return false;
    }

    @Override
    public int insert_by_id(){
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
}