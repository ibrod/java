package staff;

public class Staff {
    protected String name;
    protected int salary = 0;
    protected int department = 0;// 1表示实习部，2表示开发部，3表示管理部
    protected int extra = 0;// 额外工资

    public String getName() {
        return name;
    }

    public int getExtra() {
        return extra;
    }

    public void setExtra(int extra) {
        this.extra = extra;
    }

    public Staff(String name, int department) {
        this.name = name;
        this.department = department;
    }

    public Staff() {
    }

    public Staff(String name, int salary, int department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public Staff(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
}
