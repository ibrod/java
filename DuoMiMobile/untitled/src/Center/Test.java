package Center;

import Center.ServiceCenter;

public class Test {
    public static void main(String[] args) {
        ServiceCenter sc = new ServiceCenter();
        try {
            sc.menu();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}