package staff;

public class Manager extends Staff {
    private String sn = "无";// 经理助理

    public Manager() {

    }

    public Manager(String name, int salary, int extra, String addtion) {
        setName(name);
        setSalary(salary);
        setExtra(extra);
        setSn(addtion);
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

}
