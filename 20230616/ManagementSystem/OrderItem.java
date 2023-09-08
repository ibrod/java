package ManagementSystem;

import java.util.Vector;

public class OrderItem {
    public String id;
    public String name;
    public Integer num;
    public Integer days;
    public Double money;
    public Vector<String> license = new Vector<String>();

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

    public OrderItem() {
    }

    public String getInfo() {
        String msg = "ID车型号:" + this.id + "   品牌:" + this.name + "   数量:" + this.num + "   天数:" + this.days + "   金额:"
                + this.money + "\n";
        msg+="车辆具体信息如下:";
        for (String license : this.license) {
            msg+="\n车牌号:"+license;
        }
        msg+="\n";
        return msg;
    }

}
