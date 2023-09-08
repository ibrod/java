package Practice3;

public class Dog extends Pet {
    public Dog(String name, int health, int love) {
        super(name, health, love);
    }

    @Override
    public void eat() {
        super.addhealth(20);
        super.addLove(5);
        System.out.println(
                "我是一只狗狗，我的名字叫" + super.getName() + "，我啃了一根骨头。当前生命值为" + super.getHealth() + "，亲密度为" + super.getLove());
    }
}
