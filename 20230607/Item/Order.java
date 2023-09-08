package Item;

import java.util.Date;
import java.util.List;

public class Order {
   private long id;
    private double total;
    private Date date;
    List<OrderItem> orderItems;
    public Order() {
    }
    
    public Order(long id, double total, Date date, List<OrderItem> orderItems) {
        this.id = id;
        this.total = total;
        this.date = date;
        this.orderItems = orderItems;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public long getId() {
        return id;
    }
    public double getTotal() {
        return total;
    }
    public Date getDate() {
        return date;
    }
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }


    
}
