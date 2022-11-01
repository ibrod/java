package GUI.Host.Control_Panel.User_Manage_Panel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Vector;

import Mysql.Dao.User_Info_Manage_Dao;
import Mysql.Implement.User_Info_Manage_Dao_Impl;
import Mysql.Mysql_Obj.User_Info;
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
import javafx.scene.layout.Border;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.converter.IntegerStringConverter;

public class User_Manage_Panel extends Application {
    ObservableList<User_Info> ob = FXCollections.observableArrayList();// 表格FXCollections

    User_Info_Manage_Dao User_Info_Panel_Dao;
    Vector<User_Info> arr_User_Info;

    public User_Manage_Panel() {
        try {
            User_Info_Panel_Dao = new User_Info_Manage_Dao_Impl();
            arr_User_Info = new Vector<User_Info>();
            if (User_Info_Panel_Dao.read_data(arr_User_Info)) {
                for (int i = 0; i < arr_User_Info.size(); i++) {
                    ob.add(arr_User_Info.get(i));
                }
            }
        } catch (Exception e) {
            throw (e);
        }
    }

    public void select(String user_id, String name, String gender, String phone, String id_card, String email,String type) {
        try {
            arr_User_Info.clear();
            User_Info r=new User_Info();
            boolean[] br = { false, false, false, false, false,false,false};
            if (!user_id.equals("")) {
                r.setUser_id(Integer.parseInt(user_id));
                br[0]=true;
            }
            if (!name.equals("")) {
                r.setName(name);
                br[1]=true;
            }
            if (!gender.equals("")) {
                r.setGender(gender);
                br[2]=true;
            }
            if (!phone.equals("")) {
                r.setPhone_number(phone);
                br[3]=true;
            }
            if (!id_card.equals("")) {
                r.setId_card(id_card);
                br[4]=true;
            }
            if (!email.equals("")) {
                r.setEmail(email);
                br[5]=true;
            }
            if(!type.equals("")) {
                r.setType(type);
                br[6]=true;
            }

            //System.out.println(br[0]+" "+br[1]+" "+br[2]+" "+br[3]+" "+br[4]+" "+br[5]);
            if (User_Info_Panel_Dao.select_data(arr_User_Info,r,br)) {
                ob.clear();
                for (int i = 0; i < arr_User_Info.size(); i++) {
                    ob.add(arr_User_Info.get(i));
                }
            }
        } catch (Exception e) {
            Alert alert=new Alert(AlertType.ERROR);
            alert.setTitle("错误");
            alert.setContentText("输入的数据有误,请检查数据输入是否规范");
            alert.showAndWait();
        }

    }

    public void start(Stage stage) {

        // 表格视图
        TableView<User_Info> table = new TableView<User_Info>();
        table.setPrefSize(1200, 650);
        table.relocate(0, 50);

        // 表头
        TableColumn<User_Info, String> id = new TableColumn<User_Info, String>("id");
        id.setCellValueFactory(new PropertyValueFactory<User_Info, String>("user_id"));
        TableColumn<User_Info, String> name = new TableColumn<User_Info, String>("姓名");
        name.setCellValueFactory(new PropertyValueFactory<User_Info, String>("name"));
        TableColumn<User_Info, String> gender = new TableColumn<User_Info, String>("性别");
        gender.setCellValueFactory(new PropertyValueFactory<User_Info, String>("gender"));
        TableColumn<User_Info, String> phone_number = new TableColumn<User_Info, String>("手机号");
        phone_number.setCellValueFactory(new PropertyValueFactory<User_Info, String>("phone_number"));
        TableColumn<User_Info, String> Id_card = new TableColumn<User_Info, String>("身份证号");
        Id_card.setCellValueFactory(new PropertyValueFactory<User_Info, String>("Id_card"));
        TableColumn<User_Info, String> email = new TableColumn<User_Info, String>("邮箱");
        email.setCellValueFactory(new PropertyValueFactory<User_Info, String>("email"));
        TableColumn<User_Info, String> type = new TableColumn<User_Info, String>("类型");
        type.setCellValueFactory(new PropertyValueFactory<User_Info, String>("type"));

        table.getColumns().addAll(id, name, gender, phone_number, Id_card, email,type);
        table.setItems(ob);

        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);// 自适应列宽
        table.setEditable(true);

        // id.setCellValueFactory(
        //         cellData -> new ReadOnlyIntegerWrapper(String.valueOf(cellData.getValue().getUser_id())));
        
         name.setCellFactory(TextFieldTableCell.<User_Info>forTableColumn());
         gender.setCellFactory(TextFieldTableCell.<User_Info>forTableColumn());
         phone_number.setCellFactory(TextFieldTableCell.<User_Info>forTableColumn());
         Id_card.setCellFactory(TextFieldTableCell.<User_Info>forTableColumn());
         email.setCellFactory(TextFieldTableCell.<User_Info>forTableColumn());
         type.setCellFactory(TextFieldTableCell.<User_Info>forTableColumn());


