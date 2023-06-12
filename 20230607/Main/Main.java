package Main;
import GUI.MainController;
/*
 项目功能：开发易买网app中用户的购书功能，可实现用户添加订单、删除订单、修改订单、查询订单、显示订单等功能。
 */


public class Main {
    public static void main(String[] args) {
       MainController mainController = new MainController();
       mainController.start();
    }
}
