import java.util.*;
public class Main {
    static Vector<String>help;
    static void init(){
        help.add("帮助 : help");
        help.add("退出 : exit");
    }
    public static void main(String[] args) {
        init();
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
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }

    }
    static void get_help(){
        
    }

}
