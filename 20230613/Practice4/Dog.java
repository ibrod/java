package Practice4;

public class Dog extends Pet {
    public Dog(String name, int health, int love) {
        super(name, health, love);
    }

    public void catchingFrisbee(){
        super.addhealth(-10);
        super.addLove(20);
        System.out.println(
                "我是一只狗狗，我的名字叫" + super.getName() + "，我正在接飞盘。当前生命值为" + super.getHealth() + "，亲密度为" + super.getLove());
    }

}
