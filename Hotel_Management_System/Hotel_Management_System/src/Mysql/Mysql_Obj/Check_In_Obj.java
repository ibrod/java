package Mysql.Mysql_Obj;

import java.sql.Date;

public class Check_In_Obj {
    int check_in_id;
    int user_id;
    int room_id;
    String id_card;
    Date in_time;
    Date out_time;
    double pledge;
    double payment;
    String note;
    
    public Check_In_Obj() {
    }

    public Check_In_Obj(int check_in_id, int user_id, int room_id, String id_card, Date in_time, Date out_time,
            double pledge, double payment, String note) {
        this.check_in_id = check_in_id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.id_card = id_card;
        this.in_time = in_time;
        this.out_time = out_time;
        this.pledge = pledge;
        this.payment = payment;
        this.note = note;
    }
    
    public int getCheck_in_id() {
        return check_in_id;
    }
    public void setCheck_in_id(int check_in_id) {
        this.check_in_id = check_in_id;
    }
    public int getUser_id() {
        return user_id;
    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public int getRoom_id() {
        return room_id;
    }
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }
    public String getId_card() {
        return id_card;
    }
    public void setId_card(String id_card) {
        this.id_card = id_card;
    }
    public Date getIn_time() {
        return in_time;
    }
    public void setIn_time(Date in_time) {
        this.in_time = in_time;
    }
    public Date getOut_time() {
        return out_time;
    }
    public void setOut_time(Date out_time) {
        this.out_time = out_time;
    }
    public double getPledge() {
        return pledge;
    }
    public void setPledge(double pledge) {
        this.pledge = pledge;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    
}
