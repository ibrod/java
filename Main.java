import java.util.*;

class Stu {
    Stu() {
        arr = new double[6];// 预留第0位存平均成绩
    }

    String name;
    double[] arr;;
}

public class Main {
    static Stu st[] = new Stu[6];
    public static void main(String[] args) {
        class_init(st);
        String command;
        System.out.println("你已进入控制台，请输入命令,如需帮助，请输入help按下回车：");
        Scanner sc = new Scanner(System.in);
        while (true) {
            command = sc.next();
            switch (command) {
                case "exit":
                    return;
                case "help":
                    System.out.println("查询成绩命令: get [姓名] [课程名]");
                    System.out.println("求某课程的平均分: ave [课程名]");
                    System.out.println("按某课程成绩进行排序后并显示: sort [课程名]");
                    System.out.println("打开帮助: help");
                    System.out.println("退出程序: exit");
                    System.out.println("请注意大小写,查询某人的平均成绩，可使用: get [姓名] ave");
                    break;
                case "get":
                    String name = sc.next();
                    String cls = sc.next();
                    if (hashForclass(cls) == -1) {
                        System.out.println("查无此课程,请注意大小写");
                        break;
                    }
                    double score = find_class_score(st, name, cls);
                    if (score == -1) {
                        System.out.println("查无此人,请注意大小写");
                        break;
                    }
                    System.out.println(name + "的" + cls + "成绩是: " + score);
                    break;
                case "avg":
                    cls = sc.next();
                    if (hashForclass(cls) == -1) {
                        System.out.println("查无此课程,请注意大小写");
                        break;
                    }
                    double ave = get_ave(st, cls);
                    System.out.println(cls + "的平均成绩是: " + ave);
                    break;
                case "sort":
                    cls = sc.next();
                    int hash_code = hashForclass(cls);
                    if (hash_code == -1) {
                        System.out.println("查无此课程,请注意大小写");
                        break;
                    }
                    quick_sort(st, 0, st.length - 1, hash_code);
                    pf(st, cls);
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }

    }

    static double find_class_score(Stu st[], String name, String cls) {
        for (Stu e : st) {
            if (e.name.equals(name)) {
                int hash_code = hashForclass(cls);
                return e.arr[hash_code];
            }
        }
        return -1;// 返回-1表示没有找到
    }

    static double get_ave(Stu st[], String ps) {
        int hash_code = hashForclass(ps);
        double sum = 0;
        for (Stu e : st) {
            sum += e.arr[hash_code];
        }
        return sum / st.length;
    }

    static int hashForclass(String ps) {
        switch (ps) {
            case "ave":
                return 0;
            case "C":
                return 1;
            case "Java":
                return 2;
            case "java":
                return 2;
            case "mySQL":
                return 3;
            case "Linux":
                return 4;
            case "HTML":
                return 5;
            default:
                return -1;// 返回-1表示参数错误
        }
    }

    static void pf(Stu st[], String cls) {
        System.out.println("输出格式:名次+姓名" +"+"+cls);
        int hash_code = hashForclass(cls);
        for (int i = 0; i < st.length; i++) {
            System.out.println((i + 1) + " " + st[i].name + " " + st[i].arr[hash_code]);
        }
    }

    static void quick_sort(Stu q[], int l, int r, int itm) {
        if (l >= r)
            return;

        int i = l - 1, j = r + 1;
        double x = q[(l + r) >> 1].arr[itm];
        while (i < j) {
            do
                i++;
            while (q[i].arr[itm] > x);
            do
                j--;
            while (q[j].arr[itm] < x);
            if (i < j) {
                Stu temp;
                temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q, l, j, itm);
        quick_sort(q, j + 1, r, itm);
    }

    static void class_init(Stu st[]) {

        for (int i = 0; i <= 5; i++) {
            st[i] = new Stu();
        }

        st[0].arr[1] = 26;
        st[0].arr[2] = 69;
        st[0].arr[3] = 46;
        st[0].arr[4] = 25;
        st[0].arr[5] = 5;
        st[0].name = "zhang";

        st[1].arr[1] = 27;
        st[1].arr[2] = 10;
        st[1].arr[3] = 24;
        st[1].arr[4] = 66;
        st[1].arr[5] = 58;
        st[1].name = "wang";

        st[2].arr[1] = 44;
        st[2].arr[2] = 58;
        st[2].arr[3] = 0;
        st[2].arr[4] = 82;
        st[2].arr[5] = 75;
        st[2].name = "li";

        st[3].arr[1] = 6;
        st[3].arr[2] = 68;
        st[3].arr[3] = 92;
        st[3].arr[4] = 9;
        st[3].arr[5] = 84;
        st[3].name = "zhao";

        st[4].arr[1] = 75;
        st[4].arr[2] = 1;
        st[4].arr[3] = 51;
        st[4].arr[4] = 41;
        st[4].arr[5] = 74;
        st[4].name = "liu";

        st[5].arr[1] = 23;
        st[5].arr[2] = 38;
        st[5].arr[3] = 65;
        st[5].arr[4] = 1;
        st[5].arr[5] = 55;
        st[5].name = "song";

        for (int i = 0; i <= 5; i++) {// 预处理个人平均成绩
            double sum = 0;
            for (int j = 1; j <= 5; j++) {
                sum += st[i].arr[j];
            }
            st[i].arr[0] = sum / 5;
        }

    }

}
