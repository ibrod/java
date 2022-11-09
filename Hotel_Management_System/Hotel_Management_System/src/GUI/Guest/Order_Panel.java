package GUI.Guest;

import GUI.Host.Control_Panel.Check_In_Panel.Check_In_Panel;
import Mysql.Dao.Check_In_Manage_Dao;
import Mysql.Implement.Check_In_Manage_Dao_Impl;
import Mysql.Mysql_Obj.Check_In_Obj;
import Mysql.Mysql_Obj.User_Info;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Order_Panel extends Application {

    User_Info user_info;
    Check_In_Obj check_in_obj;
    Check_In_Manage_Dao check_in_dao = new Check_In_Manage_Dao_Impl();

    void refresh(){


    }


    @Override
    public void start(Stage stage) throws Exception {
    
        //未预定文字显示
        Text no_order = new Text("您还未预定房间,请先预定房间");
        no_order.relocate(50, 25);
        no_order.setStyle("-fx-font-size: 15px;");
        no_order.setFill(javafx.scene.paint.Color.RED);
        no_order.setVisible(true);
        //设置颜色为红色

        //已预定文字显示
        Text order = new Text("您预定的房间信息如下:");
        order.relocate(50, 25);
        order.setStyle("-fx-font-size: 15px");
        order.setFill(javafx.scene.paint.Color.BLUE);
        order.setVisible(false);

        //房间号
        Text room_number = new Text("房间号:");
        room_number.relocate(50, 50);
        room_number.setStyle("-fx-font-size: 15px");

        //房间类型
        Text room_type = new Text("房间类型:");
        room_type.relocate(50, 75);
        room_type.setStyle("-fx-font-size: 15px");

        //入住时间
        Text check_in_time = new Text("入住时间:");
        check_in_time.relocate(50, 100);
        check_in_time.setStyle("-fx-font-size: 15px");

        //到期时间
        Text check_out_time = new Text("退房时间:");
        check_out_time.relocate(50, 125);
        check_out_time.setStyle("-fx-font-size: 15px");

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(no_order, order, room_number, room_type, check_in_time, check_out_time);// 将控件添加到pane中
        stage.setScene(new Scene(pane, 460, 220));
        stage.setTitle("客户预定面板");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


}
