package Mysql.Mysql_Obj;

public class Control_Panel_Obj {
    int surplus;
    int occupied;
    int user_num;
    int admin_num;
    public Control_Panel_Obj(int surplus, int occupied, int user_num, int admin_num) {
        this.surplus = surplus;
        this.occupied = occupied;
        this.user_num = user_num;
        this.admin_num = admin_num;
    }
    public int getSurplus() {
        return surplus;
    }
    public void setSurplus(int surplus) {
        this.surplus = surplus;
    }
    public int getOccupied() {
        return occupied;
    }
    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }
    public int getUser_num() {
        return user_num;
    }
    public void setUser_num(int user_num) {
        this.user_num = user_num;
    }
    public int getAdmin_num() {
        return admin_num;
    }
    public void setAdmin_num(int admin_num) {
        this.admin_num = admin_num;
    }
    
}
