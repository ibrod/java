package Mysql.Mysql_Obj;

public class History {
    int history_id;
    int user_id;
    int room_id;
    String in_time;
    String out_time;
    double payment;
    String note;
    int room_number;
    String name;
    String id_card;
    String phone;
    
    public History() {
    }

    public History(int history_id, int user_id, int room_id, String in_time, String out_time, double payment,
            String note, int room_number, String name, String id_card, String phone) {
        this.history_id = history_id;
        this.user_id = user_id;
        this.room_id = room_id;
        this.in_time = in_time;
        this.out_time = out_time;
        this.payment = payment;
        this.note = note;
        this.room_number = room_number;
        this.name = name;
        this.id_card = id_card;
        this.phone = phone;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public History(int user_id, int room_id, String in_time, String out_time, double payment, String note) {
        this.user_id = user_id;
        this.room_id = room_id;
        this.in_time = in_time;
        this.out_time = out_time;
        this.payment = payment;
        this.note = note;
    }

    public History(int history_id, int user_id, int room_id, String in_time, String out_time, double payment, String note) {
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
    public String getIn_time() {
        return in_time;
    }
    public void setIn_time(String in_time) {
        this.in_time = in_time;
    }
    public String getOut_time() {
        return out_time;
    }
    public void setOut_time(String out_time) {
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
