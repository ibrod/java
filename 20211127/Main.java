import java.util.*;
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int age) {
        this.age = age;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if(age>150||age<0){
            throw new Exception("年龄输入有问题啊！！！");
        }
        System.out.println("设置成功！");
        this.age = age;
    }

}


public class Main {
    public static void main(String[] args) {
        Student st=new Student();
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("请输入姓名");
            st.setName(sc.next());
            System.out.println("请输入年龄");
            st.setAge(sc.nextInt());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Try end");
        }
        System.out.println("good bye");// 主动捕捉到了异常程序会继续执行，若没有捕捉到，则不执行
    }
}
