package GUI;

import java.util.Scanner;
import java.util.Vector;
import Item.Book;
import Item.Order;
import Item.OrderItem;

public class MainController {

    Vector<Book> books;
    Vector<Order> orders;
    Vector<OrderItem> orderItems;

    public void start() {
        books = new Vector<Book>();
        orders = new Vector<Order>();
        orderItems = new Vector<OrderItem>();
        books.add(new Book(1, "Java从入门到放弃", 100, 10));
        books.add(new Book(2, "C++从入门到放弃", 50, 20));
        books.add(new Book(3, "Python从入门到放弃", 25, 30));
        run();
    }

    public void run() {
        System.out.println("欢迎来到易买网！请输入相应的数字编号并按回车：");
        System.out.println("1.添加订单 2.查看订单 3.修改订单 4.删除订单 5.退出");
        System.out.println("请输入：");
        int choice = 0;

        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            run();
            System.exit(0);
        }
        switch (choice) {
            case 1:
                addOrder();
                break;
            case 2:
                showOrder();
                break;
            case 3:
                modifyOrder();
                break;
            case 4:
                deleteOrde();
                break;
            case 5:
                System.out.println("感谢您的使用，再见！");
                System.exit(0);
                break;
            default:
                System.out.println("输入错误，请重新输入！");
                try {
                    // 让程序休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // 当前线程在休眠时被中断，需要处理这个异常
                    e.printStackTrace();
                }
                clearConsole();
                run();
                break;
        }
    }

    private void addOrder() {
        clearConsole();
        System.out.println("现有的图书如下：");
        System.out.println("编号\t名称\t价格\t库存");
        for (Book book : books) {
            System.out
                    .println(book.getId() + "\t" + book.getName() + "\t" + book.getPrice() + "\t" + book.getStorage());
        }
        System.out.println("请输入要购买的图书编号：");
        int bookId = 0;
        int num = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            bookId = scanner.nextInt();
            System.out.println("请输入要购买的数量：");
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            addOrder();
            System.exit(0);
        }
        OrderItem orderItem = new OrderItem();
        for (Book book : books) {
            if (book.getId() == bookId) {
                orderItem.setId(book.getId());
                orderItem.setName(book.getName());
                orderItem.setPrice(book.getPrice());
                orderItem.setNum(num);
                book.setStorage(book.getStorage() - num);
                break;
            }
        }
        orderItems.add(orderItem);
        double total = 0;
        for (OrderItem item : orderItems) {
            total += item.getPrice() * item.getNum();
        }
        Order order = new Order();
        order.setId(orders.size() + 1);
        order.setTotal(total);
        order.setDate(new java.util.Date());
        order.setOrderItems(orderItems);
        orders.add(order);
        System.out.println("订单添加成功！");
        System.out.println("订单信息如下：");
        System.out.println("订单编号\t订单总价\t订单日期");
        for (Order o : orders) {
            System.out.println(o.getId() + "\t" + o.getTotal() + "\t" + o.getDate());
        }
        System.out.println("是否继续添加订单？（Y/N）");
        String choice = "";
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            addOrder();
            System.exit(0);
        }
        if (choice.equals("Y") || choice.equals("y")) {
            clearConsole();
            addOrder();
        } else {
            clearConsole();
            run();
        }
    }

    private void showOrder() {
        clearConsole();
        System.out.println("1.查询图书情况 2.查询订单项情况 3.查询订单情况 4.返回上一级");
        System.out.println("请输入：");
        int choice = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            showOrder();
            System.exit(0);
        }
        if (choice == 1) {
            clearConsole();
            System.out.println("现有的图书如下：");
            System.out.println("编号\t名称\t价格\t库存");
            for (Book book : books) {
                System.out.println(
                        book.getId() + "\t" + book.getName() + "\t" + book.getPrice() + "\t" + book.getStorage());
            }
            System.out.println("是否继续查询图书情况？（Y/N）");
            String choice1 = "";
            try {
                Scanner scanner = new Scanner(System.in);
                choice1 = scanner.next();
            } catch (Exception e) {
                System.out.println("输入不合法，请重新输入！");
                try {
                    // 让程序休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException ee) {
                    // 当前线程在休眠时被中断，需要处理这个异常
                    ee.printStackTrace();
                }
                clearConsole();
                showOrder();
                System.exit(0);
            }
            if (choice1.equals("Y") || choice1.equals("y")) {
                clearConsole();
                showOrder();
            } else {
                clearConsole();
                run();
            }
        } else if (choice == 2) {
            clearConsole();
            System.out.println("现有的订单项如下：");
            System.out.println("编号\t名称\t价格\t数量");
            for (OrderItem orderItem : orderItems) {
                System.out.println(orderItem.getId() + "\t" + orderItem.getName() + "\t" + orderItem.getPrice() + "\t"
                        + orderItem.getNum());
            }
            System.out.println("是否继续查询订单项情况？（Y/N）");
            String choice1 = "";
            try {
                Scanner scanner = new Scanner(System.in);
                choice1 = scanner.next();
            } catch (Exception e) {
                System.out.println("输入不合法，请重新输入！");
                try {
                    // 让程序休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException ee) {
                    // 当前线程在休眠时被中断，需要处理这个异常
                    ee.printStackTrace();
                }
            }
            if (choice1.equals("Y") || choice1.equals("y")) {
                clearConsole();
                showOrder();
            } else {
                clearConsole();
                run();
            }
        } else if (choice == 3) {
            clearConsole();
            System.out.println("现有的订单如下：");
            System.out.println("订单编号\t订单总价\t订单日期\t订单大小");
            for (Order order : orders) {
                System.out.println(order.getId() + "\t" + order.getTotal() + "\t" + order.getDate() + "\t"
                        + order.getOrderItems().size());
            }
            System.out.println("是否继续查询订单情况？（Y/N）");
            String choice1 = "";
            try {
                Scanner scanner = new Scanner(System.in);
                choice1 = scanner.next();
            } catch (Exception e) {
                System.out.println("输入不合法，请重新输入！");
                try {
                    // 让程序休眠1秒
                    Thread.sleep(1000);
                } catch (InterruptedException ee) {
                    // 当前线程在休眠时被中断，需要处理这个异常
                    ee.printStackTrace();
                }
                clearConsole();
                showOrder();
                System.exit(0);
            }
            if (choice1.equals("Y") || choice1.equals("y")) {
                clearConsole();
                showOrder();
            } else {
                clearConsole();
                run();
            }
        } else if (choice == 4) {
            clearConsole();
            run();
        } else {
            System.out.println("输入错误，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // 当前线程在休眠时被中断，需要处理这个异常
                e.printStackTrace();
            }
            clearConsole();
            showOrder();
        }

    }

    private void modifyOrder() {
        clearConsole();
        System.out.println("以下是现有的订单项：");
        System.out.println("编号\t名称\t价格\t数量");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getId() + "\t" + orderItem.getName() + "\t" + orderItem.getPrice() + "\t"
                    + orderItem.getNum());
        }
        System.out.println("请输入要修改的订单项编号：");
        int orderItemId = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            orderItemId = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            modifyOrder();
            System.exit(0);
        }
        OrderItem orderItem = new OrderItem();
        for (OrderItem item : orderItems) {
            if (item.getId() == orderItemId) {
                orderItem = item;
                break;
            }
        }
        System.out.println("请输入要修改的订单项数量：");
        int num = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            modifyOrder();
            System.exit(0);
        }
        orderItem.setPrice(num * (orderItem.getPrice()/orderItem.getNum()));
        orderItem.setNum(num);
        System.out.println("订单项修改成功！");
        System.out.println("订单项信息如下：");
        System.out.println("编号\t名称\t价格\t数量");
        for (OrderItem item : orderItems) {
            System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getNum());
        }
        System.out.println("是否继续修改订单项？（Y/N）");
        String choice = "";
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            modifyOrder();
            System.exit(0);
        }
        if (choice.equals("Y") || choice.equals("y")) {
            clearConsole();
            modifyOrder();
        } else {
            clearConsole();
            run();
        }


    }

    private void deleteOrde() {
        clearConsole();
        System.out.println("以下是现有的订单项：");
        System.out.println("编号\t名称\t价格\t数量");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem.getId() + "\t" + orderItem.getName() + "\t" + orderItem.getPrice() + "\t"
                    + orderItem.getNum());
        }
        System.out.println("请输入要删除的订单项编号：");
        int orderId = 0;
        try {
            Scanner scanner = new Scanner(System.in);
            orderId = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            deleteOrde();
            System.exit(0);
        }
        OrderItem orderItem = new OrderItem();
        for (OrderItem item : orderItems) {
            if (item.getId() == orderId) {
                orderItem = item;
                break;
            }
        }
        orderItems.remove(orderItem);
        System.out.println("订单项删除成功！");
        System.out.println("订单项信息如下：");
        System.out.println("编号\t名称\t价格\t数量");
        for (OrderItem item : orderItems) {
            System.out.println(item.getId() + "\t" + item.getName() + "\t" + item.getPrice() + "\t" + item.getNum());
        }
        System.out.println("是否继续删除订单项？（Y/N）");
        String choice = "";
        try {
            Scanner scanner = new Scanner(System.in);
            choice = scanner.next();
        } catch (Exception e) {
            System.out.println("输入不合法，请重新输入！");
            try {
                // 让程序休眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException ee) {
                // 当前线程在休眠时被中断，需要处理这个异常
                ee.printStackTrace();
            }
            clearConsole();
            deleteOrde();
            System.exit(0);
        }
        if (choice.equals("Y") || choice.equals("y")) {
            clearConsole();
            deleteOrde();
        } else {
            clearConsole();
            run();
        }
    }

    public void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); // 检查操作系统

            if (operatingSystem.contains("Windows")) {
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                pb.inheritIO().start().waitFor();
            } else {
                // 这个命令对于 Unix 或类 Unix 系统有效
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        } catch (Exception e) {
            System.out.println("出错：" + e.getMessage());
        }
    }

}
