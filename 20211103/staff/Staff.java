package staff;

public class Staff {
    private String name;
    private int salary;
    private int department;// 1表示实习部，2表示开发部，3表示管理部

    public String getName() {
        return name;
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
