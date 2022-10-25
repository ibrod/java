package Maze_Constructor_and_Finder;
import java.util.Random;
import java.util.Scanner;

public class Interact {
    public static int addx[] = { -1, 1, 0, 0 };
    public static int addy[] = { 0, 0, -1, 1 };
    // ��������
    public static char dr[] = { 'U', 'D', 'L', 'R' };

    public void interactive_interface() {
        while (true) {
            Tools.clear_screen();
            System.out.println("��ӭ�������Թ���Ϸ��");
            System.out.println("�뽫��ǰ�ն˴���ȫ��������Ϸʹ���˲���DOS����,�ʶ�Windows���������ƽ̨�����Բ��Ǻܺ�,��ʹ��Windowsƽ̨���и���ϷŶ��");
            System.out.println("��ѡ����Ϸģʽ(����һ������(1~4)��Ȼ�󰴻س���):");
            System.out.println("1.ָ��ģʽ");
            System.out.println("2.���ģʽ");
            System.out.println("3.�Զ���ģʽ");
            System.out.println("4.�˳�");
            System.out.print(">>>");
            Scanner sc = new Scanner(System.in);
            String input = sc.next();
            try {
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
                    System.out.println("����������������룡");
                    System.out.println("�����������...");
                    //sc.close();
                    Tools.pfpasue();
                    interactive_interface();
                    return;
                }
            } catch (Exception e) {
                System.out.println("��������");
                System.out.println("�����������...");
                sc.close();
                Tools.pfpasue();
                interactive_interface();
                return;
            }
        }
    }

    public void custom_mode() {
        Tools.clear_screen();
        System.out.println("�����������Թ��ĳ��Ϳ�:(���Ϳ������С��5)");
        Scanner sc = new Scanner(System.in);
        int n = 5, m = 5, c = 0;
        try {
            System.out.print("��(һ����С��5������):");
            n = sc.nextInt();
            System.out.print("��(һ����С��5������):");
            m = sc.nextInt();
            System.out.println("��ѡ�������Թ����㷨(0:���������������Թ������㷨,1:���prim�Թ������㷨��������0����1):");
            c = sc.nextInt();
            start_game(n, m, c != 0);
        } catch (Exception e) {
            System.out.println("����������������룡");
            System.out.println("�����������...");
            Tools.pfpasue();
            custom_mode();
            return;
        }

        if (n < 5 || m < 5) {
            System.out.println("����������������룡");
            System.out.println("�����������...");
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
        System.out.println("��ӭ�������Թ���Ϸ��");
        System.out.println("��ѡ����Ϸ�Ѷ�:");
        System.out.println("1.С��");
        System.out.println("2.����");
        System.out.println("3.����");
        System.out.println("4.����");
        System.out.println("5.�м�");
        System.out.println("6.�߼�");
        System.out.println("7.��Ӣ");
        System.out.println("8.��ʦ");
        System.out.println("9.�ؼ���ʦ");
        System.out.println("0.����");
        Scanner sc = new Scanner(System.in);
        int num;
        try {
            System.out.print(">>>");
            num = sc.nextInt();
        } catch (Exception e) {
            System.out.println("����������������룡");
            System.out.println("�����������...");
            Tools.pfpasue();
            normal_mode();
            return;
        }

        if (num > 9) {
            System.out.println("����������������룡");
            System.out.println("�����������...");
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
                    "��ӭ�������Թ���Ϸ��'@'Ϊ��ǰ������λ��,'$'Ϊ����,����Ҫ�ӵ�ǰλ���ߵ����ڼ�����Ϸʤ����������ָ��(һ���ַ�(�����ַ���Сд))��Ȼ��س�������Ϸ,(w:�����ƶ�һ��,s:�����ƶ�һ��,a:�����ƶ�һ��,d:�����ƶ�һ��,t:������ʾ��ǰ�����߷�����,x:�����Զ�Ѱ·ģʽ,q:�˳���Ϸ)(����:���������:ddd,Ȼ��س�,��ʾ������3��)");
            Tools.pf_map(mp, n, m);
            if (tip) {
                Finder fd = new Finder();
                Pathinformation p = fd.find(mp, n, m);
                System.out.print("��ǰһ�������߷�Ϊ:" + convert(p.path.charAt(0)) + ",����ָ��>>>");
            } else {
                System.out.print("������ָ��>>>");
            }
            String cmd = sc.next();
            play_game(mp, n, m, sx, sy, tip, cmd, 0);
            return;
        }
    }

    private String convert(char ch) {
        switch (ch) {
            case 'U':
                return "��";
            case 'D':
                return "��";
            case 'L':
                return "��";
            case 'R':
                return "��";
            default:
                break;
        }
        return "�޽�";
    }

}
