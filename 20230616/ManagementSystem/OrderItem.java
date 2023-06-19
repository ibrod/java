package ManagementSystem;

public class OrderItem {
    public String id;
    public String name;
    public Integer num;
    public Integer days;
    public Double money;

    public OrderItem(String id, Integer num, Integer days, Double money) {
        this.id = id;
        this.num = num;
        this.days = days;
        this.money = money;
    }

    public OrderItem(String id, String name, Integer num, Integer days, Double money) {
        this.id = id;
        this.name = name;
        this.num = num;
        this.days = days;
        this.money = money;
    }

     public OrderItem(){}

     public String getInfo(){
            return "ID号:"+this.id+"   品牌:"+this.name+"   数量:"+this.num+"   天数:"+this.days+"   金额:"+this.money+"\n";
     }

}
