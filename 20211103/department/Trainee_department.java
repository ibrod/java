package department;

import staff.Trainee;

public class Trainee_department implements IAbstract_department {
    Trainee[] trainee = new Trainee[100005];
    private int idx = 0;

    public void addstaff(int cdep, String name) {
        trainee[idx] = new Trainee();
        trainee[idx].setName(name);
        trainee[idx].setDepartment(cdep);
        idx++;
        System.out.println("添加完成!");
    }

    public void addx(String name,int salary,int extra,String addtion){
        
    }

    public void liststaff() {
        //System.out.println("数量"+idx);
        for (int i = 0; i < idx; i++) {
            System.out.println("姓名:" + trainee[i].getName() + " 部门:实习部" + " 年薪:" + trainee[i].getSalary()
                  +" 额外工资(奖金,加班费，额外补贴等):"+trainee[i].getExtra() + " 实习期:" + trainee[i].getPoi());
        }
    }
}