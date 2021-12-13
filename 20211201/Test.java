import java.util.*;
/**
 * 题目要求的getDrink方法改为了更简单复用性更强的Taste类里的taste()静态方法实现
 * main()方法在Test类里
 */
public class Test {
    public static void main(String[] args) {
        System.out.println("请输入饮料类型(1:咖啡,2:啤酒,3:牛奶):");
        Scanner sc=new Scanner(System.in);
        Drink cup;
        try {
            int tp=sc.nextInt();
            cup=returntype(tp);//使用父类类型创建子类对象，实现多态
            cup.drink();//统一调用，这里使用了taste类里的静态方法，所以覆不覆写其实都可以
        }catch(DrinkNotFoundException e){
            System.err.println(e);
        } 
        catch (Exception e) {
            System.out.println("发生了其他错误哦！");
            System.err.println(e);
        }finally{
            System.out.println("Bye!");
        }
        sc.close();
    }
    public static Drink returntype(int tp) throws DrinkNotFoundException {
        Drink cls;
        switch (tp) {
            case 1:
                cls=new Coffee();
                return cls;
            case 2:
                cls=new Beer();
                return cls;
            case 3:
                cls=new Milk();
                return cls;
            default:
                throw new DrinkNotFoundException("对不起！没有您输入的饮料类型。");
        }
    } 
}
