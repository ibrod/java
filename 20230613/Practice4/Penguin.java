package Practice4;

public class Penguin extends Pet {
    public Penguin(String name, int health, int love) {
        super(name, health, love);
    }

    public void swimming() {
        super.addhealth(-5);
        super.addLove(15);
        System.out.println(
                "我是一只企鹅，我的名字叫" + super.getName() + "，我正在游泳。当前生命值为" + super.getHealth() + "，亲密度为" + super.getLove());
    }

}
