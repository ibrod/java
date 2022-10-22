package code;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Food {// 创建Food类, 为后面绑定表格表头做好工作
    private IntegerProperty order;// 序号
    private StringProperty name;// 菜名
    private IntegerProperty price;// 价格

    public Food(int order, String name, int price) {// 写构造
        this.order = new SimpleIntegerProperty(order);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleIntegerProperty(price);
    }

    public Food() {
        this.order = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.price = new SimpleIntegerProperty();
    }// 保留默认构造

    public int getOrder() {
        return order.get();
    }

    public String getName() {
        return name.get();
    }

    public int getPrice() {
        return price.get();
    }

}