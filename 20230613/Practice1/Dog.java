package Practice1;

public class Dog extends Pet {
    
    private String strain;

    Dog(String name, int health, int love, String strain){
        super(name, health, love);
        this.strain = strain;
    }

    public String getInfo(){
        return super.getInfo()+"\n我是一只"+this.strain+"。";
    }
}
