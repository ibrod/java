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

    public void rst() {
        System.out.println("开发部门目前人数为:" + idx);
    }

    public boolean ups(String name) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (programmer[i].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return false;
        } else {
            programmer[pos].setSalary(programmer[pos].getSalary() * 3 / 2);
            System.out.println("晋升成功,薪水提高至以前的1.5倍。" + "姓名:" + name + " 当前薪水:" + programmer[pos].getSalary());
        }
        return true;
    }

    public boolean showstaff(String name) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (programmer[i].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return false;
        } else {
            int i = pos;
            System.out.println("姓名:" + programmer[i].getName() + " 部门:开发部" + " 年薪:" + programmer[i].getSalary()
                    + " 额外工资(奖金,加班费，额外补贴等):" + programmer[i].getExtra() + " 平均加班时间:" + programmer[i].getAot());
        }
        return true;
    }

    public void ads(String name, int extra) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (programmer[i].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人");
        } else {
            programmer[pos].setExtra(extra);
            System.out.println("调整成功!");
        }
    }

    public void del(String name) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (programmer[i].getName().equals(name)) {
                pos = idx;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人,删除失败");
        } else {
            for (int i = pos + 1; i < idx; i++) {
                programmer[i - 1] = null;
                programmer[i - 1] = programmer[i];
            }
            idx--;
            System.out.println("删除成功,目前开发部门剩余人数为:" + idx);
        }
    }

    public void editx(String name, int salary, int extra, String addtion) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (programmer[i].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人,修改失败");
        } else {
            programmer[pos].setSalary(salary);
            programmer[pos].setExtra(extra);
            programmer[pos].setAot(Integer.parseInt(addtion));
            System.out.println("修改成功");
        }
    }

    public void addx(String name, int salary, int extra, String addtion) {
        programmer[idx] = new Programmer(name, salary, extra, Integer.parseInt(addtion));
        idx++;
    }

    public void liststaff() {
        // System.out.println("数量"+idx);
        rst();
        for (int i = 0; i < idx; i++) {
            System.out.println("姓名:" + programmer[i].getName() + " 部门:开发部" + " 年薪:" + programmer[i].getSalary()
                    + " 额外工资(奖金,加班费，额外补贴等):" + programmer[i].getExtra() + " 平均加班时间:" + programmer[i].getAot());
        }
    }
}