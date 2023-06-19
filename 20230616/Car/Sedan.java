package Car;

import java.util.Vector;

import Util.Pair;

public class Sedan extends Cars {
    protected String type;

    public Sedan() {
    }

    public Sedan(String carType, String id, String brand, Double rent, String type) {
        super(carType, id, brand, rent);
        this.type = type;
    }

    public Sedan(String carType, String id, String brand, Double rent, String type,
            Vector<Pair<Integer, Double>> discount) {
        super(carType, id, brand, rent, discount);
        this.type = type;
    }

    @Override
    public String getInfo() {
        String info = "车辆类型:" + this.carType + "   ID车型号:" + this.id + "   品牌:" + this.brand + "    日租金:" + this.rent + "   轿车类型:"
                + this.type + "   折扣:";
        for (Pair<Integer, Double> p : this.discount) {
            info += "\n" + p.first + "天   " + p.second + "折";
        }
        info += "\n";
        return info;
    }

}
