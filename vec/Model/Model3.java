package Model;

public class Model3 extends Car{
    public Model3() {
        rantPerDay=998;
        brand="特斯拉";
        type="model3";
    }

    public Model3(int rest) {
        this();
        this.rest = rest;
    }
    
    public void setrest(int rest){
        this.rest=rest;
    }

    public void check_rantPerDay(){
        System.out.println("特斯拉model3日租"+rantPerDay);
    }

    public void get_rest(){
        System.out.println("特斯拉model3剩余车辆:"+rest);
    }
}
