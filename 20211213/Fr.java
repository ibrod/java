import java.io.*;
public class Fr {
    public static void main(String[] args) {
        try {
            //1.File
            File f=new File("./fd/test.txt");
            //2.writer
            //FileWriter fw=new FileWriter(f);
            FileWriter fw=new FileWriter(f,true);
            //3.BufferedWriter
            BufferedWriter bw=new BufferedWriter(fw);
            bw.write("\nHello World\n");
            bw.write("kewu");
            bw.flush();
            bw.close();
            fw.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (Exception e) {

        }
    }
}
