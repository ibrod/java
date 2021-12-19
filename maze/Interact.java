import java.util.Random;
import java.util.Scanner;

import Maze_Constructor_and_Finder.Finder;
import Maze_Constructor_and_Finder.Generator;
import Maze_Constructor_and_Finder.Pathinformation;
import Maze_Constructor_and_Finder.Tools;

public class Interact {
    public static int addx[] = { -1, 1, 0, 0 };
    public static int addy[] = { 0, 0, -1, 1 };
    // 上下左右
    public static char dr[] = { 'U', 'D', 'L', 'R' };

    public void interactive_interface() throws Exception {
        while (true) {
            Tools.clear_screen();
            System.out.println("欢迎来到走迷宫游戏！");
            System.out.println("请将当前终端窗口全屏。该游戏使用了部分DOS命令,故对Windows以外的其他平台兼容性不是很好,请使用Windows平台进行该游戏哦！");
            System.out.println("请选择游戏模式(输入一个数字(1~4)，然后按回车键):");
            System.out.println("1.指定模式");
            System.out.println("2.随机模式");
            System.out.println("3.自定义模式");
            System.out.println("4.退出");
            System.out.print(">>>");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            if (input.equals("1")) {
                normal_mode();
            } else if (input.equals("2")) {
                random_mode();
            } else if (input.equals("3")) {
                custom_mode();
            } else if (input.equals("4")) {
                sc.close();
                return;
            } else {
                System.out.println("输入错误，请重新输入！");
                System.out.println("按任意键继续...");
                sc.close();
                Tools.pfpasue();
                interactive_interface();
                return;
            }
        }
    }

    public void custom_mode() {
        Tools.clear_screen();
        System.out.println("请输入生成迷宫的长和宽:(长和宽均不能小于5)");
        Scanner sc = new Scanner(System.in);
        int n = 5, m = 5, c = 0;
        try {
            System.out.print("长(一个不小于5的数字):");
            n = sc.nextInt();
            System.out.print("宽(一个不小于5的数字):");
            m = sc.nextInt();
            System.out.println("请选择生成迷宫的算法(0:深度优先随机搜索迷宫生成算法,1:随机prim迷宫生成算法。请输入0或者1):");
            c = sc.nextInt();
            start_game(n, m, c != 0);
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

    public void random_mode() throws Exception {
        Random rd = new Random();
        start_game(rd.nextInt(35) + 6, rd.nextInt(160) + 10, rd.nextInt(2) == 0);
    }

    public void normal_mode() throws Exception {
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
            System.out.print(">>>");
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
                start_game(10, 30, true);
                return;
            case 2:
                start_game(15, 35, false);
                return;
            case 3:
                start_game(20, 50, true);
                return;
            case 4:
                start_game(25, 55, false);
                return;
            case 5:
                start_game(30, 70, true);
                return;
            case 6:
                start_game(33, 75, false);
                return;
            case 7:
                start_game(36, 105, true);
                return;
            case 8:
                start_game(39, 125, false);
                return;
            case 9:
                start_game(41, 155, false);
                return;
            default:
                break;
        }

    }

    public void start_game(int n, int m, boolean createmode) throws Exception {
        Tools.clear_screen();
        Generator g = new Generator();
        StringBuffer[] mp = null;
        if (createmode) {
            mp = g.prim_create(n, m);
        } else {
            mp = g.dfs_create(n, m);
        }
        int sx = 0, sy = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (mp[i].charAt(j) == '@') {
                    sx = i;
                    sy = j;
                    break;
                }
            }
        }
        play_game(mp, n, m, sx, sy, false, "", 0);
    }

    public void play_game(StringBuffer mp[], int n, int m, int sx, int sy, boolean tip, String command, int idx)
            throws Exception {
        if (idx < command.length()) {
            Tools.clear_screen();
            int x = 0, y = 0;
            if (command.charAt(idx) == 'w') {
                x = sx + addx[0];
                y = sy + addy[0];
            } else if (command.charAt(idx) == 's') {
                x = sx + addx[1];
                y = sy + addy[1];
            } else if (command.charAt(idx) == 'a') {
                x = sx + addx[2];
                y = sy + addy[2];
            } else if (command.charAt(idx) == 'd') {
                x = sx + addx[3];
                y = sy + addy[3];
            } else if (command.charAt(idx) == 'q') {
                return;
            } else if (command.charAt(idx) == 't') {
                play_game(mp, n, m, sx, sy, !tip, command, idx + 1);
                return;
            } else if (command.charAt(idx) == 'x') {
                Finder fd = new Finder();
                fd.instruct(mp, n, m);
                return;
            } else {
                play_game(mp, n, m, sx, sy, tip, command, idx + 1);
                return;
            }
            if (mp[x].charAt(y) == '$') {
                Tools.win();
                return;
            }
            if (x > 0 && x <= n && y > 0 && y <= m && mp[x].charAt(y) == ' ') {
                char temp = mp[x].charAt(y);
                mp[x].setCharAt(y, mp[sx].charAt(sy));
                mp[sx].setCharAt(sy, temp);
                sx = x;
                sy = y;
            }
            play_game(mp, n, m, sx, sy, tip, command, idx + 1);
            return;

        } else {
            Scanner sc = new Scanner(System.in);
            System.out.println(
                    "欢迎来到走迷宫游戏！'@'为当前你所在位置,'$'为出口,你需要从当前位置走到出口即算游戏胜利！请输入指令(一个字符(所有字符均小写))，然后回车进行游戏,(w:向上移动一格,s:向下移动一格,a:向左移动一格,d:向右移动一格,t:开启提示当前最优走法功能,x:开启自动寻路模式,q:退出游戏)(举例:你可以输入:ddd,然后回车,表示向右走3步)");
            Tools.pf_map(mp, n, m);
            if (tip) {
                Finder fd = new Finder();
                Pathinformation p = fd.find(mp, n, m);
                System.out.print("当前一步最优走法为:" + convert(p.path.charAt(0)) + ",输入指令>>>");
            } else {
                System.out.print("请输入指令>>>");
            }
            String cmd = sc.next();
            play_game(mp, n, m, sx, sy, tip, cmd, 0);
            return;
        }
    }

    private String convert(char ch) {
        switch (ch) {
            case 'U':
                return "上";
            case 'D':
                return "下";
            case 'L':
                return "左";
            case 'R':
                return "右";
            default:
                break;
        }
        return "无解";
    }

}
