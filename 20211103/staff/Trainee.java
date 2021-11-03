package staff;

public class Trainee extends Staff {
    private int poi = 0;// 实习期

    public Trainee() {

    }

    public Trainee(String name, int salary, int extra, int poi) {
        setName(name);
        setSalary(salary);
        setExtra(extra);
        this.poi = poi;
    }

    public int getPoi() {
        return poi;
    }

    public void setPoi(int poi) {
        this.poi = poi;
    }

}
