package Service;
import Model.*;

public class data_controler {
    public static Veneno veneno=new Veneno(10);
    public static Model3 model3=new Model3(50);
    public static Gold gold=new Gold(30);
    
    public static void list_all(){
        System.out.println("小型车类:");
        System.out.println("兰博基尼:");
        veneno.check_rantPerDay();
        veneno.get_rest();
        System.out.println("特斯拉:");
        model3.check_rantPerDay();
        model3.get_rest();
        System.out.println("大型车类:");
        System.out.println("金杯:");
        gold.check_rantPerDay();
        gold.get_rest();

    }

    public static void rent(String tp,int num,int days){
        switch(tp){
            case "Veneno":
            if(veneno.rest>=num){
                System.out.println("租车成功，总计租金为"+veneno.calRent(days)*num);
            }else{
                System.out.println("租车失败，原因：车余量不足");
            }
            break;
            case "Model3":
            if(model3.rest>=num){
                System.out.println("租车成功，总计租金为"+model3.calRent(days)*num);
            }else{
                System.out.println("租车失败，原因：车余量不足");
            }
            break;
            case "Gold":
            if(gold.rest>=num){
                System.out.println("租车成功，总计租金为"+gold.calRent(days)*num);
            }else{
                System.out.println("租车失败，原因：车余量不足");
            }
            break;
        }
    }

}
