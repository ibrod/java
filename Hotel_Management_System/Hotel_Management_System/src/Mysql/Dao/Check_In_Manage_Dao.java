package Mysql.Dao;

import java.util.Vector;

import Mysql.Mysql_Obj.Check_In_Obj;

public interface Check_In_Manage_Dao {

    public boolean select_data(Vector<Check_In_Obj> arr_User,Check_In_Obj value,boolean[] is_added);

    public int add_data(String room_id,String id_card);

    public boolean delete_data(int id);

    public boolean update_data(int check_in_id, String field, String value);

}
