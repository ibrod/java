package code;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Food {// 创建Food类, 为后面绑定表格表头做好工作
    private IntegerProperty order;// 序号
    private StringProperty name;// 菜名
    private FloatProperty price;// 价格

    public Food(int order, String name, Float price) {// 写构造
        this.order = new SimpleIntegerProperty(order);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleFloatProperty(price);
    }

    public Food() {
        this.order = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.price = new SimpleFloatProperty();
    }// 保留默认构造

    public int getOrder() {
        return order.get();
    }

    public String getName() {
        return name.get();
    }

    public float getPrice() {
        return price.get();
    }

}