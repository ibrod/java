import java.util.*;
import course.*;

public class controler {
    public static void main(String[] args) {
        Stu st = new Stu();
        String command;
        System.out.println("你已进入控制台，请输入命令,如需帮助，请输入help按下回车：");
        Scanner sc = new Scanner(System.in);
        int cid;
        while (true) {
            System.out.print(">>>");
            command = sc.next();
            switch (command) {
            case "exit":
                return;
            case "help":
                get_help();
                break;
            case "listc":
                st.listc();
                break;
            case "exam":
                cid = sc.nextInt();
                st.exam(cid);
                break;
            case "cs":
                cid = sc.nextInt();
                st.choose_course(cid);
                break;
            case "check":
                cid = sc.nextInt();
                st.check(cid);
                break;
            default:
                System.out.println("输入错误,请重新输入");
            }
        }

    }

    static void get_help() {

        System.out.println("退出: exit");
        System.out.println("帮助: help");
        System.out.println("显示可选课程: listc");
        System.out.println("选课: cs [课程id] (课程id可通过listc命令查看)");
        System.out.println("对某门课进行考试: exam [课程id] (课程id可通过listc命令查看)");
        System.out.println("查询某门课程的成绩: check [课程id] (课程id可通过listc命令查看)");

    }

}