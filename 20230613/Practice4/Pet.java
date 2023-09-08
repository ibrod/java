package Practice4;

public abstract class Pet {
    private String name;
    private int health;
    private int love;

    public void addhealth(int num) {
        if (this.health + num > 100) {
            this.health = 100;
        } else {
            this.health += num;
        }
    }

    public void addLove(int num) {
        if (this.love + num > 100) {
            this.love = 100;
        } else {
            this.love += num;
        }
    }

    public Pet(String name, int health, int love) {
        this.name = name;
        this.health = health;
        this.love = love;
    }

    public Pet(String name) {
        this.name = name;
        this.health = 100;
        this.love = 0;
    }

    public Pet() {
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