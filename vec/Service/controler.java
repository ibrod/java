package Service;
import java.util.*;
import Model.*;
public class controler {
    public static void main(String[] args) {

        String command;
        System.out.println("你已进入控制台，请输入命令,如需帮助，请输入help按下回车：");
        Scanner sc = new Scanner(System.in);
       
        while (true) {
            command = sc.next();
            switch (command) {
                case "exit":
                    return;
                case "help":
                    get_help();
                    break;
                case "listall":
                    data_controler.list_all();
                    break;
                case "rent":
                    String name=sc.next();
                    int a=sc.nextInt();
                    int b=sc.nextInt();
                    data_controler.rent(name, b, a);
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }

    }
    
    static void get_help(){
        System.out.println("查询车辆信息: listall");
        System.out.println("租车: rent [车名] [天数] [数量] (例如：rent Veneno 10 1 )");
        
        System.out.println("退出: exit");
        System.out.println("帮助: help");
    }

}
