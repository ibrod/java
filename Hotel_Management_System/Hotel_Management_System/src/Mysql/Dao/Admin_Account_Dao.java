package Mysql.Dao;

import Mysql.Mysql_Obj.Admin_Account;

public interface Admin_Account_Dao {
    public boolean init();

    public Admin_Account query(int idx);

    public boolean insert(Admin_Account Admin_Account);

    public boolean delete(String username);

    public boolean update(Admin_Account Admin_Account);

    public int count();
}