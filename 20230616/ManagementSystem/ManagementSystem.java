package ManagementSystem;

import java.util.HashMap;
import java.util.Vector;

import Car.Bus;
import Car.Sedan;
import Util.Pair;

public class ManagementSystem {
    HashMap<String, Pair<Bus, Vector<String>>> busInventory = new HashMap<String, Pair<Bus, Vector<String>>>();
    HashMap<String, Pair<Sedan, Vector<String>>> sedanInventory = new HashMap<String, Pair<Sedan, Vector<String>>>();
    // <Id,Pair<Cars,Vector<车牌号>>>
    Vector<OrderItem> busOrders = new Vector<OrderItem>();
    Vector<OrderItem> sedanOrders = new Vector<OrderItem>();
    Double money = 0.0;

    public ManagementSystem() {
    }

    public void addBus(Bus bus, Vector<String> vectorOfBUs) {
        if (busInventory.containsKey(bus.getId())) {
            Pair<Bus, Vector<String>> p = busInventory.get(bus.getId());
            p.second.addAll(vectorOfBUs);
            busInventory.put(bus.getId(), p);
        } else {
            Pair<Bus, Vector<String>> p = new Pair<Bus, Vector<String>>(bus, vectorOfBUs);
            busInventory.put(bus.getId(), p);
        }
    }

    public void addSedan(Sedan sedan, Vector<String> vectorOfSedan) {
        if (sedanInventory.containsKey(sedan.getId())) {
            Pair<Sedan, Vector<String>> p = sedanInventory.get(sedan.getId());
            p.second.addAll(vectorOfSedan);
            sedanInventory.put(sedan.getId(), p);
        } else {
            Pair<Sedan, Vector<String>> p = new Pair<Sedan, Vector<String>>(sedan, vectorOfSedan);
            sedanInventory.put(sedan.getId(), p);
        }
    }

    public String rentBus(String id, Integer num, Integer days) {
        if (busInventory.containsKey(id)) {
            Pair<Bus, Vector<String>> p = busInventory.get(id);
            if (p.second.size() >= num) {
                busInventory.put(id, p);
                Double money = p.first.getRent(days) * num;
                OrderItem order = new OrderItem(id, p.first.getBrand(), num, days, money);
                for (int i = 0; i < num; i++) {
                    // 高效删除末尾元素
                    order.license.add(p.second.get(p.second.size() - 1));
                    p.second.remove(p.second.size() - 1);
                }
                busOrders.add(order);
                this.money += money;
                String msg="租车成功,总共花费" + money + "元,车辆具体信息如下";
                for (String license : order.license) {
                    msg+="\n车牌号:"+license;
                }
                return msg;
            } else {
                return "库存不足";
            }
        } else {
            return "无此车辆";
        }
    }

    public String rentSedan(String id, Integer num, Integer days) {
        if (sedanInventory.containsKey(id)) {
            Pair<Sedan, Vector<String>> p = sedanInventory.get(id);
            if (p.second.size() >= num) {
                sedanInventory.put(id, p);
                Double money = p.first.getRent(days) * num;
                OrderItem order = new OrderItem(id, p.first.getBrand(), num, days, money);
                for (int i = 0; i < num; i++) {
                    // 高效删除末尾元素
                    order.license.add(p.second.get(p.second.size() - 1));
                    p.second.remove(p.second.size() - 1);
                }
                sedanOrders.add(order);
                this.money += money;
                String msg="租车成功,总共花费" + money + "元,车辆具体信息如下";
                for (String license : order.license) {
                    msg+="\n车牌号:"+license;
                }
                return msg;
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
            Pair<Bus, Vector<String>> p = busInventory.get(id);
            info += p.first.getInfo() + "库存:" + p.second.size() + ",具体车辆信息如下:\n";
            for (String license : p.second) {
                info += "车牌号:" + license + "\n";
            }
        }
        return info;
    }

    public String getSedanInventoryInfo() {
        String info = "";
        for (String id : sedanInventory.keySet()) {
            Pair<Sedan, Vector<String>> p = sedanInventory.get(id);
            info += p.first.getInfo() + "库存:" + p.second.size() + ",具体车辆信息如下:\n";
            for (String license : p.second) {
                info += "车牌号:" + license + "\n";
            }
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

    public HashMap<String, Pair<Bus, Vector<String>>> getBusInventory() {
        return busInventory;
    }

    public void setBusInventory(HashMap<String, Pair<Bus, Vector<String>>> busInventory) {
        this.busInventory = busInventory;
    }

    public HashMap<String, Pair<Sedan, Vector<String>>> getSedanInventory() {
        return sedanInventory;
    }

    public void setSedanInventory(HashMap<String, Pair<Sedan, Vector<String>>> sedanInventory) {
        this.sedanInventory = sedanInventory;
    }

}
