package GUI.Host.Control_Panel.Check_In_Panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;
import Mysql.Dao.Room_Panel_Dao;
import Mysql.Dao.User_Info_Manage_Dao;
import Mysql.Implement.Room_Panel_Dao_Impl;
import Mysql.Implement.User_Info_Manage_Dao_Impl;
import Mysql.Mysql_Obj.Check_In_Obj;
import Mysql.Mysql_Obj.Room;
import Mysql.Mysql_Obj.User_Info;
import Tools.Wake_Up.Wake_Up;
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
import javafx.scene.AccessibleAttribute;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class Choose_Room extends Application {
    ObservableList<Room> ob = FXCollections.observableArrayList();// 表格FXCollections
    public Check_In_Panel check_In_Panel;
    Room_Panel_Dao room_Panel_Dao;
    Vector<Room> arr_Room;
    User_Info_Manage_Dao u = new User_Info_Manage_Dao_Impl();

    public Choose_Room() {
        try {
            room_Panel_Dao = new Room_Panel_Dao_Impl();
            arr_Room = new Vector<Room>();
            select("", "", "", "", "", "", "", "空闲", "", "", LocalDate.now().toString(), LocalDate.now().toString());
        } catch (Exception e) {
            throw (e);
        }
    }

    public void select(String id, String number, String type, String discount, String deposit, String capacity,
            String price, String status, String principal, String description, String start_time, String end_time) {
        try {
            arr_Room.clear();
            Room r = new Room();
            String sql_command = "select r.* from room r left join check_in c  on r.room_id=c.room_id left join reservation b on r.room_id=b.room_id where (c.check_in_id is null or c.in_time>'"
                    + end_time + "' or c.out_time<'" + start_time + "') and (b.reservation_id is null or b.book_time>'"
                    + end_time + "' or b.end_time<'" + start_time + "')";
            boolean[] br = { false, false, false, false, false, false, false, false, false, false, false, false };
            if (!id.equals("")) {
                sql_command += " and r.room_id = ?";
                r.setRoom_id(Integer.parseInt(id));
                br[0] = true;
            }
            if (!number.equals("")) {
                sql_command += " and r.room_number = ?";
                r.setRoom_number(Integer.parseInt(number));
                br[1] = true;
            }
            if (!type.equals("")) {
                sql_command += " and r.room_type = ?";
                r.setRoom_type(type);
                br[2] = true;
            }
            if (!discount.equals("")) {
                sql_command += " and r.room_discount = ?";
                r.setRoom_discount(Double.parseDouble(discount));
                br[3] = true;
            }
            if (!deposit.equals("")) {
                sql_command += " and r.room_deposit = ?";
                r.setRoom_deposit(Double.parseDouble(deposit));
                br[4] = true;
            }
            if (!capacity.equals("")) {
                sql_command += " and r.room_capacity = ?";
                r.setRoom_capacity(Integer.parseInt(capacity));
                br[5] = true;
            }
            if (!price.equals("")) {
                sql_command += " and r.room_price = ?";
                r.setRoom_price(Double.parseDouble(price));
                br[6] = true;
            }
            if (!status.equals("")) {
                sql_command += " and r.room_status = ?";
                r.setRoom_status(status);
                br[7] = true;
            }
            if (!principal.equals("")) {
                sql_command += " and r.room_principal = ?";
                r.setRoom_principal(principal);
                br[8] = true;
            }
            if (!description.equals("")) {
                sql_command += " and r.room_description = ?";
                r.setRoom_description(description);
                br[9] = true;
            }

            if (room_Panel_Dao.select_data(arr_Room, sql_command, r, br[0], br[1], br[2], br[3], br[4], br[5], br[6],
                    br[7], br[8], br[9])) {
                ob.clear();
                for (int i = 0; i < arr_Room.size(); i++) {
                    ob.add(arr_Room.get(i));
                }
            }
        } catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("错误");
            alert.setContentText("输入的数据有误,请检查数据输入是否规范");
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
        // 自适应
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // 返回按钮
        Button back = new Button("返回");
        back.relocate(100, 0);
        back.setPrefSize(100, 50);
        back.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                check_In_Panel.stage.show();
                stage.close();
            }
        });

        // // 刷新按钮
        // Button refresh = new Button("刷新");
        // refresh.relocate(200, 0);
        // refresh.setPrefSize(100, 50);
        // refresh.setOnAction(new EventHandler<ActionEvent>() {
        // public void handle(ActionEvent event) {
        // ob.clear();
        // arr_Room.clear();
        // if (room_Panel_Dao.read_data(arr_Room)) {
        // for (int i = 0; i < arr_Room.size(); i++) {
        // ob.add(arr_Room.get(i));
        // }
        // }
        // }
        // });

        // // 返回按钮
        // Button back = new Button("返回");
        // back.relocate(300, 0);
        // back.setPrefSize(100, 50);
        // back.setOnAction(new EventHandler<ActionEvent>() {
        // public void handle(ActionEvent event) {
        // stage.close();
        // }
        // });

        // id_label
        Label id_label = new Label("id");
        id_label.relocate(420, 5);

        // id_text
        TextField id_Text = new TextField();
        id_Text.relocate(460, 0);
        id_Text.setPrefWidth(80);

        // number_Label
        Label number_Label = new Label("房间号");
        number_Label.relocate(420, 30);

        // number_Label
        TextField number_Text = new TextField();
        number_Text.relocate(460, 25);
        number_Text.setPrefWidth(80);

        // type_label
        Label type_Label = new Label("类型");
        type_Label.relocate(545, 5);

        // type_text
        TextField type_Text = new TextField();
        type_Text.relocate(585, 0);
        type_Text.setPrefWidth(80);

        // discount_label
        Label discount_Label = new Label("折扣");
        discount_Label.relocate(545, 30);

        // discount_text
        TextField discount_Text = new TextField();
        discount_Text.relocate(585, 25);
        discount_Text.setPrefWidth(80);

        // deposit_labe
        Label deposit_Label = new Label("押金");
        deposit_Label.relocate(670, 5);

        // deposit_text
        TextField deposit_Text = new TextField();
        deposit_Text.relocate(710, 0);
        deposit_Text.setPrefWidth(80);

        // capacity_label
        Label capacity_Label = new Label("容量");
        capacity_Label.relocate(670, 30);

        // capacity_text
        TextField capacity_Text = new TextField();
        capacity_Text.relocate(710, 25);
        capacity_Text.setPrefWidth(80);

        // price_label
        Label price_Label = new Label("价格");
        price_Label.relocate(795, 5);

        // price_text
        TextField price_Text = new TextField();
        price_Text.relocate(835, 0);
        price_Text.setPrefWidth(80);

        // status_label
        Label status_Label = new Label("状态");
        status_Label.relocate(795, 30);

        // status_text
        TextField status_Text = new TextField("空闲");
        status_Text.relocate(835, 25);
        status_Text.setPrefWidth(80);

        // start_time_label
        Label start_time_label = new Label("起始日期");
        start_time_label.relocate(920, 5);

        // start_time_text
        DatePicker start_time_text = new DatePicker(LocalDate.now());
        start_time_text.relocate(970, 0);
        start_time_text.setPrefWidth(110);

        // end_time_label
        Label end_time_label = new Label("结束时间");
        end_time_label.relocate(920, 30);

        // end_time_text
        DatePicker end_time_text = new DatePicker(LocalDate.now());
        end_time_text.relocate(970, 25);
        end_time_text.setPrefWidth(110);

        // principal_label
        Label principal_Label = new Label("负责人");
        principal_Label.relocate(1090, 5);

        // principal_text
        TextField principal_Text = new TextField();
        principal_Text.relocate(1140, 0);
        principal_Text.setPrefWidth(100);

        // description_label
        Label description_Label = new Label("描述");
        description_Label.relocate(1090, 30);

        // description_text
        TextField description_Text = new TextField();
        description_Text.relocate(1140, 25);
        description_Text.setPrefWidth(100);

        // user_id_label
        Label user_id_label = new Label("请填写用户id(必填):");
        user_id_label.relocate(1250, 0);
        // 设置字体为红色
        user_id_label.setTextFill(Color.RED);

        // user_id_text
        TextField user_id_text = new TextField();
        user_id_text.relocate(1250, 20);
        user_id_text.setPrefWidth(120);

        // 设置为特殊样式
        user_id_text.setStyle(
                "-fx-border-color: red;-fx-border-width: 2px;-fx-border-radius: 5px;-fx-border-style: dashed;-fx-border-insets: 1px;");

        // 清空按钮
        Button clear = new Button("清空");
        clear.relocate(200, 0);
        clear.setPrefSize(100, 50);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                id_Text.setText("");
                number_Text.setText("");
                type_Text.setText("");
                discount_Text.setText("");
                deposit_Text.setText("");
                capacity_Text.setText("");
                price_Text.setText("");
                status_Text.setText("");
                principal_Text.setText("");
                description_Text.setText("");
                user_id_text.setText("");
                start_time_text.setValue(LocalDate.now());
                end_time_text.setValue(LocalDate.now());
            }
        });

        // 搜索/刷新按钮
        Button search = new Button("搜索/刷新");
        search.relocate(300, 0);
        search.setPrefSize(100, 50);
        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String st = LocalDate.now().toString();
                String ed = LocalDate.now().toString();
                try {
                    st = start_time_text.getValue().toString();
                    ed = end_time_text.getValue().toString();
                    if (st.compareTo(ed) > 0) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("提示");
                        alert.setHeaderText("起始日期不能大于结束日期");
                        alert.showAndWait();
                        return;
                    }
                } catch (Exception e) {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("提示");
                    alert.setHeaderText("日期为空或格式错误");
                    alert.setContentText("请重新输入");
                }
                select(id_Text.getText(), number_Text.getText(), type_Text.getText(), discount_Text.getText(),
                        deposit_Text.getText(), capacity_Text.getText(), price_Text.getText(), status_Text.getText(),
                        principal_Text.getText(), description_Text.getText(), st, ed);
                table.refresh();
            }
        });
        // 确定按钮
        Button choose = new Button("确定");
        choose.relocate(0, 0);
        choose.setPrefSize(100, 50);
        choose.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                try {
                    // System.out.println(table.getSelectionModel().getSelectedItem().getRoom_id());
                    if (start_time_text.getValue() == null || end_time_text.getValue() == null) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("提示");
                        alert.setHeaderText("日期为空或格式错误");
                        alert.setContentText("请重新输入");
                        alert.showAndWait();
                        return;
                    }
                    if (start_time_text.getValue().toString().compareTo(end_time_text.getValue().toString()) > 0) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("提示");
                        alert.setHeaderText("起始日期不能大于结束日期");
                        alert.showAndWait();
                        return;
                    }
                    Vector<User_Info> arr_user = new Vector<User_Info>();
                    User_Info usf = new User_Info();
                    usf.setUser_id(Integer.valueOf(user_id_text.getText()));
                    boolean[] bl = { false, false, false, false, false, false, false, false, false, false, false,
                            false };
                    u.select_data(arr_user, usf, bl);
                    if (arr_user.size() == 0) {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("提示");
                        alert.setHeaderText("用户不存在");
                        alert.setContentText("请重新输入");
                        alert.showAndWait();
                        return;
                    } else {
                        check_In_Panel.new_check_In_Obj = new Check_In_Obj();
                        check_In_Panel.new_check_In_Obj
                                .setRoom_id(table.getSelectionModel().getSelectedItem().getRoom_id());
                        check_In_Panel.new_check_In_Obj.setUser_id(Integer.valueOf(user_id_text.getText()));
                    }
                    check_In_Panel.new_check_In_Obj.setIn_time(start_time_text.getValue().toString());
                    check_In_Panel.new_check_In_Obj.setOut_time(end_time_text.getValue().toString());
                    check_In_Panel.wake_up();
                    stage.close();
                } catch (Exception e) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setTitle("错误");
                    alert.setContentText("请先选择一行数据,并填写好用户id");
                    alert.showAndWait();
                }

            }
        });

        // // 使用指导
        // Label label = new Label("(Tips:单击单元格可选中,双击单元格可编辑,编辑后按回车键确认并保存)");
        // label.relocate(500, 15);
        // label.setStyle("-fx-font-size: 20px; -fx-text-fill: #ff0000;");

        // table.getSelectionModel().selectedItemProperty()
        // .addListener((ChangeListener<? super Room>) new ChangeListener<Room>() {
        // @Override
        // public void changed(ObservableValue<? extends Room> arg0, Room old_str, Room
        // new_str) {
        // // getSelectedIndex方法可获得选中项的序号，getSelectedItem方法可获得选中项的对象
        // // String desc = String.format(
        // // table.getSelectionModel().getSelectedIndex(),
        // // table.getSelectionModel().getSelectedItem().getRoom_capacity(),
        // // table.getSelectionModel().getSelectedItem().getRoom_number());
        // // label.setText(desc); // 在标签上显示当前选中的文本项
        // System.out.println(table.getSelectionModel().getSelectedItem().getRoom_number());
        // }
        // });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(table, choose, back, search, id_label, id_Text, number_Label, number_Text,
                type_Label,
                type_Text, discount_Label, discount_Text, deposit_Label, deposit_Text, capacity_Label, capacity_Text,
                price_Label, price_Text, status_Label, status_Text, principal_Label, principal_Text, description_Label,
                description_Text, clear, start_time_label, start_time_text, end_time_label, end_time_text,
                user_id_label, user_id_text);

        stage.setScene(new Scene(pane, 1400, 700));
        stage.setTitle("请选择房间:");
        // stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        // 添加窗体大小改变的监听事件
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
                    Number newSceneWidth) {
                table.setPrefWidth((double) newSceneWidth - 15);
            }
        });
        stage.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneHeight,
                    Number newSceneHeight) {
                table.setPrefHeight((double) newSceneHeight - 85);
            }
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
