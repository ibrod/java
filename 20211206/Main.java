import java.io.*;
public class Main {
    public static final String filepath1 = "./file/hello.txt";//源文件的地址
    public static final String filepath2 = "./file/new.txt";//剪切的位置地址
    public static void main(String[] args) throws IOException {
        File file = new File(filepath1);
        InputStream inputstream = new FileInputStream(file);
        byte bytes[] = new byte[1000];
        inputstream.read(bytes);
        String content = new String(bytes); 
        inputstream.close();
        file.delete();


        File file2 = new File(filepath2);
        OutputStream outputstream = new FileOutputStream(file2);
        outputstream.write(content.getBytes()); 
        outputstream.close();
    }


}
