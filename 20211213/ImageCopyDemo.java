import java.util.*;
import java.io.*;
public class ImageCopyDemo {
    public static void main(String[] args) {
        
        FileInputStream fis=null;
        FileOutputStream fos=null;

        DataInputStream dis=null;
        DataOutputStream dos=null;

        try {
            fis=new FileInputStream("./fd/a.jpg");
            dis=new DataInputStream(fis);
            fos=new FileOutputStream("./ram/b.jpg");
            dos=new DataOutputStream(fos);
            int temp;
            while((temp=dis.read())!=-1) {
                dos.write(temp);
            }
            System.out.println("Copy Success");
        } catch (Exception e) {
            //TODO: handle exception
        }finally{
            try {
                if(fis!=null) {
                    fis.close();
                }
                if(fos!=null) {
                    fos.close();
                }
                if(dis!=null) {
                    dis.close();
                }
                if(dos!=null) {
                    dos.close();
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
