package Practice1;

public class Cat extends Pet{
    private String gender;
    Cat(String name, int health, int love, String gender){
        super(name, health, love);
        this.gender = gender;
    }

    public String getInfo(){
        return super.getInfo()+"\n我的性别是"+gender+"。";
    }

}
