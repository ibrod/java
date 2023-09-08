package Practice3;

public class Test {
    public static void main(String[] args) {
        Pet cat = new Cat("楠楠", 55, 0);
        cat.eat();
        cat.eat();

        System.out.println("--------------------");

        Pet dog = new Dog("欧欧", 79, 0);
        dog.eat();
        dog.eat();
    }
}
