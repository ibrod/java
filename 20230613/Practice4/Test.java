package Practice4;

public class Test {
    public static void main(String[] args) {
        Pet Pdog=new Dog("欧欧",100,0);
        Dog dog=(Dog)Pdog;
        dog.catchingFrisbee();

        System.out.println("--------------------");

        Pet Ppenguin=new Penguin("楠楠",100,0);
        Penguin penguin=(Penguin)Ppenguin;
        penguin.swimming();

    }
}
