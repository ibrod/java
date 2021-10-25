package temp;
//import java.util.Scanner;
public class student {
    public static void main(String[] args) {
        int len,width;
        System.out.println("Please input length and width:");
        student st =new student();
        len=st.inputl();
        width=st.inputl();
        st.display(len, width);
    }

    int inputl(){
      //  Scanner sc=new Scanner(System.in);
        return 0;
    }

    void display(int length, int width){
        System.out.println("Squre:"+length*width);
    }

}