package Practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        for(int i=1;i<=10;i++){
            list.add(random.nextInt(100));
        }

        System.out.println("Before sort: ");
        System.out.println("List: " + list);
        list.sort((o1, o2) -> o1 - o2);
        System.out.println("After sort: ");
        System.out.println("List: " + list);
    }
}
