package ManagementSystem;

import java.util.HashMap;
import java.util.Vector;

import Car.Bus;
import Car.Sedan;
import Util.Pair;

public class ManagementSystem {
    HashMap<String, Pair<Bus, Integer>> busInventory = new HashMap<String, Pair<Bus, Integer>>();
    HashMap<String, Pair<Sedan, Integer>> sedanInventory = new HashMap<String, Pair<Sedan, Integer>>();
    // <Id,Pair<Cars,Inventory>>
    Vector<OrderItem> busOrders = new Vector<OrderItem>();
    Vector<OrderItem> sedanOrders = new Vector<OrderItem>();
    Double money = 0.0;

    public ManagementSystem() {
    }

    public ManagementSystem(HashMap<String, Pair<Bus, Integer>> busInventory,
            HashMap<String, Pair<Sedan, Integer>> sedanInventory, Vector<OrderItem> busOrders,
            Vector<OrderItem> sedanOrders, Double money) {
        this.busInventory = busInventory;
        this.sedanInventory = sedanInventory;
        this.busOrders = busOrders;
        this.sedanOrders = sedanOrders;
        this.money = money;
    }

    public void addBus(Bus bus, Integer num) {
        if (busInventory.containsKey(bus.getId())) {
            Pair<Bus, Integer> p = busInventory.get(bus.getId());
            p.second += num;
            busInventory.put(bus.getId(), p);
        } else {
            Pair<Bus, Integer> p = new Pair<Bus, Integer>(bus, num);
            busInventory.put(bus.getId(), p);
        }
    }

    public void addSedan(Sedan sedan, Integer num) {
        if (sedanInventory.containsKey(sedan.getId())) {
            Pair<Sedan, Integer> p = sedanInventory.get(sedan.getId());
            p.second += num;
            sedanInventory.put(sedan.getId(), p);
        } else {
            Pair<Sedan, Integer> p = new Pair<Sedan, Integer>(sedan, num);
            sedanInventory.put(sedan.getId(), p);
        }
    }

    public String rentBus(String id, Integer num, Integer days) {
        if (busInventory.containsKey(id)) {
            Pair<Bus, Integer> p = busInventory.get(id);
            if (p.second >= num) {
                p.second -= num;
                busInventory.put(id, p);
                Double money = p.first.getRent(days)*num;
                OrderItem order = new OrderItem(id, p.first.getBrand(), num, days, money);
                busOrders.add(order);
                this.money += money;
                return "租车成功,总共花费" + money + "元";
            } else {
                return "库存不足";
            }
        } else {
            return "无此车辆";
        }
    }

    public String rentSedan(String id, Integer num, Integer days) {
        if (sedanInventory.containsKey(id)) {
            Pair<Sedan, Integer> p = sedanInventory.get(id);
            if (p.second >= num) {
                p.second -= num;
                sedanInventory.put(id, p);
                Double money = p.first.getRent(days)*num;
                OrderItem order = new OrderItem(id, p.first.getBrand(), num, days, money);
                sedanOrders.add(order);
                this.money += money;
                return "租车成功,总共花费" + money + "元";
            } else {
                return "库存不足";
            }
        } else {
            return "无此车辆";
        }
    }

    public Double getMoney() {
        return this.money;
    }

    public String getBusInventoryInfo() {
        String info = "";
        for (String id : busInventory.keySet()) {
            Pair<Bus, Integer> p = busInventory.get(id);
            info += p.first.getInfo() + "库存:" + p.second + "\n";
        }
        return info;
    }

    public String getSedanInventoryInfo() {
        String info = "";
        for (String id : sedanInventory.keySet()) {
            Pair<Sedan, Integer> p = sedanInventory.get(id);
            info += p.first.getInfo() + "库存:" + p.second + "\n";
        }
        return info;
    }

    public String getBusOrderInfo() {
        String info = "";
        for (OrderItem order : busOrders) {
            info += order.getInfo();
        }
        return info;
    }

    public String getSedanOrderInfo() {
        String info = "";
        for (OrderItem order : sedanOrders) {
            info += order.getInfo();
        }
        return info;
    }

    public HashMap<String, Pair<Bus, Integer>> getBusInventory() {
        return busInventory;
    }

    public void setBusInventory(HashMap<String, Pair<Bus, Integer>> busInventory) {
        this.busInventory = busInventory;
    }

    public HashMap<String, Pair<Sedan, Integer>> getSedanInventory() {
        return sedanInventory;
    }

    public void setSedanInventory(HashMap<String, Pair<Sedan, Integer>> sedanInventory) {
        this.sedanInventory = sedanInventory;
    }

}
