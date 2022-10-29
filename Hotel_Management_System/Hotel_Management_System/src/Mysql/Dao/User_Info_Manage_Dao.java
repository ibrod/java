package Mysql.Dao;

import Mysql.Mysql_Obj.User_Info;

public interface User_Info_Manage_Dao {
    public User_Info get_user_info(String phone);
    public boolean update(User_Info user_Info);
    public boolean insert_by_phone(String phone);
}
