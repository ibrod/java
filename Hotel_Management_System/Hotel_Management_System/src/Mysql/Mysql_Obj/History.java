package Mysql.Mysql_Obj;

import java.sql.Date;

public class History {
    int history_id;
    int user_id;
    int room_id;
    Date in_time;
    Date out_time;
    double payment;
    String note;
    
    public History() {
    }

    public History(int user_id, int room_id, Date in_time, Date out_time, double payment, String note) {
        this.user_id = user_id;
        this.room_id = room_id;
        this.in_time = in_time;
        this.out_time = out_time;
        this.payment = payment;
        this.note = note;
    }

    public History(int history_id, int user_id, int room_id, Date in_time, Date out_time, double payment, String note) {
        this.history_id = history_id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.in_time = in_time;
        this.out_time = out_time;
        this.payment = payment;
        this.note = note;
    }
    
    public int getHistory_id() {
        return history_id;
    }
    public void setHistory_id(int history_id) {
        this.history_id = history_id;
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
