package Mysql.Implement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import Mysql.Dao.Check_In_Manage_Dao;
import Mysql.Mysql_Obj.Check_In_Obj;
import javafx.scene.control.Alert;

public class Check_In_Manage_Dao_Impl extends Implement_Parent implements Check_In_Manage_Dao {

    @Override
    public boolean select_data(Vector<Check_In_Obj> arr_obj, Check_In_Obj value, boolean[] is_added) {
        try {
            // System.out.println(sql_command);
            // 3.获取操作数据库的预处理对象

            String sql_command = "select c.*,r.room_number,u.name,id_card,phone from check_in c left join room r on c.room_id = r.room_id left join user u on c.user_id=u.user_id where 1=1";
            if (is_added[0]) {
                sql_command += " and c.check_in_id=?";
            }
            if (is_added[1]) {
                sql_command += " and c.user_id=?";
            }
            if (is_added[2]) {
                sql_command += " and c.room_id=?";
            }
            if (is_added[3]) {
                sql_command += " and c.in_time=?";
            }
            if (is_added[4]) {
                sql_command += " and c.out_time=?";
            }
            if (is_added[5]) {
                sql_command += " and c.pledge=?";
            }
            if (is_added[6]) {
                sql_command += " and c.payment=?";
            }
            if (is_added[7]) {
                sql_command += " and c.note=?";
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
                pstm.setDate(cnt++, Date.valueOf(value.getIn_time()));
            }
            if (is_added[4]) {
                pstm.setDate(cnt++, Date.valueOf(value.getOut_time()));
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
                pstm.setInt(cnt++, value.getRoom_number());
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
                Check_In_Obj check_In_Obj = new Check_In_Obj(rs.getInt("check_in_id"), rs.getInt("user_id"),
                        rs.getInt("room_id"), rs.getDate("in_time") == null ? "" : rs.getDate("in_time").toString(),
                        rs.getDate("out_time") == null ? "" : rs.getDate("out_time").toString(), rs.getDouble("pledge"),
                        rs.getDouble("payment"),
                        rs.getString("note"), rs.getInt("room_number"), rs.getString("name"),
                        rs.getString("id_card"), rs.getString("phone"));
                arr_obj.add(check_In_Obj);
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
            alert.setContentText("请检查网络和筛选条件是否合法");
            alert.showAndWait();
        }
        return false;
    }

    @Override
    public int add_data(Check_In_Obj value) {
        try {
            int id = -1;
            PreparedStatement pstm = conn.prepareStatement(
                    "insert into check_in(user_id,room_id,in_time,out_time) values(?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, value.getUser_id());
            pstm.setInt(2, value.getRoom_id());
            pstm.setDate(3, Date.valueOf(value.getIn_time()));
            pstm.setDate(4, Date.valueOf(value.getOut_time()));
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
            alert.setContentText("请检查用户和房间必须是唯一的合法值或网络连接问题");
            alert.showAndWait();
        }
        return -1;
    }

    @Override
    public boolean delete_data(int id) {

        try {
            PreparedStatement pstm = conn.prepareStatement("select * from check_in where check_in_id=?");
            pstm.setInt(1, id);
            Check_In_Obj check_In_Obj = new Check_In_Obj();
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                check_In_Obj.setRoom_id(rs.getInt("room_id"));
                check_In_Obj.setUser_id(rs.getInt("user_id"));
                check_In_Obj.setCheck_in_id(id);
                check_In_Obj.setIn_time(rs.getDate("in_time") == null ? "" : rs.getDate("in_time").toString());
                check_In_Obj.setOut_time(rs.getDate("out_time") == null ? "" : rs.getDate("out_time").toString());
                // check_In_Obj.setPledge(rs.getDouble("pledge"));
                check_In_Obj.setPayment(rs.getDouble("payment"));
                check_In_Obj.setNote(rs.getString("note"));
                // 重置房间状态
                PreparedStatement pstm2 = conn.prepareStatement("update room set room_status='空闲' where room_id=?");
                pstm2.setInt(1, check_In_Obj.getRoom_id());
                pstm2.executeUpdate();
                // // 删除临时账户
                // PreparedStatement pstm3 = conn.prepareStatement("delete from user where
                // user_id=? and type='临时'");
                // pstm3.setInt(1, check_In_Obj.getUser_id());
                // pstm3.executeUpdate();
            }

            pstm = conn.prepareStatement("delete from check_in where check_in_id=?");
            pstm.setInt(1, id);

            int count = pstm.executeUpdate();
            pstm.close();

            PreparedStatement ptsm4 = conn.prepareStatement(
                    "insert into history(user_id,room_id,in_time,out_time,payment,note) values(?,?,?,?,?,?)");
            ptsm4.setInt(1, check_In_Obj.getUser_id());
            ptsm4.setInt(2, check_In_Obj.getRoom_id());
            if (!check_In_Obj.getIn_time().isEmpty()) {
                ptsm4.setDate(3, Date.valueOf(check_In_Obj.getIn_time()));
            }
            if (!check_In_Obj.getOut_time().isEmpty()) {
                ptsm4.setDate(4, Date.valueOf(check_In_Obj.getOut_time()));
            }
            ptsm4.setDouble(5, check_In_Obj.getPayment());
            ptsm4.setString(6, check_In_Obj.getNote());
            ptsm4.executeUpdate();
            ptsm4.close();

            if (count == 1)
                return true;
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常");
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
