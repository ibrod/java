package Reflection;

public class Person {

    public String name;//使用Field类的get方法获取成员变量的值,要求不能为private
    private int age;
    Person(){
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public void setAge(int age) {
        this.age = age;
    }
}