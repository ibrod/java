package GUI.Host.Control_Panel.Room_Panel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import Mysql.Dao.Room_Panel_Dao;
import Mysql.Implement.Room_Panel_Dao_Impl;
import Mysql.Mysql_Obj.Room;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Room_Panel extends Application {
    ObservableList<Room> ob = FXCollections.observableArrayList();// 表格FXCollections

    Room_Panel_Dao room_Panel_Dao;
    Vector<Room> arr_Room;


    public void init() {// 重写init方法，用于初始化数据
        try {
             room_Panel_Dao=new Room_Panel_Dao_Impl();
             arr_Room = new Vector<Room>();
             if (room_Panel_Dao.read_data(arr_Room)) {
                for (int i = 0; i < arr_Room.size(); i++) {
                    ob.add(arr_Room.get(i));
                }
             }
        } catch (Exception e) {
            throw (e);
        }
    }

    public void start(Stage stage) {

        // 表格视图
        TableView<Room> table = new TableView<Room>();
        table.setPrefSize(1200, 650);
        table.relocate(0, 50);
        // 表头
        TableColumn<Room, String> id = new TableColumn<Room, String>("id");
        id.setCellValueFactory(new PropertyValueFactory<Room, String>("room_id"));
        TableColumn<Room, String> number = new TableColumn<Room, String>("房间号");
        number.setCellValueFactory(new PropertyValueFactory<Room, String>("room_number"));
        TableColumn<Room, String> type = new TableColumn<Room, String>("类型");
        type.setCellValueFactory(new PropertyValueFactory<Room, String>("room_type"));
        TableColumn<Room, String> discount = new TableColumn<Room, String>("折扣");
        discount.setCellValueFactory(new PropertyValueFactory<Room, String>("room_discount"));
        TableColumn<Room, String> deposit = new TableColumn<Room, String>("押金");
        deposit.setCellValueFactory(new PropertyValueFactory<Room, String>("room_deposit"));
        TableColumn<Room, String> capacity = new TableColumn<Room, String>("容量");
        capacity.setCellValueFactory(new PropertyValueFactory<Room, String>("room_capacity"));
        TableColumn<Room, String> price = new TableColumn<Room, String>("价格");
        price.setCellValueFactory(new PropertyValueFactory<Room, String>("room_price"));
        TableColumn<Room, String> status = new TableColumn<Room, String>("状态");
        status.setCellValueFactory(new PropertyValueFactory<Room, String>("room_status"));
        TableColumn<Room, String> principal = new TableColumn<Room, String>("负责人");
        principal.setCellValueFactory(new PropertyValueFactory<Room, String>("room_principal"));
        TableColumn<Room, String> description = new TableColumn<Room, String>("描述");
        description.setCellValueFactory(new PropertyValueFactory<Room, String>("room_description"));


        table.getColumns().addAll(id, number, type, discount, deposit, capacity, price, status, principal, description);
        table.setItems(ob);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);// 自适应列宽

        table.getSelectionModel().selectedItemProperty()
                .addListener((ChangeListener<? super Room>) new ChangeListener<Room>() {
                    @Override
                    public void changed(ObservableValue<? extends Room> arg0, Room old_str, Room new_str) {
                        // getSelectedIndex方法可获得选中项的序号，getSelectedItem方法可获得选中项的对象
                        // String desc = String.format(
                        //         table.getSelectionModel().getSelectedIndex(),
                        //         table.getSelectionModel().getSelectedItem().getRoom_capacity(),
                        //         table.getSelectionModel().getSelectedItem().getRoom_number());
                        // label.setText(desc); // 在标签上显示当前选中的文本项
                        System.out.println(table.getSelectionModel().getSelectedItem().getRoom_number());
                    }
                });

        // table.getSelectionModel().selectedItemProperty()
        // .addListener((ChangeListener<? super String>) new ChangeListener<String>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> arg0, String old_str, String new_str) {
        //         // getSelectedIndex方法可获得选中项的序号，getSelectedItem方法可获得选中项的对象
        //         String desc = String.format("您点了第%d项，快餐名称是%s",
        //                 list.getSelectionModel().getSelectedIndex(),
        //                 list.getSelectionModel().getSelectedItem().toString());
        //         label.setText(desc); // 在标签上显示当前选中的文本项
        //     }
        // });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(table);// 将表格视图添加到pane中

        stage.setScene(new Scene(pane, 1200, 700));
        stage.setTitle("实验二 计科20-2BJ 向杰");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
        // TimerTask t2 = new TimerTask() {
        //     public void run() {
        //         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //         welcome.setText((String.valueOf(df.format(System.currentTimeMillis()))));
        //     }
        // };
        // Timer timer = new Timer();
        // timer.schedule(t2, 0, 1000);
    }   
    public static void main(String[] args) {
        launch(args);
    }
}
