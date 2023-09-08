package Center;

public class ConsumInfo {
    String type;
    Double consumData;

    String unit="";
    double consumAmount;

    public ConsumInfo() {
    }

    public ConsumInfo(String type, Double consumData, double consumAmount) {
        this.type = type;
        this.consumData = consumData;
        this.consumAmount = consumAmount;
        this.unit="单位";
    }

    public ConsumInfo(String type, double consumAmount) {
        this.type = type;
        this.consumData=1.0;
        this.consumAmount = consumAmount;
    }

    public ConsumInfo(String type, double consumData, String unit, double consumAmount) {
        this.type = type;
        this.consumData = consumData;
        this.unit = unit;
        this.consumAmount = consumAmount;
    }

    public String getInform(){
        return "消费类型:"+type+", 消费数量:"+consumData+unit+", 产生的消费金额:"+consumAmount+"元";
    }

    public String getType() {
        return type;
    }

    public double getConsumData() {
        return consumData;
    }

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setConsumData(Double consumData) {
        this.consumData = consumData;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }
}
