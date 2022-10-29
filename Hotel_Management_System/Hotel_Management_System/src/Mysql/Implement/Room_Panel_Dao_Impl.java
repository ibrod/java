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
                        rs.getInt("room_type"),
                        rs.getDouble("room_discount"),
                        rs.getDouble("room_deposit"),
                        rs.getInt("room_capacity"),
                        rs.getDouble("room_price"),
                        rs.getInt("room_status"),
                        rs.getString("room_principal"),
                        rs.getString("room_description"));
                arr_Room.add(room);
            }
            // 6.释放资源
            if (rs != null) {
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

}
