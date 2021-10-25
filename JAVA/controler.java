import java.util.Scanner;

class Person {
    protected double salary;
    protected String name;
    protected String sex;
    protected String id;

    public Person() {
    }

    public Person(double salary, String name, String sex, String id) {
        this.salary = salary;
        this.name = name;
        this.sex = sex;
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

class Teacher extends Person {
    protected int teacherint_hours;
    protected String title;

    public Teacher() {
    }

    public Teacher(int teacherint_hours, String title) {
        this.teacherint_hours = teacherint_hours;
        this.title = title;
    }

    public Teacher(double salary, String name, String sex, String id, int teacherint_hours, String title) {
        super(salary, name, sex, id);
        this.teacherint_hours = teacherint_hours;
        this.title = title;
    }

    public int getTeacherint_hours() {
        return teacherint_hours;
    }

    public void setTeacherint_hours(int teacherint_hours) {
        this.teacherint_hours = teacherint_hours;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    void pay() {
        switch (title) {
            case "教授":
                salary = teacherint_hours * 150 + 5000;
                break;
            case "副教授":
                salary = teacherint_hours * 120 + 4000;
                break;
            case "讲师":
                salary = teacherint_hours * 100 + 3000;
                break;
            case "助教":
                salary = teacherint_hours * 80 + 2000;
                break;
            default:
                break;
        }
        System.out.println("工资为:"+salary);
    }

}

class Staff extends Person {
    String position;

    public Staff() {
    }

    public Staff(String position) {
        this.position = position;
    }

    public Staff(double salary, String name, String sex, String id, String position) {
        super(salary, name, sex, id);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    void pay() {
        switch (position) {
            case "院级":
                salary=8000;
                break;
            case "处级":
                salary=6800;
                break;
            case "科级":
                salary=6600;
                break;
            case "一般工作人员":
                salary=5000;
                break;
            default:
                break;
        }
        System.out.println("工资为:" + salary);
    }
}



public class controler {
    public static void main(String[] args) {
        Teacher tc=new Teacher();
        Staff stf=new Staff();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入职称:");
        String title=sc.next();
        tc.setTitle(title);
        System.out.println("请输入课时");
        int ts=sc.nextInt();
        tc.setTeacherint_hours(ts);
        tc.pay();

        System.out.println("现计算公职人员工资,请输入职称:");
        title=sc.next();
        stf.setPosition(title);
        stf.pay();
    }
};