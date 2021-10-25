    package PG;
    class Pet {
        public void cry() {

        }
        public void eat() {

        }
    }

    class Dog extends Pet {
        public Dog(){
            System.out.println("养了一只狗");
        }
        public void guardEntrance(){
            System.out.println("狗正在看门");
        }
        public void eat() {
            System.out.println("狗啃了一根骨头");
        }
        public void cry() {
            System.out.println("汪汪!");
        }
    }

    class Cat extends Pet {
        public Cat(){
            System.out.println("养了一只猫");
        }

        public void eat() {
            System.out.println("猫吃了鱼");
        }
        public void cry() {
            System.out.println("喵喵！");
        }
        public void huntMice(){
            System.out.println("猫正在抓老鼠");
        }
    }

    public class TEST{
        public static void main(String[] args) {
            Pet pet1=new Dog();
            Dog dog;
            pet1.cry();
            pet1.eat();
            dog=(Dog)pet1;
            dog.guardEntrance();

            Pet pet2=new Cat();
            Cat cat;
            pet2.cry();
            pet2.eat();
            cat=(Cat)pet2;
            cat.huntMice();


            show(pet1);
            show(pet2);
        }


        public static void show(Pet a)  {
            a.eat();  
            // 类型判断
            if (a instanceof Cat)  {  
                Cat c = (Cat)a;  
                c.huntMice();  
            } else if (a instanceof Dog) { 
                Dog c = (Dog)a;  
                c.guardEntrance();  
            }  
        }  

    }