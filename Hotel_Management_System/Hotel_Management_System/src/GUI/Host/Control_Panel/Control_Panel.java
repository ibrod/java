package GUI.Host.Control_Panel;

import java.text.SimpleDateFormat;
import java.util.Date;

import GUI.Host.HostLogin;
import Mysql.Dao.Control_Panel_Dao;
import Mysql.Implement.Control_Panel_Dao_Impl;
import Mysql.Mysql_Obj.Control_Panel_Obj;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import GUI.Host.Control_Panel.Admin_Panel.Admin_Panel;
import GUI.Host.Control_Panel.Room_Panel.Room_Panel;

class Refresh_Control_Panel_Obj implements Runnable {

    Text room_num;
    Text room_booked;
    Text customer_num;
    Text admin_num;
    Text occupied;
    Control_Panel_Dao control_panel_dao;
    Control_Panel_Obj control_panel_obj;

    Refresh_Control_Panel_Obj(Text room_num, Text room_booked, Text customer_num, Text admin_num,Text occupied) {
        this.room_num = room_num;
        this.room_booked = room_booked;
        this.customer_num = customer_num;
        this.admin_num = admin_num;
        this.occupied=occupied;
        control_panel_dao = new Control_Panel_Dao_Impl();
    }

    @Override
    public void run() {
        // 每三秒刷新一次
        while (true) {
            control_panel_obj = control_panel_dao.query();
            room_num.setText("剩余房间数：" + control_panel_obj.getSurplus());
            room_booked.setText("已被预订房间数：" + control_panel_obj.getOccupied());
            customer_num.setText("用户账号总数：" + control_panel_obj.getUser_num());
            admin_num.setText("管理员账号总数：" + control_panel_obj.getAdmin_num());
            occupied.setText("已被入住房间数："+control_panel_obj.getBooked());
            // System.out.println("刷新了一次");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}

public class Control_Panel extends Application {

    @Override
    public void start(Stage stage) {
        // 显示时间的控件
        Label time = new Label();
        time.relocate(40, 25);
        time.setStyle(
                "-fx-font-size: 17px; -fx-text-fill: red;");

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                time.setText("欢迎来到酒店管理面板,现在时间是" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            }
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // 房间管理按钮
        Button room_manage = new Button("房间管理");
        room_manage.relocate(40, 140);
        room_manage.setPrefWidth(100);
        room_manage.setPrefHeight(30);
        room_manage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 new Room_Panel().start(new Stage());
            }
        });

        // 预订记录查询按钮
        Button book_record = new Button("预订管理");
        book_record.relocate(170, 140);
        book_record.setPrefWidth(100);
        book_record.setPrefHeight(30);
        book_record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // new Book_Record().start(new Stage());
            }
        });

        // 客户管理按钮
        Button customer_manage = new Button("客户管理");
        customer_manage.relocate(40, 80);
        customer_manage.setPrefWidth(100);
        customer_manage.setPrefHeight(30);
        customer_manage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // new Customer_Manage().start(new Stage());
            }
        });

        // 入住记录查询
        Button check_in_record = new Button("入住管理");
        check_in_record.relocate(170, 80);
        check_in_record.setPrefWidth(100);
        check_in_record.setPrefHeight(30);
        check_in_record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // new Check_In_Record().start(new Stage());
            }
        });

        // 管理员账号管理按钮
        Button admin_manage = new Button("管理员账号管理");
        admin_manage.relocate(40, 200);
        admin_manage.setPrefWidth(100);
        admin_manage.setPrefHeight(30);
        admin_manage.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Admin_Panel admin_Panel = new Admin_Panel();
                admin_Panel.start(new Stage());
                stage.close();
            }
        });

        // 历史记录查询
        Button history_record = new Button("历史记录管理");
        history_record.relocate(170, 200);
        history_record.setPrefWidth(100);
        history_record.setPrefHeight(30);
        history_record.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // new History_Record().start(new Stage());
            }
        });

        // 开启服务器模式按钮
        Button server_bButton = new Button("开启服务模式");
        server_bButton.relocate(40, 260);
        server_bButton.setPrefWidth(100);
        server_bButton.setPrefHeight(30);
        server_bButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // new Server_Mode().start(new Stage());

            }
        });

        // 剩余房间数
        Text room_num = new Text();
        room_num.relocate(300, 80);
        room_num.setStyle(
                "-fx-font-size: 15px; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(115, 115, 115,0.8), 5, 0, 10, 10);");

        // 已被预订房间数
        Text room_booked = new Text();
        room_booked.relocate(300, 130);
        room_booked.setStyle(
                "-fx-font-size: 15px; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(115, 115, 115,0.8), 5, 0, 10, 10);");

        // 已被入住的房间数:
        Text occupied = new Text();
        occupied.relocate(300, 180);
        occupied.setStyle(
                "-fx-font-size: 15px; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(115, 115, 115,0.8), 5, 0, 10, 10);");

        // 用户总数
        Text customer_num = new Text();
        customer_num.relocate(300, 230);
        customer_num.setStyle(
                "-fx-font-size: 15px; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(115, 115, 115,0.8), 5, 0, 10, 10);");

        // 管理员账号总数
        Text admin_num = new Text();
        admin_num.relocate(300, 280);
        admin_num.setStyle(
                "-fx-font-size: 15px; -fx-text-fill: black; -fx-effect: dropshadow(three-pass-box, rgba(115, 115, 115,0.8), 5, 0, 10, 10);");

        // 开启守护线程
        Refresh_Control_Panel_Obj refresh_control_panel_obj = new Refresh_Control_Panel_Obj(room_num, room_booked,
                customer_num, admin_num, occupied);
        Thread thread = new Thread(refresh_control_panel_obj);
        thread.setDaemon(true);
        thread.start();

        // 返回按钮
        Button back = new Button("返回");
        back.relocate(170, 260);
        back.setPrefWidth(100);
        back.setPrefHeight(30);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HostLogin hostLogin = new HostLogin();
                try {
                    hostLogin.start(new Stage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                thread.stop();
                stage.close();
            }
        });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(time, room_manage, customer_manage, admin_manage, back, room_num, room_booked,
                customer_num, admin_num, server_bButton, book_record, check_in_record, history_record, occupied);
        stage.setScene(new Scene(pane, 500, 350));// 设置场景
        stage.setTitle("酒店管理面板");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
