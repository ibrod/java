package UI;

import java.util.Scanner;
import java.util.Vector;
import Util.Pair;
import Car.*;
import ManagementSystem.ManagementSystem;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎来到汽车租赁系统");
        System.out.println("1.添加轿车 2.添加客车 3.租赁轿车 4.租赁客车 5.查询总营收 6.查看库存车辆信息 7.产看订单 8.退出");
        ManagementSystem ms = new ManagementSystem();
        String id;
        String brand;
        Double rent;
        String type;
        Integer Inventory;
        int n;
        while (true) {
            System.out.println("");
            System.out.println("*************************");
            System.out.println("欢迎来到汽车租赁系统");
            System.out.println("1.添加轿车 2.添加客车 3.租赁轿车 4.租赁客车 5.查询总营收 6.查看库存车辆信息 7.产看订单 8.退出");
            System.out.println("请输入操作编号:");
            System.out.print(">>>");
            int op = input.nextInt();
            System.out.println();
            System.out.println("-------------------------");
            switch (op) {
                case 1:
                    System.out.print("请输入轿车ID:");
                    id = input.next();
                    System.out.print("请输入轿车品牌:");
                    brand = input.next();
                    System.out.print("请输入轿车日租金:");
                    rent = input.nextDouble();
                    System.out.print("请输入库存:");
                    Inventory = input.nextInt();
                    System.out.print("请输入轿车类型:");
                    type = input.next();
                    System.out.print("请输入轿车折扣数:");
                    n = input.nextInt();
                    System.out.println("请输入轿车折扣信息:(一共"+n+"行,每行两个数，分别表示租赁天数和折扣):");
                    Vector<Pair<Integer, Double>> discount = new Vector<Pair<Integer, Double>>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("请输入第" + (i + 1) + "个折扣信息:");
                        int days = input.nextInt();
                        Double dis = input.nextDouble();
                        Pair<Integer, Double> p = new Pair<Integer, Double>(days, dis);
                        discount.add(p);
                    }
                    Sedan sedan = new Sedan("轿车", id, brand, rent, type, discount);
                    ms.addSedan(sedan, Inventory);
                    break;
                case 2:
                    System.out.print("请输入客车ID:");
                    id = input.next();
                    System.out.print("请输入客车品牌:");
                    brand = input.next();
                    System.out.print("请输入客车日租金:");
                    rent = input.nextDouble();
                    System.out.print("请输入库存:");
                    Inventory = input.nextInt();
                    System.out.print("请输入客车座位数:");
                    String name = input.next();
                    System.out.print("请输入客车折扣数:");
                    n = input.nextInt();
                    System.out.println("请输入客车折扣信息(一共"+n+"行,每行两个数，分别表示租赁天数和折扣):");
                    discount = new Vector<Pair<Integer, Double>>();
                    for (int i = 0; i < n; i++) {
                        System.out.print("请输入第" + (i + 1) + "个折扣信息:");
                        int days = input.nextInt();
                        Double dis = input.nextDouble();
                        Pair<Integer, Double> p = new Pair<Integer, Double>(days, dis);
                        discount.add(p);
                    }
                    Bus bus = new Bus("客车", id, brand, rent, name, discount);
                    ms.addBus(bus, Inventory);
                    break;
                case 3:
                    System.out.print("请输入轿车ID:");
                    id = input.next();
                    System.out.print("请输入租赁数量:");
                    Integer num = input.nextInt();
                    System.out.print("请输入租赁天数:");
                    Integer days = input.nextInt();
                    String info = ms.rentSedan(id, num, days);
                    System.out.println(info);
                    break;
                case 4:
                    System.out.print("请输入客车ID:");
                    id = input.next();
                    System.out.print("请输入租赁数量:");
                    num = input.nextInt();
                    System.out.print("请输入租赁天数:");
                    days = input.nextInt();
                    info = ms.rentBus(id, num, days);
                    System.out.println(info);
                    break;
                case 5:
                    System.out.println("总营收:" + ms.getMoney());
                    break;
                case 6:
                    System.out.println("轿车库存和车辆信息:");
                    System.out.println(ms.getSedanInventoryInfo());
                    System.out.println("客车库存和车辆信息:");
                    System.out.println(ms.getBusInventoryInfo());
                    break;
                case 7:
                    System.out.println("轿车订单信息:");
                    System.out.println(ms.getSedanOrderInfo());
                    System.out.println("客车订单信息:");
                    System.out.println(ms.getBusOrderInfo());
                    break;
                case 8:
                    System.out.println("欢迎下次使用");
                    input.close();
                    System.exit(0);
                default:
                    System.out.println("输入错误,请重新输入");
                    break;
            }
        }
    }
}