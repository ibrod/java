package department;

public interface IAbstract_department{
    void addstaff(int cdep,String name);
    void liststaff();
    void addx(String name,int salary,int extra,String addtion);//[姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [实习期]
    void del(String name);
    void rst();
    void editx(String name,int salary,int extra,String addtion);
    void ads(String name);
    void showstaff(String name);
}