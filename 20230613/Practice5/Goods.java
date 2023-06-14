package Practice5;

public class Goods {
    private String name;
    private double price;
    
    public Goods(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Goods(){
        this.name = "无名氏";
        this.price = 0.0;
    }

    public String getInfo(){
        return "商品名称：" + this.name + "，商品价格：" + this.price;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    
}
