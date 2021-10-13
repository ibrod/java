import java.net.CacheResponse;
import java.util.*;

class goods {
    public double price;
    public String name;
    public String info;
    public int status;

    goods() {
    }

    goods(double price, String name, String info) {
        this.price = price;
        this.name = name;
        this.info = info;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

}

class Service {
    goods goods_heap[];
    private double sales_volume = 0;
    int idx = 0;// 表示商品指针

    Service(int cap) {// 初始化商品要提供商品仓库的大小，也就是说可以容纳的商品数量
        sales_volume = 0;
        goods_heap = new goods[cap];
        for (int i = 0; i < goods_heap.length; i++) {
            goods_heap[i] = new goods();// 初始化每个商品
        }
    }

    Service() {
        sales_volume = 0;
        int cap = 1000;// 默认提供1000个商品的仓库容量
        goods_heap = new goods[cap];
        for (int i = 0; i < goods_heap.length; i++) {
            goods_heap[i] = new goods();// 初始化每个商品
        }
    }

    public void add(String name, double price, String info) {// 添加商品
        goods_heap[idx].name = name;
        goods_heap[idx].price = price;
        goods_heap[idx].info = info;
        idx++;
    }

    public void showGoods(String bl) {
        System.out.println("信息输出格式:商品名+描述信息+价格");
        if (bl.equals("ALL")) {
            for (int i = 0; i <= idx; i++) {
                System.out.println(goods_heap[i].name + " " + goods_heap[i].info + " " + goods_heap[i].price + "￥");
            }
        } else {
            for (int i = 0; i <= idx; i++) {
                if (goods_heap[i].name.equals(bl)) {
                    System.out.println(goods_heap[i].name + " " + goods_heap[i].info + " " + goods_heap[i].price + "￥");
                    return;
                }
            }
            System.out.println("查无此商品");
            return;
        }
    }

    void sell(String name, int ts) {
        for (int i = 0; i <= idx; i++) {
            if (goods_heap[i].name.equals(name)) {
                sales_volume += goods_heap[i].price * ts;
                return;
            }
        }
    }

    void show_Sales_volume() {
        java.util.Date date = new java.util.Date();
        System.out.println("当前时间:" + date.getTime());
        System.out.println("营业额为:" + sales_volume);
    }

    void setStatus(String name, int n) {
        for (int i = 0; i <= idx; i++) {
            if (goods_heap[i].name.equals(name)) {
                goods_heap[i].status = n;
                return;
            }
        }
        System.out.println("查无此商品");
        return;
    }

    void getStatus(String name) {
        for (int i = 0; i <= idx; i++) {
            if (goods_heap[i].name.equals(name)) {
                System.out.println("此商品的配送状态为:" + goods_heap[i].status);
                System.out.println("(status:0表示未配送,1表示正在配送，2表示已完成配送)");
                return;
            }
        }
        System.out.println("查无此商品");
        return;
    }
}

public class Operator_System {
    public static void main(String[] args) {
        Service sv = new Service(1000);
        String command;
        System.out.println("你已进入控制台，请输入命令,如需帮助，请输入help按下回车：");
        Scanner sc = new Scanner(System.in);
        while (true) {
            command = sc.next();
            switch (command) {
                case "exit":
                    return;
                case "help":
                    get_help();
                    break;
                case "add":
                    String gds = sc.next();
                    String intro = sc.next();
                    int pri = sc.nextInt();
                    sv.add(gds, pri, intro);
                    break;
                case "show":
                    String name = sc.next();
                    if(name.equals("all")){
                        sv.showGoods("ALL");
                    }else if(name.equals("sales_volume")){
                        sv.show_Sales_volume();
                    }else{
                        sv.showGoods(name);
                    }
                    break;
                case "sell":
                    command=sc.next();
                    int ts=sc.nextInt();
                    sv.sell(command, ts);
                    break;
                case "set":
                    command=sc.next();
                    int st=sc.nextInt();
                    sv.setStatus(command, st);
                    break;
                case "check":
                    command=sc.next();
                    sv.getStatus(command);
                    break;
                default:
                    System.out.println("输入错误,请重新输入");
            }
        }

    }

    static void get_help() {
        System.out.println("添加商品: add [商品名] [商品描述] [商品价格]");
        System.out.println("显示所有商品信息: show all");
        System.out.println("显示某件商品信息：show [商品名]");
        System.out.println("卖出某件商品:sell [商品名] [卖出的数量]");
        System.out.println("显示当前营业额:show sales_volume");
        System.out.println("设置配送状态(status:0表示未配送,1表示正在配送，2表示已完成配送):set [商品名] [status]");
        System.out.println("查看商品配送状态:check [商品名]");
        System.out.println("帮助: help");
        System.out.println("退出:exit");

    }

}