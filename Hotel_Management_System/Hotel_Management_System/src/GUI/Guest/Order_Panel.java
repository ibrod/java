package GUI.Guest;

import java.util.Vector;

import GUI.Host.Control_Panel.Check_In_Panel.Check_In_Panel;
import Mysql.Dao.Check_In_Manage_Dao;
import Mysql.Dao.Reservation_Dao;
import Mysql.Dao.User_Info_Manage_Dao;
import Mysql.Implement.Check_In_Manage_Dao_Impl;
import Mysql.Implement.Reservation_Dao_Impl;
import Mysql.Implement.User_Info_Manage_Dao_Impl;
import Mysql.Mysql_Obj.Check_In_Obj;
import Mysql.Mysql_Obj.Reservation;
import Mysql.Mysql_Obj.User_Info;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Order_Panel extends Application {

    User_Info user_info;
    User_Info_Manage_Dao user_info_manage_dao=new User_Info_Manage_Dao_Impl();
    Check_In_Obj check_in_obj;
    Reservation_Dao reservation_Dao=new Reservation_Dao_Impl();
    Order_Panel(){
    }

    Order_Panel(String phone){
        user_info=new User_Info();
        user_info.setPhone_number(phone);
        boolean[] bl={false,false,false,true,false,false,false,false};
        Vector<User_Info>user_info_arr=new Vector<User_Info>();
        user_info_manage_dao.select_data(user_info_arr, user_info, bl);
        if(user_info_arr.size()==0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("错误");
            alert.setHeaderText("错误");
            alert.setContentText("该用户不存在");
            System.exit(0);
        }
        user_info=user_info_arr.get(0);
    }

    void refresh(Text no_order,Text order,Text room_number,Text check_in_time,Text check_out_time,Button order_room,Button cancel_order){
        Reservation reservation=new Reservation();
        reservation.setUser_id(user_info.getUser_id());
        boolean[] bl={false,true,false,false,false,false,false,false,false,false,false};
        Vector<Reservation>reservation_arr=new Vector<Reservation>();
        reservation_Dao.select_data(reservation_arr, reservation, bl);
        if(reservation_arr.size()==0){
            no_order.setVisible(true);
            order.setVisible(false);
            room_number.setVisible(false);
            check_in_time.setVisible(false);
            check_out_time.setVisible(false);
            order_room.setDisable(false);
            cancel_order.setDisable(true);
        }
        else{
            no_order.setVisible(false);
            order.setVisible(true);
            room_number.setVisible(true);
            check_in_time.setVisible(true);
            check_out_time.setVisible(true);
            order_room.setDisable(true);
            cancel_order.setDisable(false);
            reservation=reservation_arr.get(0);
            room_number.setText(String.valueOf(reservation.getRoom_number()));
            check_in_time.setText(reservation.getIn_time());
            check_out_time.setText(reservation.getOut_time());
        }
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

        //入住时间
        Text check_in_time = new Text("入住时间:");
        check_in_time.relocate(50, 75);
        check_in_time.setStyle("-fx-font-size: 15px");

        //到期时间
        Text check_out_time = new Text("退房时间:");
        check_out_time.relocate(50, 100);
        check_out_time.setStyle("-fx-font-size: 15px");

        //预定房间按钮
        javafx.scene.control.Button order_room = new javafx.scene.control.Button("预定房间");
        order_room.relocate(50, 125);
        order_room.setStyle("-fx-font-size: 15px");
        order_room.setPrefWidth(150);
        order_room.setOnAction(event -> {
            Choose_Room choose_Room=new Choose_Room(user_info);
            try {
                choose_Room.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        //取消预定按钮
        javafx.scene.control.Button cancel_order = new javafx.scene.control.Button("取消预定");
        cancel_order.relocate(210, 125);
        cancel_order.setStyle("-fx-font-size: 15px");
        cancel_order.setPrefWidth(150);
        cancel_order.setOnAction(event -> {
            // check_in_dao.delete_data(user_info.getUser_id());
            // refresh();
        });


        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(no_order, order, room_number, check_in_time, check_out_time, order_room, cancel_order);// 将控件添加到pane中
        stage.setScene(new Scene(pane, 400, 220));
        stage.setTitle("客户预定面板");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
        refresh(no_order, order, room_number, check_in_time, check_out_time, order_room, cancel_order);
    }

    public static void main(String[] args) {
        launch(args);
    }


}
