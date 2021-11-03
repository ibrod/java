package staff;

public class Programmer extends Staff {
    private int aot = 0;// 平均加班时间

    public Programmer() {

    }

    public Programmer(String name, int salary, int extra, int aot) {
        setName(name);
        setSalary(salary);
        setExtra(extra);
        this.aot = aot;
    }

    public int getAot() {
        return aot;
    }

    public void setAot(int aot) {
        this.aot = aot;
    }

}
