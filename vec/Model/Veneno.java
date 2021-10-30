package Model;

public class Veneno extends Car {
    public Veneno() {
        rantPerDay=5998;
        brand="兰博基尼";
        type="Veneno";
    }

    public Veneno(int rest) {
        this();
        this.rest = rest;
    }
    
    public void setrest(int rest){
        this.rest=rest;
    }

    public void check_rantPerDay(){
        System.out.println("兰博基尼Veneno日租"+rantPerDay);
    }

    public void get_rest(){
        System.out.println("兰博基尼Veneno剩余车辆:"+rest);
    }
    


}
