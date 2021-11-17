import java.util.*;

public class Main {
    public static String[] wk = new String[7];
    public static int[] mt = new int[13];

    public static void main(String[] args) {
        init();
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        if (month == 2 && pd(year)) {
            pfm(cal.get(Calendar.DAY_OF_WEEK), 29);
        } else {
            // System.out.println("year"+year);
            // System.out.println("month"+month);
            // System.out.println("day"+day);
            // System.out.println(cal.get(Calendar.DAY_OF_WEEK));
            //System.out.println(getwek(year, month, 1));

            pfm(getwek(year, month, 1), mt[month]);
        }
    }

    public static void init() {
        wk[0] = "日";
        wk[0] = "一";
        wk[0] = "二";
        wk[0] = "三";
        wk[0] = "四";
        wk[0] = "五";
        wk[0] = "六";

        mt[1] = 31;
        mt[2] = 28;
        mt[3] = 31;
        mt[4] = 30;
        mt[5] = 31;
        mt[6] = 30;
        mt[7] = 31;
        mt[8] = 31;
        mt[9] = 30;
        mt[10] = 31;
        mt[11] = 30;
        mt[12] = 31;
    }

    public static int getwek(int year, int month, int day) {// 判断星期
        if (month == 1 || month == 2) {
            year--;
            month += 12;
        }
        int c = year / 100;
        int y = year - c * 100;
        int week = y + y / 4 + c / 4 - 2 * c + 26 * (month + 1) / 10 + day - 1;
        while (week < 0)
            week += 7;
        week %= 7;
        return week;
    }

    public static void pfm(int pos, int days) {
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int op, loc;
        for (int i = 0; i < pos; i++) {
            System.out.print("**\t");
        }
        op = 1;
        loc = pos;

        while (op <= days) {
            for (; op <= days && loc < 7; op++) {
                System.out.print(op + "\t");
                loc++;
            }
            if (op <= days) {
                System.out.println();
            }
            loc = 0;
        }
        System.out.println();
    }

    public static boolean pd(int year) {// 判断润年
        return (year % 100 != 0 && year % 4 == 0) || (year % 400 == 0);
    }

}