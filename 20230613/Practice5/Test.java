package Practice5;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        Goods tv = new Tvs("长虹", 2000, 27);
        System.out.println(tv.getInfo());

        System.out.println("--------------------");

        Goods food = new Foods("饼干", 5,  LocalDate.of(2023, 12, 12));
        System.out.println(food.getInfo());
    }
}
