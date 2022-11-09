package Mysql.Dao;

import java.util.Vector;

import Mysql.Mysql_Obj.Reservation;

public interface Reservation_Dao {
    public boolean select_data(Vector<Reservation> arr_record,Reservation value,boolean[] is_added);

    public int add_data();

    public boolean delete_data(int id);

    public boolean update_data(int check_in_id, String field, String value);
}
