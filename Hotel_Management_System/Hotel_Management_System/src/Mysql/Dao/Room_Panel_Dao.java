package Mysql.Dao;

import java.util.Vector;
import Mysql.Mysql_Obj.Room;

public interface Room_Panel_Dao {
    public boolean read_data(Vector<Room> arr_Room);

    public boolean select_data(Vector<Room> arr_Room, String sql_command,Room value,boolean id, boolean number, boolean type, boolean discount, boolean deposit, boolean capacity,
    boolean price, boolean status, boolean principal, boolean description);

    public int add_data();

    public boolean delete_data(int room_id);

    public boolean update_data(int room_id, String field, String value);

    public boolean update_data(Room room);
}
