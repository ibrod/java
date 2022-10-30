package Mysql.Implement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import Mysql.Mysql_Obj.Room;
import javafx.scene.control.Alert;
import Mysql.Dao.Room_Panel_Dao;

public class Room_Panel_Dao_Impl extends Implement_Parent implements Room_Panel_Dao {
    @Override
    public boolean read_data(Vector<Room> arr_Room) {
        try {
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from room");
            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("room_id"),
                        rs.getInt("room_number"),
                        rs.getString("room_type"),
                        rs.getDouble("room_discount"),
                        rs.getDouble("room_deposit"),
                        rs.getInt("room_capacity"),
                        rs.getDouble("room_price"),
                        rs.getString("room_status"),
                        rs.getString("room_principal"),
                        rs.getString("room_description"));
                arr_Room.add(room);
            }
            // 6.释放资源
            if (rs != null) {
                pstm.close();
                rs.close();
            }
            return true;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常!");
            alert.showAndWait();
            return false;
        }
    }

    @Override
    public int add_data() {
        try {
            int id = -1;
            PreparedStatement pstm = conn.prepareStatement("insert into room() values()",
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
    public boolean delete_data(int room_id) {

        try {
            PreparedStatement pstm = conn.prepareStatement("delete from room where room_id=?");
            pstm.setInt(1, room_id);

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
    public boolean update_data(Room room) {
        try {
            PreparedStatement pstm = conn.prepareStatement(
                    "update room set room_number=?,room_type=?,room_discount=?,room_deposit=?,room_capacity=?,room_price=?,room_status=?,room_principal=?,room_description=? where room_id=?");
            pstm.setInt(1, room.getRoom_number());
            pstm.setString(2, room.getRoom_type());
            pstm.setDouble(3, room.getRoom_discount());
            pstm.setDouble(4, room.getRoom_deposit());
            pstm.setInt(5, room.getRoom_capacity());
            pstm.setDouble(6, room.getRoom_price());
            pstm.setString(7, room.getRoom_status());
            pstm.setString(8, room.getRoom_principal());
            pstm.setString(9, room.getRoom_description());
            pstm.setInt(10, room.getRoom_id());

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
    public boolean update_data(int room_id, String field, String value) {
        try {
            PreparedStatement pstm = conn.prepareStatement("update room set " + field + "=? where room_id=?");
            pstm.setString(1, value);
            pstm.setInt(2, room_id);

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
    public boolean select_data(Vector<Room> arr_Room, String sql_command, Room value, boolean id, boolean number,
            boolean type, boolean discount, boolean deposit, boolean capacity,
            boolean price, boolean status, boolean principal, boolean description) {
        try {
            //System.out.println(sql_command);
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement(sql_command);

            int cnt = 1;
            if (id) {
                pstm.setInt(cnt, value.getRoom_id());
                cnt++;
            }
            if (number) {
                pstm.setInt(cnt, value.getRoom_number());
                cnt++;
            }
            if (type) {
                pstm.setString(cnt, value.getRoom_type());
                cnt++;
            }
            if (discount) {
                pstm.setDouble(cnt, value.getRoom_discount());
                cnt++;
            }
            if (deposit) {
                pstm.setDouble(cnt, value.getRoom_deposit());
                cnt++;
            }
            if (capacity) {
                pstm.setInt(cnt, value.getRoom_capacity());
                cnt++;
            }
            if (price) {
                pstm.setDouble(cnt, value.getRoom_price());
                cnt++;
            }
            if (status) {
                pstm.setString(cnt, value.getRoom_status());
                cnt++;
            }
            if (principal) {
                pstm.setString(cnt, value.getRoom_principal());
                cnt++;
            }
            if (description) {
                pstm.setString(cnt, value.getRoom_description());
            }

            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                Room room = new Room(
                        rs.getInt("room_id"),
                        rs.getInt("room_number"),
                        rs.getString("room_type"),
                        rs.getDouble("room_discount"),
                        rs.getDouble("room_deposit"),
                        rs.getInt("room_capacity"),
                        rs.getDouble("room_price"),
                        rs.getString("room_status"),
                        rs.getString("room_principal"),
                        rs.getString("room_description"));
                arr_Room.add(room);
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
