package Mysql.Mysql_Obj;

public class User_Info {
    int user_id;
    String name;
    String gender;
    String phone_number;
    String Id_card;
    String email;
    int status;


    


    public User_Info(int user_id, String name, String gender, String phone_number, String id_card, String email) {
        this.user_id = user_id;
        this.name = name;
        this.gender = gender;
        this.phone_number = phone_number;
        Id_card = id_card;
        this.email = email;
    }

    public User_Info(String phone_number, String gender, String name, String Id_card, String email) {
        this.phone_number = phone_number;
        this.gender = gender;
        this.name = name;
        this.Id_card = Id_card;
        this.email = email;
        status = 0;
    }

    public String getId_card() {
        return Id_card;
    }

    public void setId_card(String id_card) {
        Id_card = id_card;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public User_Info(String phone_number, String gender, String name, String Id_card, String email, int status) {
        this.phone_number = phone_number;
        this.gender = gender;
        this.name = name;
        this.Id_card = Id_card;
        this.email = email;
        this.status = status;
    }

    public User_Info() {
        status = 0;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
