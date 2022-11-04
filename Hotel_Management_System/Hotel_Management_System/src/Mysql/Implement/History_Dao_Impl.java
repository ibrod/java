package Mysql.Implement;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import Mysql.Dao.History_Dao;
import Mysql.Mysql_Obj.History;
import javafx.scene.control.Alert;

public class History_Dao_Impl extends Implement_Parent implements History_Dao {

    @Override
    public boolean select_data(Vector<History> arr_record, History value, boolean[] is_added) {
        try {
            // System.out.println(sql_command);
            // 3.获取操作数据库的预处理对象

            String sql_command = "select c.*,r.room_number,u.name,id_card,phone from history c left join room r on c.room_id = r.room_id left join user u on c.user_id=u.user_id where 1=1";
            if (is_added[0]) {
                sql_command += " and c.history_id=?";
            }
            if (is_added[1]) {
                sql_command += " and c.user_id=?";
            }
            if (is_added[2]) {
                sql_command += " and c.room_id=?";
            }
            if (is_added[3]) {
                sql_command += " and c.in_time>=?";
            }
            if (is_added[4]) {
                sql_command += " and c.in_time<?";
            }
            if (is_added[5]) {
                sql_command += " and c.payment=?";
            }
            if (is_added[6]) {
                sql_command += " and c.note=?";
            }
            if (is_added[7]) {
                sql_command += " and r.room_number=?";
            }
            if (is_added[8]) {
                sql_command += " and u.name=?";
            }
            if (is_added[9]) {
                sql_command += " and u.id_card=?";
            }
            if (is_added[10]) {
                sql_command += " and u.phone=?";
            }

            System.out.println(sql_command);
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
                pstm.setDouble(cnt++, value.getPayment());
            }
            if (is_added[6]) {
                pstm.setString(cnt++, value.getNote());
            }
            if (is_added[7]) {
                pstm.setInt(cnt++, value.getRoom_number());
            }
            if (is_added[8]) {
                pstm.setString(cnt++, value.getName());
            }
            if (is_added[9]) {
                pstm.setString(cnt++, value.getId_card());
            }
            if (is_added[10]) {
                pstm.setString(cnt++, value.getPhone());
            }

            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                History history = new History(rs.getInt("history_id"), rs.getInt("user_id"),
                        rs.getInt("room_id"), rs.getDate("in_time").toString(),
                        rs.getDate("out_time").toString(),rs.getDouble("payment"),
                        rs.getString("note"), rs.getInt("room_number"), rs.getString("name"),
                        rs.getString("id_card"), rs.getString("phone"));
                        arr_record.add(history);
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
    public int add_data(History value) {
        try {
            int id = -1;
            PreparedStatement pstm = conn.prepareStatement("insert into History(user_id,room_id,in_time,out_time,payment,note) values(?,?,?,?,?,?)",
                    PreparedStatement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, value.getUser_id());
            pstm.setInt(2, value.getRoom_id());
            pstm.setDate(3, Date.valueOf(value.getIn_time()));
            pstm.setDate(4, Date.valueOf(value.getOut_time()));
            pstm.setDouble(6, value.getPayment());
            pstm.setString(6, value.getNote());

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
        // TODO Auto-generated method stub
        try {
            String sql_command = "delete from history where history_id=?";
            PreparedStatement ps = conn.prepareStatement(sql_command);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
