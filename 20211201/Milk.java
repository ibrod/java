public class Milk extends Drink {
    String state;
    Milk(){
        super(3,"牛奶");
    }
    public void drink() throws DrinkNotFoundException {
        System.out.println("牛奶类里的drink():");//覆写
        Taste.taste(id);
    };
}
