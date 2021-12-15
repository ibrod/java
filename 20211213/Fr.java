import java.io.*;
import java.util.*;
public class Fr {
    public static void main(String[] args) {
        try {
            //1.File
            File f=new File("./Output.txt");
            //2.writer
            //FileWriter fw=new FileWriter(f);
            FileWriter fw=new FileWriter(f,true);
            //3.BufferedWriter
            BufferedWriter bw=new BufferedWriter(fw);
            Scanner sc=new Scanner(System.in);
            String s;
            System.out.println("请输入您的姓名：");
            s=sc.nextLine();
            bw.write(s);
            bw.newLine();
            System.out.println("请输入您的年龄：");
            s=sc.nextLine();
            bw.write(s);
            bw.newLine();

            bw.flush();
            bw.close();
            fw.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
