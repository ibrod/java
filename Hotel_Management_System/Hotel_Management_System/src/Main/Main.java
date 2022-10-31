package Main;

import java.sql.*;

import Tools.Sms_Tool.Sms;

public class Main {

    public static void change(StringBuffer x) {
        x.append('d');
    }

    public static void main(String[] args) {
        // StringBuffer x=new StringBuffer("111");
        // change(x);
        // System.out.println(x);
        // Sms.send_sms("18207439548");
        // String s="";
        // System.out.println(Double.valueOf(s));
        // Date date=new Date(System.currentTimeMillis());
        // Time time=new Time(System.currentTimeMillis());
        // System.out.println(time);
        // System.out.println(date.toString());
        // Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        // Date date=new Date(timestamp.getTime());
        // Time time=new Time(timestamp.getTime());

        // System.out.println(date.toString());
        // System.out.println(time.toString());

        // Timestamp timestamp2 = Timestamp.valueOf(date.toString()+"
        // "+time.toString());
        // System.out.println(timestamp2.toString());

        try {

            Timestamp timestamp = Timestamp.valueOf("2020-12-12 12:12:fd");
            System.out.println(timestamp.toString());
        } catch (Exception e) {
            System.err.println("转化不了啦，逊了啦");
            e.printStackTrace();
        }

    }
}
