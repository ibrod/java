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

    public void rst() {
        System.out.println("实习部门目前人数为:" + idx);
    }

    public void ads(String name, int extra) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (trainee[i].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人");
        } else {
            trainee[pos].setExtra(extra);
            System.out.println("调整成功!");
        }
    }

    public boolean showstaff(String name) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (trainee[i].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            return false;
        } else {
            int i = pos;
            System.out.println("姓名:" + trainee[i].getName() + " 部门:实习部" + " 年薪:" + trainee[i].getSalary()
                    + " 额外工资(奖金,加班费，额外补贴等):" + trainee[i].getExtra() + " 实习期:" + trainee[i].getPoi());
        }
        return true;
    }

    public void del(String name) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (trainee[i].getName().equals(name)) {
                pos = idx;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人,删除失败");
        } else {
            for (int i = pos + 1; i < idx; i++) {
                trainee[i - 1] = null;
                trainee[i - 1] = trainee[i];
            }
            idx--;
            System.out.println("删除成功,目前实习部门剩余人数为:" + idx);
        }
    }

    public void editx(String name, int salary, int extra, String addtion) {
        int pos = -1;
        for (int i = 0; i < idx; i++) {
            if (trainee[idx].getName().equals(name)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("查无此人,修改失败");
        } else {
            trainee[pos].setSalary(salary);
            trainee[pos].setExtra(extra);
            trainee[pos].setPoi(Integer.parseInt(addtion));
            System.out.println("修改成功");
        }
    }

    public void addx(String name, int salary, int extra, String addtion) {
        trainee[idx] = new Trainee(name, salary, extra, Integer.parseInt(addtion));
        idx++;
    }

    public void liststaff() {
        // System.out.println("数量"+idx);
        rst();
        for (int i = 0; i < idx; i++) {
            System.out.println("姓名:" + trainee[i].getName() + " 部门:实习部" + " 年薪:" + trainee[i].getSalary()
                    + " 额外工资(奖金,加班费，额外补贴等):" + trainee[i].getExtra() + " 实习期:" + trainee[i].getPoi());
        }
    }
}