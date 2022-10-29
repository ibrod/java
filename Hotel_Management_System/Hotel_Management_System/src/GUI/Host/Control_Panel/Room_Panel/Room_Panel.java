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
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class Room_Panel extends Application {
    ObservableList<Room> ob = FXCollections.observableArrayList();// 表格FXCollections

    Room_Panel_Dao room_Panel_Dao;
    Vector<Room> arr_Room;

    public Room_Panel() {
        try {
            room_Panel_Dao = new Room_Panel_Dao_Impl();
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
        table.setEditable(true);

        number.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoom_number())));
        number.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        type.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        discount.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoom_discount())));
        discount.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        deposit.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoom_deposit())));
        deposit.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        capacity.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoom_capacity())));
        capacity.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        price.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoom_price())));
        price.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        status.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        principal.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        description.setCellFactory(TextFieldTableCell.<Room>forTableColumn());

        number.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(), "room_number",
                        t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setRoom_number(Integer.valueOf(t.getNewValue()));
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });

        type.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_type", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setRoom_type(t.getNewValue());
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });

        discount.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_discount", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setRoom_discount(Double.valueOf(t.getNewValue()));
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });

        deposit.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_deposit", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setRoom_deposit(Double.valueOf(t.getNewValue()));
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });

        capacity.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_capacity", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setRoom_capacity(Integer.valueOf(t.getNewValue()));
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        price.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_price", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow())
                            .setRoom_price(Double.valueOf(t.getNewValue()));
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        status.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_status", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setRoom_status(t.getNewValue());
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        principal.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_principal", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setRoom_principal(t.getNewValue());
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });

        description.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Room, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Room, String> t) {
                if (room_Panel_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getRoom_id(),
                        "room_description", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setRoom_description(t.getNewValue());
                // room_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });

        // 添加按钮
        Button add = new Button("添加");
        add.relocate(0, 0);
        add.setPrefSize(100, 50);
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Room r = new Room();
                r.setRoom_id(room_Panel_Dao.add_data());
                ob.add(r);
                table.refresh();
                table.getSelectionModel().select(r);
            }
        });

        // 删除按钮
        Button delete = new Button("删除");
        delete.relocate(100, 0);
        delete.setPrefSize(100, 50);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(table.getSelectionModel().getSelectedItem()!=null){
                    room_Panel_Dao.delete_data(table.getSelectionModel().getSelectedItem().getRoom_id());
                    ob.remove(table.getSelectionModel().getSelectedItem());
                    table.refresh();
                }else{
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("提示");
                    alert.setHeaderText(null);
                    alert.setContentText("请先选中要删除的行");
                    alert.showAndWait();
                }
            }
        });

        // 刷新按钮
        Button refresh = new Button("刷新");
        refresh.relocate(200, 0);
        refresh.setPrefSize(100, 50);
        refresh.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                ob.clear();
                arr_Room.clear();
                if (room_Panel_Dao.read_data(arr_Room)) {
                    for (int i = 0; i < arr_Room.size(); i++) {
                        ob.add(arr_Room.get(i));
                    }
                }
            }
        });

        // 返回按钮
        Button back = new Button("返回");
        back.relocate(300, 0);
        back.setPrefSize(100, 50);
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        //使用指导
        Label label = new Label("(Tips:单击单元格可选中,双击单元格可编辑,编辑后按回车键确认并保存)");
        label.relocate(500,15);
        label.setStyle("-fx-font-size: 20px; -fx-text-fill: #ff0000;");

        // table.getSelectionModel().selectedItemProperty()
        //         .addListener((ChangeListener<? super Room>) new ChangeListener<Room>() {
        //             @Override
        //             public void changed(ObservableValue<? extends Room> arg0, Room old_str, Room new_str) {
        //                 // getSelectedIndex方法可获得选中项的序号，getSelectedItem方法可获得选中项的对象
        //                 // String desc = String.format(
        //                 // table.getSelectionModel().getSelectedIndex(),
        //                 // table.getSelectionModel().getSelectedItem().getRoom_capacity(),
        //                 // table.getSelectionModel().getSelectedItem().getRoom_number());
        //                 // label.setText(desc); // 在标签上显示当前选中的文本项
        //                 System.out.println(table.getSelectionModel().getSelectedItem().getRoom_number());
        //             }
        //         });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(table, add, delete, back, refresh, label);// 将tableview添加到pane中

        stage.setScene(new Scene(pane, 1200, 700));
        stage.setTitle("房间管理面板");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
