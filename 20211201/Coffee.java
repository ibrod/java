
public class Coffee extends Drink {
    String brand;
    Coffee(){
        super(1,"咖啡");
    }
    public void drink() throws DrinkNotFoundException {
        System.out.println("咖啡类里的drink():");//覆写
        Taste.taste(id);
    };
}