        // id.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
        //     @Override
        //     public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
        //         if (User_Info_Panel_Dao.update_data(
        //                 t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_Info_id(), "User_Info_number",
        //                 t.getNewValue()))
        //             t.getTableView().getItems().get(t.getTablePosition().getRow())
        //                     .setUser_Info_number(Integer.valueOf(t.getNewValue()));
        //         // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
        //         else
        //             table.refresh();
        //     }
        // });

        // //使用自定义排序
        // id.setComparator(new Comparator<String>() {
        //     @Override
        //     public int compare(String o1, String o2) {
        //         return Integer.valueOf(o1).compareTo(Integer.valueOf(o2));
        //     }
        // });
        

        name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
                if (User_Info_Panel_Dao.update_by_id(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_id(), "name", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setName(t.getNewValue());
                // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        gender.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
                if (User_Info_Panel_Dao.update_by_id(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_id(), "gender", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setGender(t.getNewValue());
                // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        phone_number.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
                if (User_Info_Panel_Dao.update_by_id(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_id(), "phone", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setPhone_number(t.getNewValue());
                // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        Id_card.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
                if (User_Info_Panel_Dao.update_by_id(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_id(), "id_card", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setId_card(t.getNewValue());
                // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        email.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
                if (User_Info_Panel_Dao.update_by_id(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_id(), "email", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setEmail(t.getNewValue());
                // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
                else
                    table.refresh();
            }
        });
        type.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<User_Info, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<User_Info, String> t) {
                if (User_Info_Panel_Dao.update_by_id(
                        t.getTableView().getItems().get(t.getTablePosition().getRow()).getUser_id(), "type", t.getNewValue()))
                    t.getTableView().getItems().get(t.getTablePosition().getRow()).setType(t.getNewValue());
                // User_Info_Panel_Dao.update_data(t.getTableView().getItems().get(t.getTablePosition().getRow()));
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
                User_Info r = new User_Info();
                r.setUser_id(User_Info_Panel_Dao.insert_by_id());
                r.setType("临时");
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
                    User_Info_Panel_Dao.delete_by_id(table.getSelectionModel().getSelectedItem().getUser_id());
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

        // id_label
        Label id_label = new Label("id");
        id_label.relocate(420, 5);

        // id_text
        TextField id_Text = new TextField();
        id_Text.relocate(460, 0);
        id_Text.setPrefWidth(80);

        // name_Label
        Label name_Label = new Label("姓名");
        name_Label.relocate(420, 30);

        // name_text
        TextField name_text = new TextField();
        name_text.relocate(460, 25);
        name_text.setPrefWidth(80);

        //gender_lable
        Label gender_lable = new Label("性别");
        gender_lable.relocate(545, 5);

        //gender_text
        TextField gender_text = new TextField();
        gender_text.relocate(585, 0);
        gender_text.setPrefWidth(200);

        // phone_label
        Label phone_label = new Label("手机号");
        phone_label.relocate(545, 30);

        // phone_text
        TextField phone_text = new TextField();
        phone_text.relocate(585, 25);
        phone_text.setPrefWidth(200);

        // id_card_label
        Label id_card_label = new Label("身份证号");
        id_card_label.relocate(800, 5);

        // id_card_text
        TextField id_card_text = new TextField();
        id_card_text.relocate(850, 0);
        id_card_text.setPrefWidth(200);

        // email_label
        Label email_label = new Label("邮箱");
        email_label.relocate(800, 30);

        // email_text
        TextField email_text = new TextField();
        email_text.relocate(850, 25);
        email_text.setPrefWidth(200);

        //type_label
        Label type_label = new Label("类型:");
        type_label.relocate(1060, 5);

        //type_text
        TextField type_text=new TextField();
        type_text.relocate(1060,25);
        type_text.setPrefWidth(120);
        //清空按钮
        Button clear = new Button("清空");
        clear.relocate(200, 0);
        clear.setPrefSize(100, 50);
        clear.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                id_Text.clear();
                name_text.clear();
                gender_text.clear();
                phone_text.clear();
                id_card_text.clear();
                email_text.clear();
                type_text.clear();
            }
        });

        // 搜索/刷新按钮
        Button search = new Button("搜索/刷新");
        search.relocate(300, 0);
        search.setPrefSize(100, 50);
        search.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                select(id_Text.getText(), name_text.getText(), gender_text.getText(), phone_text.getText(), id_card_text.getText(), email_text.getText(),type_text.getText());
                table.refresh();
            }
        });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(table, add, delete, search, id_label, id_Text,clear, name_Label, name_text,gender_lable,gender_text,phone_label,phone_text,id_card_label,id_card_text,email_label,email_text,type_label,type_text);// 将控件添加到pane中

        stage.setScene(new Scene(pane, 1200, 700));
        stage.setTitle("客户管理面板");
        
        stage.widthProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth,
                    Number newSceneWidth) {
                table.setPrefWidth((double) newSceneWidth-15);
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
