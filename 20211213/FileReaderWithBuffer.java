import java.io.*;
import java.util.*;

public class FileReaderWithBuffer {
    public static void main(String[] args) {
        try {
            // Create a file
            File file = new File("./test.txt");
            // Create a file reader
            FileReader fr = new FileReader(file);
            // Create a buffer
            BufferedReader br = new BufferedReader(fr);
            // Read the file
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            // Close the file
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}