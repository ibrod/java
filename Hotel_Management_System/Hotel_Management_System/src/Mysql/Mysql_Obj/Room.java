package Mysql.Mysql_Obj;

public class Room {
    int room_id;
    int room_number;
    int room_type;//房间类型,1标准间,2大床房,3豪华套房
    double room_discount;
    double room_deposit;//押金
    int room_capacity;
    double room_price;
    int room_status;// 房间状态码0空闲1预定2入住3到期4清扫5维修
    String room_principal;// 房间负责人
    String room_description;// 房间描述
    
    public Room(int room_id, int room_number, int room_type, double room_discount, double room_deposit,
            int room_capacity, double room_price, int room_status, String room_principal, String room_description) {
        this.room_id = room_id;
        this.room_number = room_number;
        this.room_type = room_type;
        this.room_discount = room_discount;
        this.room_deposit = room_deposit;
        this.room_capacity = room_capacity;
        this.room_price = room_price;
        this.room_status = room_status;
        this.room_principal = room_principal;
        this.room_description = room_description;
    }
    
    public Room(int room_number, int room_type, double room_discount, double room_deposit, int room_capacity,
            double room_price, int room_status, String room_principal, String room_description) {
        this.room_number = room_number;
        this.room_type = room_type;
        this.room_discount = room_discount;
        this.room_deposit = room_deposit;
        this.room_capacity = room_capacity;
        this.room_price = room_price;
        this.room_status = room_status;
        this.room_principal = room_principal;
        this.room_description = room_description;
    }

    public Room() {
    }
    public int getRoom_id() {
        return room_id;
    }
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    public int getRoom_number() {
        return room_number;
    }
    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }
    public int getRoom_type() {
        return room_type;
    }
    public void setRoom_type(int room_type) {
        this.room_type = room_type;
    }
    public double getRoom_discount() {
        return room_discount;
    }
    public void setRoom_discount(double room_discount) {
        this.room_discount = room_discount;
    }
    public double getRoom_deposit() {
        return room_deposit;
    }
    public void setRoom_deposit(double room_deposit) {
        this.room_deposit = room_deposit;
    }
    public int getRoom_capacity() {
        return room_capacity;
    }
    public void setRoom_capacity(int room_capacity) {
        this.room_capacity = room_capacity;
    }
    public double getRoom_price() {
        return room_price;
    }
    public void setRoom_price(double room_price) {
        this.room_price = room_price;
    }
    public int getRoom_status() {
        return room_status;
    }
    public void setRoom_status(int room_status) {
        this.room_status = room_status;
    }
    public String getRoom_principal() {
        return room_principal;
    }
    public void setRoom_principal(String room_principal) {
        this.room_principal = room_principal;
    }
    public String getRoom_description() {
        return room_description;
    }
    public void setRoom_description(String room_description) {
        this.room_description = room_description;
    }
    
}
