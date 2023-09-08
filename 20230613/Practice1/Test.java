package Practice1;

public class Test {
    public static void main(String[] args) {
        Pet dog = new Dog("欧欧", 100, 0, "雪娜瑞犬");
        Pet cat = new Cat("楠楠", 100, 0, "Q妹");
        System.out.println(dog.getInfo());
        System.out.println("--------------------");
        System.out.println(cat.getInfo());
    }
}
