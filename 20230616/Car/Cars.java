package Car;

import java.util.Vector;

import Util.Pair;

public abstract class Cars {
    protected String carType;
    protected String id;
    protected String brand;
    protected Double rent;
    protected Vector<Pair<Integer, Double>> discount;// <Days, Discount>

    public abstract String getInfo();

    public Cars() {
    }

    public Cars(String carType, String id, String brand, Double rent, Vector<Pair<Integer, Double>> discount) {
        this.carType = carType;
        this.id = id;
        this.brand = brand;
        this.rent = rent;
        this.discount = discount;
    }

    public Cars(String carType, String id, String brand, Double rent) {
        this.carType = carType;
        this.id = id;
        this.brand = brand;
        this.rent = rent;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getRent(Integer nums, Integer days) {
        Double sum = this.rent * nums;
        this.discount.sort((a, b) -> b.first - a.first);
        for (Pair<Integer, Double> p : this.discount) {
            if (days >= p.first) {
                sum = days * this.rent * p.second * nums;
                break;
            }
        }
        return sum;
    }

    public Double getRent(Integer days) {
        Double sum = this.rent * days;
        this.discount.sort((a, b) -> b.first - a.first);
        for (Pair<Integer, Double> p : this.discount) {
            if (days >= p.first) {
                sum = days * this.rent * p.second;
                break;
            }
        }
        return sum;
    }

    public Double getRent() {
        return rent;
    }

    public void setRent(Double rent) {
        this.rent = rent;
    }

    public Vector<Pair<Integer, Double>> getDiscount() {
        return discount;
    }

    public void setDiscount(Vector<Pair<Integer, Double>> discount) {
        this.discount = discount;
    }

}