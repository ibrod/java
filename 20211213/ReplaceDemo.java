import java.io.*;
import java.nio.Buffer;

public class ReplaceDemo {
    public static void main(String[] args) {
        replaceFile("./fd/pet.txt", "./ram/pet2.txt");
    }

    // file1 is template
    // file2 is the file to be replaced
    public static void replaceFile(String file1, String file2) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {

            FileInputStream fis = new FileInputStream(file1);
            FileOutputStream fos = new FileOutputStream(file2);

            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");

            FileWriter fw = new FileWriter(file2);
            br = new BufferedReader(isr);
            bw = new BufferedWriter(fw);
            String line = null;
            while ((line = br.readLine()) != null) {
                if(line.indexOf("{$name}")!=-1){
                    bw.write(line.replace("{$name}", "cat"));
                    bw.newLine();
                }else if(line.indexOf("{$age}")!=-1){
                    bw.write(line.replace("{$age}", "6"));
                    bw.newLine();
                }else if(line.indexOf("{$color}")!=-1){
                    bw.write(line.replace("{$color}", "black and white"));
                    bw.newLine();
                }else{
                    bw.write(line);
                    bw.newLine();
                }
            }

        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                br.close();
                bw.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}