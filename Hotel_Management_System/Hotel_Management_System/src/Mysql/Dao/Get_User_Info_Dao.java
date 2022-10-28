package Mysql.Dao;

import Mysql.Mysql_Obj.User_Info;

public interface Get_User_Info_Dao {
    public User_Info get_user_info(String phone);
}
