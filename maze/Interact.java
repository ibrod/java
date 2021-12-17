import java.util.Scanner;

import Maze_Constructor_and_Finder.Finder;
import Maze_Constructor_and_Finder.Generator;
import Maze_Constructor_and_Finder.Tools;

public class Interact {
    public void interactive_interface() {
        Tools.clear_screen();
        System.out.println("欢迎来到走迷宫游戏！");
        System.out.println("请选择游戏模式(输入一个数字(1~4)，然后按回车键):");
        System.out.println("1.指定模式");
        System.out.println("2.随机模式");
        System.out.println("3.自定义模式");
        System.out.println("4.退出");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.equals("1")) {

        } else if (input.equals("2")) {

        } else if (input.equals("3")) {

        } else if (input.equals("4")) {
            return;
        } else {
            System.out.println("输入错误，请重新输入！");
            System.out.println("按任意键继续...");
            Tools.pfpasue();
            interactive_interface();
            return;
        }
    }

    public static void custom_mode() {
        Tools.clear_screen();
        System.out.println("请输入生成迷宫的长和宽:(长和宽均不能小于5)");
        Scanner sc = new Scanner(System.in);
        int n = 5, m = 5;
        try {
            System.out.print("长(一个不小于5的数字):");
            n = sc.nextInt();
            System.out.print("宽(一个不小于5的数字):");
            m = sc.nextInt();
        } catch (Exception e) {
            System.out.println("输入错误，请重新输入！");
            System.out.println("按任意键继续...");
            Tools.pfpasue();
            custom_mode();
            return;
        }

        if (n < 5 || m < 5) {
            System.out.println("输入错误，请重新输入！");
            System.out.println("按任意键继续...");
            Tools.pfpasue();
            custom_mode();
            return;
        }
    }

    public void normal_mode() {
        Tools.clear_screen();
        System.out.println("欢迎来到走迷宫游戏！");
        System.out.println("请选择游戏难度:");
        System.out.println("1.小白");
        System.out.println("2.菜鸟");
        System.out.println("3.入门");
        System.out.println("4.初级");
        System.out.println("5.中级");
        System.out.println("6.高级");
        System.out.println("7.精英");
        System.out.println("8.大师");
        System.out.println("9.特技大师");
        System.out.println("0.返回");
        Scanner sc = new Scanner(System.in);
        int num;
        try {
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("输入错误，请重新输入！");
            System.out.println("按任意键继续...");
            Tools.pfpasue();
            normal_mode();
            return;
        }

        if (num > 9) {
            System.out.println("输入错误，请重新输入！");
            System.out.println("按任意键继续...");
            Tools.pfpasue();
            normal_mode();
            return;
        }

        switch (num) {
            case 0:
                return;
            case 1:

            default:
                break;
        }

    }

    public void start_game(int n, int m, boolean createmode, String command, int idx){
        Tools.clear_screen();
        Generator g = new Generator();
        StringBuffer[] mp = null;
        if (createmode) {
            mp = g.prim_create(n, m);
        } else {
            mp = g.dfs_create(n, m);
        }
        Finder fd = new Finder();
    }

    public void play_game(StringBuffer mp[],int n, int m, boolean createmode, String command, int idx) throws Exception {
        if (idx >= command.length()) {
            Tools.clear_screen();


        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println(
                    "欢迎来到走迷宫游戏！请输入指令(一个字符)，然后回车进行游戏,(u:向上移动一格,d:向下移动一格,l:向左移动一格,r:向右移动一格,t:开启提示功能,x:开启自动寻路模式,c:重新开始此张图,r:重新开始新的地图,q:退出游戏)(举例你可以输入:rrr,然后回车,表示向右走3步)");
            Tools.pf_map(mp, n, m);
            System.out.println("按任意键继续");
            String cmd = sc.next();
            play_game(mp,n, m, createmode, cmd, 0);
            return;
        }

        // System.out.println("Shortest path: " + p.distance);
        // System.out.println("Path: " + p.path);
    }

}
