package temp;
import java.util.Scanner;

public class luogu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        if (n >= 2) {
            System.out.println(n + n - 1);
        } else {
            System.out.println(n + n);
        }
    }
}