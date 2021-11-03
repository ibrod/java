package department;

import staff.Manager;

public class Manager_department implements IAbstract_department {
    Manager[] manager = new Manager[100005];
    private int idx = 0;

    public void addstaff(int cdep, String name) {
        manager[idx] = new Manager();
        manager[idx].setName(name);
        manager[idx].setDepartment(cdep);
        idx++;
        System.out.println("添加完成!");
    }
    public void addx(String name,int salary,int extra,String addtion){
        manager[idx] = new Manager();
        
    }

    public void liststaff() {
        //System.out.println("数量"+idx);
        for (int i = 0; i < idx; i++) {
            System.out.println("姓名:" + manager[i].getName() + " 部门:管理部" + " 年薪:" + manager[i].getSalary() 
            +" 额外工资(奖金,加班费，额外补贴等):"+manager[i].getExtra() +" 经理助理："+ manager[i].getSn());
        }
    }


}
