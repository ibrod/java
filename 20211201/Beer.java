
public class Beer extends Drink {
    String color;
    Beer(){
        super(2,"啤酒");
    }
    public void drink() throws DrinkNotFoundException {
        System.out.println("啤酒类里的drink():");//覆写
        Taste.taste(id);
    };
}
