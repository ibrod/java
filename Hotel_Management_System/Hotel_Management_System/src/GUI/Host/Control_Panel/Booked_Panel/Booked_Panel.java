package GUI.Host.Control_Panel.Booked_Panel;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Vector;
import Mysql.Dao.Reservation_Dao;
import Mysql.Implement.Reservation_Dao_Impl;
import Mysql.Mysql_Obj.Reservation;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Booked_Panel extends Application {
    ObservableList<Reservation> ob = FXCollections.observableArrayList();// 表格FXCollections

    Reservation_Dao Reservation_Dao;
    Vector<Reservation> arr_obj;

    public Booked_Panel() {
        try {
            Reservation_Dao = new Reservation_Dao_Impl();
            arr_obj = new Vector<Reservation>();
            select("", "", "", "", "", "", "", "", "", "", "");
            // for (int i = 0; i < arr_obj.size(); i++) {
            // ob.add(arr_obj.get(i));
            // }
        } catch (Exception e) {
            throw (e);
        }
    }

    public void select(String id, String user_id, String name, String id_card, String phone, String room_id,
            String room_number, String in_time, String out_time,
            String payment, String note) {
        try {
            arr_obj.clear();
            Reservation r = new Reservation();
            boolean[] br = { false, false, false, false, false, false, false, false, false,
                    false, false, false, false };
            if (!id.equals("")) {
                r.setReservation_id(Integer.parseInt(id));
                br[0] = true;
            }
            if (!user_id.equals("")) {
                r.setUser_id(Integer.parseInt(user_id));
                br[1] = true;
            }
            if (!room_id.equals("")) {
                r.setRoom_id(Integer.parseInt(room_id));
                br[2] = true;
            }
            if (!in_time.equals("")) {
                r.setIn_time(in_time);
                br[3] = true;
            }
            if (!out_time.equals("")) {
                r.setOut_time(out_time);
                br[4] = true;
            }
            if (!payment.equals("")) {
                r.setPayment(Double.parseDouble(payment));
                br[5] = true;
            }
            if (!note.equals("")) {
                r.setNote(note);
                br[6] = true;
            }
            if (!room_number.equals("")) {
                r.setRoom_number(Integer.parseInt(room_number));
                br[7] = true;
            }
            if (!name.equals("")) {
                r.setName(name);
                br[8] = true;
            }
            if (!id_card.equals("")) {
                r.setId_card(id_card);
                br[9] = true;
            }
            if (!phone.equals("")) {
                r.setPhone_number(phone);
                br[10] = true;
            }
            // System.out.println(note);

            if (Reservation_Dao.select_data(arr_obj, r, br)) {
                // System.out.println(arr_obj.size());
                ob.clear();
                for (int i = 0; i < arr_obj.size(); i++) {
                    // System.out.println(arr_obj.get(i));
                    ob.add(arr_obj.get(i));
                    // System.out.println(arr_obj.get(i).getUser_id()+"
                    // "+arr_obj.get(i).getRoom_id()+" "+arr_obj.get(i).getRoom_number());
                    // System.out.println(arr_obj.get(i).getCheck_in_id()+"
                    // "+arr_obj.get(i).getName()+" "+arr_obj.get(i).getRoom_number()+"
                    // "+arr_obj.get(i).getIn_time()+" "+arr_obj.get(i).getOut_time()+"
                    // "+arr_obj.get(i).getPledge()+" "+arr_obj.get(i).getPayment()+"
                    // "+arr_obj.get(i).getNote()+" "+arr_obj.get(i).getRoom_id()+"
                    // "+arr_obj.get(i).getUser_id()+" "+arr_obj.get(i).getId_card()+"
                    // "+arr_obj.get(i).getPhone_number());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("错误");
            alert.setContentText("输入的数据有误,请检查数据输入是否规范");
            alert.showAndWait();
        }

    }

    public void start(Stage stage) {

        // 表格视图
        TableView<Reservation> table = new TableView<Reservation>();
        table.setPrefSize(1200, 650);
        table.relocate(0, 50);
        // 表头
        TableColumn<Reservation, String> id = new TableColumn<Reservation, String>("id");
        id.setCellValueFactory(new PropertyValueFactory<Reservation, String>("reservation_id"));
        // id.setVisible(false);
        TableColumn<Reservation, String> user_id = new TableColumn<Reservation, String>("用户id");
        user_id.setCellValueFactory(new PropertyValueFactory<Reservation, String>("user_id"));
        TableColumn<Reservation, String> name = new TableColumn<Reservation, String>("姓名");
        name.setCellValueFactory(new PropertyValueFactory<Reservation, String>("name"));
        TableColumn<Reservation, String> id_card = new TableColumn<Reservation, String>("身份证号");
        id_card.setCellValueFactory(new PropertyValueFactory<Reservation, String>("id_card"));
        TableColumn<Reservation, String> phone = new TableColumn<Reservation, String>("手机号");
        phone.setCellValueFactory(new PropertyValueFactory<Reservation, String>("phone_number"));
        TableColumn<Reservation, String> room_id = new TableColumn<Reservation, String>("房间ID");
        room_id.setCellValueFactory(new PropertyValueFactory<Reservation, String>("room_id"));
        TableColumn<Reservation, String> room_number = new TableColumn<Reservation, String>("房间号");
        room_number.setCellValueFactory(new PropertyValueFactory<Reservation, String>("room_number"));
        TableColumn<Reservation, String> in_time = new TableColumn<Reservation, String>("入住时间");
        in_time.setCellValueFactory(new PropertyValueFactory<Reservation, String>("in_time"));
        TableColumn<Reservation, String> out_time = new TableColumn<Reservation, String>("到期时间");
        out_time.setCellValueFactory(new PropertyValueFactory<Reservation, String>("out_time"));
        TableColumn<Reservation, String> payment = new TableColumn<Reservation, String>("支付金额");
        payment.setCellValueFactory(new PropertyValueFactory<Reservation, String>("payment"));
        TableColumn<Reservation, String> note = new TableColumn<Reservation, String>("备注");
        note.setCellValueFactory(new PropertyValueFactory<Reservation, String>("note"));
        table.getColumns().addAll(id, user_id, name, id_card, phone, room_id, room_number, in_time, out_time,
                payment, note);
        table.setItems(ob);

        table.setEditable(true);

        // id_label
        Label id_label = new Label("id");
        id_label.relocate(420, 5);

        // id_text
        TextField id_Text = new TextField();
        id_Text.relocate(450, 0);
        id_Text.setPrefWidth(80);

        // room_id_label
        Label room_id_label = new Label("房间id");
        room_id_label.relocate(540, 5);

        // room_id_text
        TextField room_id_text = new TextField();
        room_id_text.relocate(590, 0);
        room_id_text.setPrefWidth(80);

        // room_number_label
        Label room_number_label = new Label("房间号");
        room_number_label.relocate(540, 30);

        // room_number_Text
        TextField room_number_Text = new TextField();
        room_number_Text.relocate(590, 25);
        room_number_Text.setPrefWidth(80);

        // in_time_label
        Label in_time_label = new Label("入住时间");
        in_time_label.relocate(680, 5);

        // in_time_text
        DatePicker in_time_text = new DatePicker();
        in_time_text.relocate(735, 0);
        in_time_text.setPrefWidth(110);

        // out_time_label
        Label out_time_label = new Label("到期时间");
        out_time_label.relocate(680, 30);

        // out_time_text
        DatePicker out_time_text = new DatePicker();
        out_time_text.relocate(735, 25);
        out_time_text.setPrefWidth(110);

        // payment_label
        Label payment_label = new Label("付款");
        payment_label.relocate(850, 5);

        // payment_text
        TextField payment_text = new TextField();
        payment_text.relocate(880, 0);
        payment_text.setPrefWidth(80);

        // note_label
        Label note_label = new Label("备注");
        note_label.relocate(850, 30);

        // note_text
        TextField note_text = new TextField();
        note_text.relocate(880, 25);
        note_text.setPrefWidth(200);

        // user_id_label
        Label user_id_label = new Label("用户ID");
        user_id_label.relocate(410, 30);

        // user_id_text
        TextField user_id_text = new TextField();
        user_id_text.relocate(450, 25);
        user_id_text.setPrefWidth(80);

        // name_label
        Label name_label = new Label("姓名");
        name_label.relocate(970, 5);

        // name_text
        TextField name_text = new TextField();
        name_text.relocate(1000, 0);
        name_text.setPrefWidth(80);

        // phone_label
        Label phone_label = new Label("手机号");
        phone_label.relocate(1090, 5);

        // phone_text
        TextField phone_text = new TextField();
        phone_text.relocate(1150, 0);
        phone_text.setPrefWidth(150);

        // id_card_label
        Label id_card_label = new Label("身份证号");
        id_card_label.relocate(1090, 30);

        // id_card_text
        TextField id_card_text = new TextField();
        id_card_text.relocate(1150, 25);
        id_card_text.setPrefWidth(150);

        user_id.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getUser_id())));
        user_id.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        // name.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());
        // id_card.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());
        // phone.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        room_id.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getRoom_id())));
        room_id.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        in_time.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        out_time.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        payment.setCellValueFactory(
                cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getPayment())));
        payment.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        note.setCellFactory(TextFieldTableCell.<Reservation>forTableColumn());

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);// 自适应列宽

        user_id.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Reservation, String> t) {
                if (Reservation_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getReservation_id(), "user_id",
                        t.getNewValue())) {
                    select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                            phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                            in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                            out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                            payment_text.getText(), note_text.getText());
                    table.refresh();
                } else
                    table.refresh();
            }
        });

        room_id.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Reservation, String> t) {
                if (Reservation_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getReservation_id(), "room_id",
                        t.getNewValue())) {
                    select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                            phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                            in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                            out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                            payment_text.getText(), note_text.getText());
                    table.refresh();
                } else
                    table.refresh();
            }
        });

        in_time.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Reservation, String> t) {
                if (Reservation_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getReservation_id(), "book_time",
                        t.getNewValue())) {
                    select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                            phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                            in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                            out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                            payment_text.getText(), note_text.getText());
                    table.refresh();
                } else
                    table.refresh();
            }
        });

        out_time.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Reservation, String> t) {
                if (Reservation_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getReservation_id(), "end_time",
                        t.getNewValue())) {
                    select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                            phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                            in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                            out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                            payment_text.getText(), note_text.getText());
                    table.refresh();
                } else
                    table.refresh();
            }
        });

        payment.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Reservation, String> t) {
                if (Reservation_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getReservation_id(), "paid",
                        t.getNewValue())) {
                    select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                            phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                            in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                            out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                            payment_text.getText(), note_text.getText());
                    table.refresh();
                } else
                    table.refresh();
            }
        });

        note.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<Reservation, String> t) {
                if (Reservation_Dao.update_data(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getReservation_id(), "note",
                        t.getNewValue())) {
                    select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                            phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                            in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                            out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                            payment_text.getText(), note_text.getText());
                    table.refresh();
                } else
                    table.refresh();
            }
        });

        // 使用自定义排序
        user_id.setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });

        // 使用自定义排序
        room_id.setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
            }
        });

        // 使用自定义排序
        in_time.setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Timestamp.valueOf(o1).compareTo(Timestamp.valueOf(o2));
            }
        });

        // 使用自定义排序
        out_time.setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Timestamp.valueOf(o1).compareTo(Timestamp.valueOf(o2));
            }
        });

        // 使用自定义排序
        payment.setComparator(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Double.valueOf(o1).compareTo(Double.valueOf(o2));
            }
        });

        // // 返回按钮
        // Button back = new Button("返回");
        // back.relocate(300, 0);
        // back.setPrefSize(100, 50);
        // back.setOnAction(new EventHandler<ActionEvent>() {
        // public void handle(ActionEvent event) {
        // stage.close();
        // }
        // });

        // DatePicker in_time_picker = new DatePicker();
        // in_time_picker.relocate(0, 0);
        // in_time_picker.setPrefSize(100, 50);
        // in_time_picker.setOnAction(new EventHandler<ActionEvent>() {
        // public void handle(ActionEvent event) {
        // ob.clear();
        // arr_Check_In_Obj.clear();
        // if (Reservation_Dao.read_data(arr_Check_In_Obj,
        // in_time_picker.getValue().toString())) {
        // for (int i = 0; i < arr_Check_In_Obj.size(); i++) {
        // ob.add(arr_Check_In_Obj.get(i));
        // }
        // }
        // }
        // });

        // 添加按钮
        Button add = new Button("添加");
        add.relocate(0, 0);
        add.setPrefSize(100, 50);
        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Reservation r = new Reservation();
                r.setReservation_id(Reservation_Dao.add_data());
                ob.add(r);
                table.refresh();
                int row = ob.size() - 1;
                table.requestFocus();
                table.getSelectionModel().select(row);
                table.getSelectionModel().focus(row);
            }
        });

        // 删除按钮
        Button delete = new Button("删除");
        delete.relocate(100, 0);
        delete.setPrefSize(100, 50);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (table.getSelectionModel().getSelectedItem() != null) {
                    Reservation_Dao.delete_data(table.getSelectionModel().getSelectedItem().getReservation_id());
                    ob.remove(table.getSelectionModel().getSelectedItem());
                    table.refresh();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("提示");
                    alert.setHeaderText(null);
                    alert.setContentText("请先选中要删除的行");
                    alert.showAndWait();
                }
            }
        });

        // 清空按钮
        Button clear = new Button("清空");
        clear.relocate(200, 0);
        clear.setPrefSize(100, 50);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                id_Text.setText("");
                room_id_text.setText("");
                room_number_Text.setText("");
                in_time_text.setValue(null);
                out_time_text.setValue(null);
                note_text.setText("");
                user_id_text.setText("");
                name_text.setText("");
                id_card_text.setText("");
                phone_text.setText("");
                payment_text.setText("");
            }
        });

        // 搜索/刷新按钮
        Button search = new Button("搜索/刷新");
        search.relocate(300, 0);
        search.setPrefSize(100, 50);
        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                select(id_Text.getText(), user_id_text.getText(), name_text.getText(), id_card_text.getText(),
                        phone_text.getText(), room_id_text.getText(), room_number_Text.getText(),
                        in_time_text.getValue() == null ? "" : in_time_text.getValue().toString(),
                        out_time_text.getValue() == null ? "" : out_time_text.getValue().toString(),
                        payment_text.getText(), note_text.getText());
                table.refresh();
            }
        });

        // // 使用指导
        // Label label = new Label("(Tips:单击单元格可选中,双击单元格可编辑,编辑后按回车键确认并保存)");
        // label.relocate(500, 15);
        // label.setStyle("-fx-font-size: 20px; -fx-text-fill: #ff0000;");

        // table.getSelectionModel().selectedItemProperty()
        // .addListener((ChangeListener<? super Reservation>) new
        // ChangeListener<Reservation>() {
        // @Override
        // public void changed(ObservableValue<? extends Reservation> arg0,
        // Reservation old_str, Reservation
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
        pane.getChildren().addAll(table, add, delete, search, id_label, id_Text, clear, room_id_label, room_id_text,
                room_number_label, room_number_Text, in_time_label, in_time_text, out_time_label, out_time_text,
                note_label, note_text, user_id_label, user_id_text, name_label, name_text,
                id_card_label, id_card_text, phone_label, phone_text, payment_label, payment_text);

        stage.setScene(new Scene(pane, 1350, 700));
        stage.setTitle("房间管理面板");
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
