class Animal {
    private String name;

    public void Identify(){
        System.out.println("普通动物...");
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
};

class Cat extends Animal{

    public void Identify() {
        System.out.println("这是一只名叫"+getName()+"的猫");
    }
}

class Dog extends Animal{

    public void Identify() {
        System.out.println("这是一只名叫"+getName()+"的狗");
    }
}

public class zoo{
    public static void main(String[] args) {
        Animal cat=new Cat();
        cat.setName("小花");
        Animal dog=new Dog();
        dog.setName("豆豆");
        Animal animal=new Animal();
        animal.Identify();
        cat.Identify();
        dog.Identify();
    }
}