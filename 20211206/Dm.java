import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Dm {
    public static void main(String[] args) throws Exception {
        File f = new File("./file/hello.txt");
        System.out.println("文件是否存在:" + (f.exists()));
        f.delete();
        f.createNewFile();
        System.out.println("File name: " + f.getName());
        System.out.println("File path: " + f.getPath());
        System.out.println("Absu file path: " + f.getAbsolutePath());
        System.out.println("是否为目录:" + (f.isDirectory()));
        System.out.println("是否为可读:" + (f.canRead()));
        Date date = new Date(f.lastModified());
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("文件最后修改时间:" + sd.format(date));
        System.out.println("ls: "+f.listFiles());
        System.out.println("ls: "+f.list());
        
        
    }
}
