import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
    public static String[] wk = new String[7];
    public static int[] mt = new int[13];

    public static void main(String[] args) throws ParseException {
        init();
        Date d = new Date(101,9,20);
        SimpleDateFormat sdf = new SimpleDateFormat("EE");
        String str = sdf.format(d);
        System.out.println("我出生的那天是:"+str);
        Date d1 = new Date();
        long mytime = d1.getTime()-d.getTime();
        long myday = mytime/(24*3600*1000);
        System.out.println("我已经活了:" +myday+" 天");
    }
}