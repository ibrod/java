package Mysql.Dao;

import java.util.Vector;

import Mysql.Mysql_Obj.History;

public interface History_Dao {
    public boolean select_data(Vector<History> arr_record,History value,boolean[] is_added);

    public int add_data(History value);

    public boolean delete_data(int id);
}
