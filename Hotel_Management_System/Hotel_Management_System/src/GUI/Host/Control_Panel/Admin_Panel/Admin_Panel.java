package GUI.Host.Control_Panel.Admin_Panel;

import Mysql.Mysql_Obj.Admin_Account;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Mysql.Dao.Admin_Account_Dao;
import Mysql.Implement.Admin_Account_Dao_Impl;

import GUI.Host.Control_Panel.Control_Panel;

public class Admin_Panel extends Application {
    int idx;
    int maxidx;
    Admin_Account_Dao dao;
    Admin_Account Admin_Account = new Admin_Account();

    public void init_APP() {
        dao = new Admin_Account_Dao_Impl();
        maxidx = dao.count();
        idx = 0;
    }

    public void start(Stage stage) {
        init_APP();
        Label id = new Label("编号");
        Label name = new Label("用户名");
        Label password = new Label("密码");

        TextField id_text = new TextField();
        TextField name_text = new TextField();
        PasswordField password_text = new PasswordField();

        id.relocate(50, 50);
        name.relocate(50, 100);
        password.relocate(50, 150);

        id_text.relocate(100, 50);
        name_text.relocate(100, 100);
        password_text.relocate(100, 150);

        id_text.setPrefWidth(300);
        name_text.setPrefWidth(300);
        password_text.setPrefWidth(300);

        id_text.setDisable(true);

        Button first = new Button("第一条");
        Button previous = new Button("上一条");
        Button next = new Button("下一条");
        Button last = new Button("最后一条");
        Button add = new Button("插入");
        Button delete = new Button("删除");
        Button update = new Button("修改");
        Button back = new Button("返回");

        // 绑定事件
        first.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maxidx = dao.count();
                idx = 0;
                Admin_Account = dao.query(idx);
                id_text.setText(String.valueOf(Admin_Account.getId()));
                name_text.setText(Admin_Account.getUsername());
                Admin_Account.setPassword("");
            }
        });

        previous.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maxidx = dao.count();
                if (idx > 0) {
                    idx--;
                    Admin_Account = dao.query(idx);
                    id_text.setText(String.valueOf(Admin_Account.getId()));
                    name_text.setText(Admin_Account.getUsername());
                    Admin_Account.setPassword("");
                }
            }
        });

        next.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maxidx = dao.count();
                if (idx < maxidx - 1) {
                    idx++;
                    Admin_Account = dao.query(idx);
                    id_text.setText(String.valueOf(Admin_Account.getId()));
                    name_text.setText(Admin_Account.getUsername());
                    Admin_Account.setPassword("");
                }
            }
        });

        last.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                maxidx = dao.count();
                idx = maxidx - 1;
                Admin_Account = dao.query(idx);
                id_text.setText(String.valueOf(Admin_Account.getId()));
                name_text.setText(Admin_Account.getUsername());
                Admin_Account.setPassword("");
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Admin_Account.username = name_text.getText();
                Admin_Account.password = password.getText();
                if (dao.insert(Admin_Account)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("数据库操作成功");
                    alert.setHeaderText("数据库操作成功");
                    alert.setContentText("插入成功!");
                    alert.showAndWait();
                    maxidx = dao.count();
                    idx = maxidx - 1;
                }
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (dao.delete(name_text.getText())) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("数据库操作成功");
                    alert.setHeaderText("数据库操作成功");
                    alert.setContentText("删除成功!");
                    alert.showAndWait();
                    maxidx = dao.count();
                    idx %= maxidx;
                    Admin_Account = dao.query(idx);
                    id_text.setText(String.valueOf(Admin_Account.getId()));
                    name_text.setText(Admin_Account.getUsername());
                    Admin_Account.setPassword("");
                }
            }
        });

        update.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Admin_Account.username = name_text.getText();
                Admin_Account.password = password.getText();
                if (dao.update(Admin_Account)) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("数据库操作成功");
                    alert.setHeaderText("数据库操作成功");
                    alert.setContentText("修改成功!");
                    alert.showAndWait();
                }

            }
        });

        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Control_Panel control_panel = new Control_Panel();
                control_panel.start(new Stage());
                stage.close();
            }
        });

        first.relocate(50, 200);
        previous.relocate(150, 200);
        next.relocate(250, 200);
        last.relocate(350, 200);
        add.relocate(50, 250);
        delete.relocate(150, 250);
        update.relocate(250, 250);
        back.relocate(350, 250);


        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(id, name, password, id_text, name_text, password_text, first, previous, next, last, add, delete, update, back);// 将控件添加到pane中
        stage.setScene(new Scene(pane, 450, 300));
        stage.setTitle("管理员账户管理");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
