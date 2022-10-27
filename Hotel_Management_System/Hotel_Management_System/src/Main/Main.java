package Main;

public class Main {

    public static void change(StringBuffer x){
        x.append('d');
    }

    public static void main(String[] args) {
        StringBuffer x=new StringBuffer("111");
        change(x);
        System.out.println(x);
    }
}
