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

    public void rst() {
        System.out.println("管理部门目前人数为:" + idx);
    }

    public void del(String name) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (manager[idx].getName().equals(name)) {
                pos = idx;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人,删除失败");
        } else {
            for (int i = pos + 1; i < idx; i++) {
                manager[i - 1] = null;
                manager[i - 1] = manager[i];
            }
            idx--;
            System.out.println("删除成功,目前管理部门剩余人数为:" + idx);
        }
    }

    public void addx(String name, int salary, int extra, String addtion) {
        manager[idx] = new Manager(name, salary, extra, addtion);
        idx++;
    }

    public void editx(String name, int salary, int extra, String addtion) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (manager[idx].getName().equals(name)) {
                pos = idx;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人,修改失败");
        } else {
            manager[idx].setSalary(salary);
            manager[idx].setExtra(extra);
            manager[idx].setSn(addtion);
            System.out.println("修改成功");
        }
    }

    public void liststaff() {
        // System.out.println("数量"+idx);
        rst();
        for (int i = 0; i < idx; i++) {
            System.out.println("姓名:" + manager[i].getName() + " 部门:管理部" + " 年薪:" + manager[i].getSalary()
                    + " 额外工资(奖金,加班费，额外补贴等):" + manager[i].getExtra() + " 经理助理：" + manager[i].getSn());
        }
    }

}
