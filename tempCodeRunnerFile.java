import java.util.*;
public class tempCodeRunnerFile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fb[] = new int[15];
        fb[0] = 0;
        fb[1] = 1;
        for (int i = 2; i <= 10; i++) {
            fb[i] = fb[i - 1] + fb[i - 2];
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println("fb[" + i + "]=" + fb[i]);
        }
        sc.close();
    }
}
