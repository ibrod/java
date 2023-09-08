package Practice1;
public class Pet{
    private String name;
    private int health;
    private int love;

    public String getInfo(){
        return "宠物的自白：\n我的名字叫" + this.name + ",健康值是" + this.health + ",和主人的亲密度是" + this.love + ".";
    }

    public Pet(String name, int health, int love){
        this.name = name;
        this.health = health;
        this.love = love;
    }

    public Pet(String name){
        this.name = name;
        this.health = 100;
        this.love = 0;
    }

    public Pet(){
        this.name = "无名氏";
        this.health = 100;
        this.love = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLove() {
        return love;
    }

    public void setLove(int love) {
        this.love = love;
    }

}