import java.util.*;
import department.*;

public class Controler {
    static IAbstract_department[] dep = new IAbstract_department[5];

    public static void main(String[] args) {
        init();
        String command;
        System.out.println("你已进入控制台，请输入命令,如需帮助，请输入help按下回车：");
        Scanner sc = new Scanner(System.in);
        int temp1, temp2, temp3;
        String ram1, ram2;
        while (true) {
            System.out.print(">>>");
            command = sc.next();
            switch (command) {
            case "exit":
                return;
            case "help":
                get_help();
                break;
            case "listdep":
                listdepartment();
                break;
            case "add":
                temp1 = sc.nextInt();
                ram1 = sc.next();
                addstaff(temp1, ram1);
                break;
            case "lista":
                liststaff();
                break;
            case "addx":
                temp1 = sc.nextInt();
                ram1 = sc.next();
                temp2 = sc.nextInt();
                temp3 = sc.nextInt();
                ram2 = sc.next();
                dep[temp1].addx(ram1, temp2, temp3, ram2);
                break;
            case "list":
                temp1 = sc.nextInt();
                dep[temp1].liststaff();
                break;
            case "rst":
                temp1 = sc.nextInt();
                dep[temp1].rst();
                break;
            case "dismiss":
                temp1 = sc.nextInt();
                ram1 = sc.next();
                dep[temp1].del(ram1);
                break;
            case "editx":
                temp1 = sc.nextInt();
                ram1 = sc.next();
                temp2 = sc.nextInt();
                temp3 = sc.nextInt();
                ram2 = sc.next();
                dep[temp1].editx(ram1, temp2, temp3, ram2);
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

    static void liststaff() {
        for (int i = 1; i <= 3; i++) {
            dep[i].liststaff();
        }
    }

    static void addstaff(int cdep, String name) {
        dep[cdep].addstaff(cdep, name);
    }

    public static void listdepartment() {
        System.out.println("实习部编号: 1");
        System.out.println("开发部编号: 2");
        System.out.println("管理部编号: 3");

    }

    static void get_help() {

        System.out.println("退出: exit");
        System.out.println("帮助: help");
        System.out.println("列出所有部门及其部门编号: listdep");
        System.out.println("添加员工基本信息: add [部门编号] [姓名]");
        System.out.println("添加实习部员工详细信息:addx [部门编号] [姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [实习期]");
        System.out.println("添加开发部员工详细信息:addx [部门编号] [姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [平均加班时间]");
        System.out.println("添加管理部员工详细信息:addx [部门编号] [姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [经理助理姓名]");
        System.out.println("修改实习部员工详细信息:editx [部门编号] [姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [实习期]");
        System.out.println("修改开发部员工详细信息:editx [部门编号] [姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [平均加班时间]");
        System.out.println("修改管理部员工详细信息:editx [部门编号] [姓名] [薪水] [额外工资(奖金,加班费，额外补贴等)] [经理助理姓名]");
        System.out.println("列出所有部门下所有员工的信息: lista");
        System.out.println("列出某部门下所有员工的信息: list [部门编号]");
        System.out.println("查询某部门现有人数: rst [部门编号]");
        System.out.println("解雇某人: dismiss [部门编号] [姓名]");
        System.out.println("调整额外工资(奖金,加班费，额外补贴等): ads [部门编号] [姓名]");
    }

}