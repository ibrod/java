package Model;

public class Gold extends Bus {
    public  Gold() {
        rantPerDay=899;
        brand="金杯";
        seatCount=16;
    }

    public  Gold(int rest) {
        this();
        this.rest = rest;
    }

    public  void setrest(int rest) {
        this.rest = rest;
    }

    public void check_rantPerDay() {
        System.out.println("金杯16座日租" + rantPerDay);
    }

    public void get_rest() {
        System.out.println("金杯16座剩余车辆:" + rest);
    }
}
