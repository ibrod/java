package Practice2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();

        // World Cup Champion
        map.put(1930, "Uruguay");
        map.put(1934, "Italy");
        map.put(1938, "Italy");
        map.put(1950, "Uruguay");
        map.put(1954, "Germany");
        map.put(1958, "Brazil");
        map.put(1962, "Brazil");
        map.put(1966, "England");
        map.put(1970, "Brazil");
        map.put(1974, "Germany");
        map.put(1978, "Argentina");
        map.put(1982, "Italy");
        map.put(1986, "Argentina");
        map.put(1990, "Germany");
        map.put(1994, "Brazil");
        map.put(1998, "France");
        map.put(2002, "Brazil");
        map.put(2006, "Italy");
        map.put(2010, "Spain");
        map.put(2014, "Germany");

        System.out.println("请输入四个数字表示年份: ");
        System.out.print(">>>");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        if (map.containsKey(year)) {
            System.out.println(year + "年的世界杯冠军是: " + map.get(year));
        } else {
            System.out.println("该年份没有举办世界杯");
        }

        System.out.println("请用英文输入一个国家名: ");
        System.out.print(">>>");
        String country = scanner.next();
        checkCountry(map, country);
        scanner.close();
    }

    public static void checkCountry(Map<Integer, String> map, String country) {
        boolean flag = false;
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(country)) {
                System.out.println(country + "是" + entry.getKey() + "年的世界杯冠军");
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("该国家没有获得过世界杯冠军");
        }
    }
}
