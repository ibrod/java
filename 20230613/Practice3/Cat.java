package Practice3;

public class Cat extends Pet {
    public Cat(String name, int health, int love) {
        super(name, health, love);
    }

    @Override
    public void eat() {
        super.addhealth(20);
        super.addLove(5);
        System.out.println(
                "我是一只猫，我的名字叫" + super.getName() + "，我吃了一条鱼。当前生命值为" + super.getHealth() + "，亲密度为" + super.getLove());
    }

}
