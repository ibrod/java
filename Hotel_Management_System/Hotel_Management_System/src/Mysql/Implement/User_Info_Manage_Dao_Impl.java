package Mysql.Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Mysql.Dao.User_Info_Manage_Dao;
import Mysql.Mysql_Obj.User_Info;

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
    public boolean update(User_Info user_Info) {
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
}