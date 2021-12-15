import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        try{
        InputStreamReader isr = new InputStreamReader(System.in);
        //缓冲流进行包装
        BufferedReader br = new BufferedReader(isr);
        //控制台输入操作
        System.out.println("请输入您的姓名：");
        String name = br.readLine();
        System.out.println("请输入您的年龄：");
        int age = Integer.parseInt(br.readLine());
        //输出
        System.out.println("您的姓名："+name);
        System.out.println("您的姓名："+age);
        br.close();
        isr.close();
        //关闭流
        }catch(Exception e){
            System.out.println("输入有误！");
            main(args);
        }


    }
}