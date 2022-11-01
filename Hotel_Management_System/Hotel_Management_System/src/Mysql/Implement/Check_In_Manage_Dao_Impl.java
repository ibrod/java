package Mysql.Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Vector;

import Mysql.Dao.Check_In_Manage_Dao;
import Mysql.Mysql_Obj.Check_In_Obj;
import javafx.scene.control.Alert;

public class Check_In_Manage_Dao_Impl extends Implement_Parent implements Check_In_Manage_Dao {

    @Override
    public boolean select_data(Vector<Check_In_Obj> arr_User, Check_In_Obj value, boolean[] is_added) {
        try {
            // System.out.println(sql_command);
            // 3.获取操作数据库的预处理对象

            String sql_command = "select c.*,r.room_number,u.name,id_card,phone from check_in c left join room r on c.room_id = r.room_id left join user u on c.user_id=u.user_id where 1=1";
            if (is_added[0]) {
                sql_command += " and check_in_id=?";
            }
            if (is_added[1]) {
                sql_command += " and user_id=?";
            }
            if (is_added[2]) {
                sql_command += " and room_id=?";
            }
            if (is_added[3]) {
                sql_command += " and in_time=?";
            }
            if (is_added[4]) {
                sql_command += " and out_time=?";
            }
            if (is_added[5]) {
                sql_command += " and pledge=?";
            }
            if (is_added[6]) {
                sql_command += " and payment=?";
            }
            if (is_added[7]) {
                sql_command += " and note=?";
            }
            if (is_added[8]) {
                sql_command += " and r.room_number=?";
            }
            if (is_added[9]) {
                sql_command += " and u.name=?";
            }
            if (is_added[10]) {
                sql_command += " and u.id_card=?";
            }
            if (is_added[11]) {
                sql_command += " and u.phone=?";
            }

            // System.out.println(sql_command);
            PreparedStatement pstm = conn.prepareStatement(sql_command);

            int cnt = 1;
            if (is_added[0]) {
                pstm.setInt(cnt++, value.getCheck_in_id());
            }
            if (is_added[1]) {
                pstm.setInt(cnt++, value.getUser_id());
            }
            if (is_added[2]) {
                pstm.setInt(cnt++, value.getRoom_id());
            }
            if (is_added[3]) {
                pstm.setTimestamp(cnt++, Timestamp.valueOf(value.getIn_time()));
            }
            if (is_added[4]) {
                pstm.setTimestamp(cnt++, Timestamp.valueOf(value.getOut_time()));
            }
            if (is_added[5]) {
                pstm.setDouble(cnt++, value.getPledge());
            }
            if (is_added[6]) {
                pstm.setDouble(cnt++, value.getPayment());
            }
            if (is_added[7]) {
                pstm.setString(cnt++, value.getNote());
            }
            if (is_added[8]) {
                pstm.setString(cnt++, value.getRoom_number());
            }
            if (is_added[9]) {
                pstm.setString(cnt++, value.getName());
            }
            if (is_added[10]) {
                pstm.setString(cnt++, value.getId_card());
            }
            if (is_added[11]) {
                pstm.setString(cnt++, value.getPhone_number());
            }

            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                Check_In_Obj check_In_Obj = new Check_In_Obj(rs.getInt("check_in_id"), rs.getInt("user_id"), rs.getInt("room_id"), sql_command, sql_command, cnt, cnt, sql_command, sql_command, sql_command, sql_command, sql_command)
                arr_User.add(check_In_Obj);
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
    public int add_data(String room_id, String user_id) {
        try {
            int id = -1;
            PreparedStatement pstm = conn.prepareStatement("insert into check_in(user_id,room_id) values(?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setString(1, user_id);
            pstm.setString(2, room_id);
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
    public boolean delete_data(int id) {

        try {
            PreparedStatement pstm = conn.prepareStatement("delete from check_in where check_in_id=?");
            pstm.setInt(1, id);

            int count = pstm.executeUpdate();
            pstm.close();

            if (count == 1)
                return true;
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
    public boolean update_data(int check_in_id, String field, String value) {
        try {
            PreparedStatement pstm = conn.prepareStatement("update check_in set " + field + "=? where check_in_id=?");
            pstm.setString(1, value);
            pstm.setInt(2, check_in_id);

            int count = pstm.executeUpdate();

            pstm.close();

            if (count == 1)
                return true;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
        }
        return false;
    }

}
