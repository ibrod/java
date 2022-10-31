package Mysql.Dao;

import java.util.Vector;

import Mysql.Mysql_Obj.User_Info;

public interface User_Info_Manage_Dao {
    public User_Info get_user_info(String phone);
    public boolean update_by_phone(User_Info user_Info);
    public boolean update_by_id(int id,User_Info user_Info,boolean is_add[]);
    public boolean insert_by_phone(String phone);
    public int insert_by_id();
    public boolean delete_by_id(int id);
}
