public class Person {
    private double salary;
    public String name;
    private int age;
    public Person(){}
    public Person(double salary, String name, int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}
