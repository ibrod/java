
class Student{
    public Student(String name,String sex,int age,int weight){
        this.name=name;
        this.sex=sex;
        this.age=age;
        this.weight=weight;
    } 
    public Student(){

    }

    public void set_name(String name){
        this.name=name;
    }

    public void set_sex(String sex){
        this.sex=sex;
    }

    public void set_age(int age){
        if(age<0){
            age=0;
        }else{
            this.age=age;
        }
    }

    public void set_weight(int weight){
        if(weight<0){
            weight=0;
        }else{
            this.weight=weight;
        }
    }

    public void dining(){
        System.out.println(name+"在吃饭！");
    }

    public void walk(){
        System.out.println(name+"在走路！");
    }

    private String name;
    private String sex;
    private int age;
    private int weight;
}

class Teststudent{
    private static Student st;
    public static void init(){
        st=new Student("张三","男",17,100);
    }
    public static void display(){
        st.dining();
        st.walk();
    }
}


public class Student_System {
    public static void main(String[] args) {
        Teststudent.init();
        Teststudent.display();
    }
}
