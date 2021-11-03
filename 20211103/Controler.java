import java.util.*;
import department.*;

public class Controler {
    static IAbstract_department[] dep = new IAbstract_department[5];

    public static void main(String[] args) {

        String command;
        System.out.println("你已进入控制台，请输入命令,如需帮助，请输入help按下回车：");
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(">>>");
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

    static void init() {
        dep[1] = new Trainee_department();
        dep[2] = new Programmer_department();
        dep[3] = new Manager_department();
    }

    public static void listdepartment() {
        System.out.println("实习部编号: 1");
        System.out.println("开发部编号: 2");
        System.out.println("管理部编号: 3");

    }

    static void get_help() {

        System.out.println("退出: exit");
        System.out.println("帮助: help");
        System.out.println("列出所有部门及其部门编号: listdepartment");
        System.out.println("添加员工: addstaff [部门编号] [姓名]");

    }

}