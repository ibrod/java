package Mysql.Implement;

import java.util.Vector;

import Mysql.Dao.Check_In_Manage_Dao;
import Mysql.Mysql_Obj.Check_In_Obj;

public class Check_In_Manage_Dao_Impl extends Implement_Parent implements Check_In_Manage_Dao {

    @Override
    public boolean select_data(Vector<Check_In_Obj> arr_User, Check_In_Obj value, boolean[] is_added) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public int add_data(String room_id, String id_card) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean delete_data(int id) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean update_data(int check_in_id, String field, String value) {
        // TODO Auto-generated method stub
        return false;
    }


}
    