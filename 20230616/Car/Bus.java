package Car;

import java.util.Vector;

import Util.Pair;

public class Bus extends Cars {
    private String name;

    public Bus() {
    }

    public Bus(String carType, String id, String brand, Double rent, String name) {
        super(carType, id, brand, rent);
        this.name = name;
    }

    public Bus(String carType, String id, String brand, Double rent, String name,
            Vector<Pair<Integer, Double>> discount) {
        super(carType, id, brand, rent, discount);
        this.name = name;
    }

    @Override
    public String getInfo() {
        String info = "车辆类型:" + this.carType + "   ID号:" + this.id + "   品牌:" + this.brand + "   日租金:" + this.rent + "   座位数:"
                + this.name + "   折扣:";
        for (Pair<Integer, Double> p : this.discount) {
            info += "\n" + p.first + "天   " + p.second + "折";
        }
        info += "\n";
        return info;
    }

}
