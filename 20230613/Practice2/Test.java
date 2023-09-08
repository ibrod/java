package Practice2;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("张三", "001", 18);
        Student s2 = new Student("张三", "001", 18);
        Student s3 = new Student("李四", "002", 18);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
    }
}
