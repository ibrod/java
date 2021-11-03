package department;

import staff.Programmer;

public class Programmer_department implements IAbstract_department {
    Programmer[] programmer = new Programmer[100005];
    private int idx = 0;

    public void addstaff(int cdep, String name) {
        programmer[idx] = new Programmer();
        programmer[idx].setName(name);
        programmer[idx].setDepartment(cdep);
        idx++;
        System.out.println("添加完成!");
    }
    public void addx(String name,int salary,int extra,String addtion){
        
    }
    public void liststaff() {
        // System.out.println("数量"+idx);
        for (int i = 0; i < idx; i++) {
            System.out.println("姓名:" + programmer[i].getName() + " 部门:开发部" + " 年薪:" + programmer[i].getSalary()
                    + " 额外工资(奖金,加班费，额外补贴等):" + programmer[i].getExtra() + " 平均加班时间:" + programmer[i].getAot());
        }
    }
}