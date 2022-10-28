package Mysql.Mysql_Obj;

public class User_Info {
    String phone_number;
    String gender;
    String name;
    String id;
    String email;
    int status;

    public User_Info(String phone_number, String gender, String name, String id, String email) {
        this.phone_number = phone_number;
        this.gender = gender;
        this.name = name;
        this.id = id;
        this.email = email;
        status = 0;
    }

    public User_Info(String phone_number, String gender, String name, String id, String email, int status) {
        this.phone_number = phone_number;
        this.gender = gender;
        this.name = name;
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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