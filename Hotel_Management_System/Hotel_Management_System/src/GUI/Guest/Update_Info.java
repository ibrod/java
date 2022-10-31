package GUI.Guest;

import java.security.AllPermission;

import Mysql.Dao.User_Info_Manage_Dao;
import Mysql.Implement.User_Info_Manage_Dao_Impl;
import Mysql.Mysql_Obj.User_Info;
import Tools.Wake_Up.Wake_Up;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Update_Info extends Application{

    User_Info user_info = new User_Info("", "", "", "", "");
    Wake_Up wake_Up;
  

    public Update_Info(User_Info user_info, Wake_Up wake_Up) {
        this.user_info = user_info;
        this.wake_Up = wake_Up;
    }

    public Update_Info() {
    }

    public void setUser_info(User_Info user_info) {
        this.user_info = user_info;
    }

    public void setWake_Up(Wake_Up wake_Up) {
        this.wake_Up = wake_Up;
    }

    @Override
    public void start(Stage stage) {
        Label phone = new Label("手机号:");
        phone.relocate(50, 30);
        Label name = new Label("姓名:");
        name.relocate(50, 80);
        Label gender = new Label("性别:");
        gender.relocate(50, 230);
        Label id = new Label("身份证号:");
        id.relocate(50, 130);
        Label email = new Label("邮箱:");
        email.relocate(50, 180);

        TextField phone_input = new TextField(user_info.getPhone_number());
        phone_input.relocate(120, 30);
        phone_input.setPrefWidth(300);
        phone_input.setDisable(true);

        TextField name_input = new TextField();
        name_input.relocate(120, 80);
        name_input.setPrefWidth(300);
        TextField id_input = new TextField();
        id_input.relocate(120, 130);
        id_input.setPrefWidth(300);
        //设置最多只能输入18位
        id_input.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 18) {
                id_input.setText(oldValue);
            }
        });

        TextField email_input = new TextField();
        email_input.relocate(120, 180);
        email_input.setPrefWidth(300);

        // 创建ToggleGroup
        final ToggleGroup group = new ToggleGroup();

        // 创建RadioButton
        RadioButton male = new RadioButton("男");
        RadioButton female = new RadioButton("女");

        male.relocate(120, 230);
        female.relocate(220, 230);

        male.setUserData("male");
        female.setUserData("female");

        male.setToggleGroup(group);
        female.setToggleGroup(group);

        male.setSelected(true);

        // 更新信息的按钮
        Button update = new Button("更新信息");
        update.relocate(50, 280);
        update.setPrefWidth(250);

        // 绑定事件
        update.setOnAction(e -> {
            if (name_input.getText().equals("") || id_input.getText().equals("")
                    || email_input.getText().equals("")) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setHeaderText("请填写完整信息");
                alert.setContentText("您填写的信息不完整，请填写完整信息");
                alert.showAndWait();
            } else {
                user_info.setName(name_input.getText());
                user_info.setGender(group.getSelectedToggle().getUserData().toString());
                user_info.setId_card(id_input.getText());
                user_info.setEmail(email_input.getText());
                User_Info_Manage_Dao user_Info_Manage_Dao = new User_Info_Manage_Dao_Impl();
                user_Info_Manage_Dao.update_by_phone(user_info);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("提示");
                alert.setHeaderText("更新成功");
                alert.setContentText("您的信息已更新成功");
                alert.showAndWait();
                stage.close();
                user_info.setStatus(1);
                wake_Up.wake_up();
            }
        });

        // 返回按钮
        Button back = new Button("返回");
        back.relocate(320, 280);
        back.setPrefWidth(100);

        // 绑定事件
        back.setOnAction(e -> {
            stage.close();
            wake_Up.wake_up();
        });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(phone, name, gender, id, email, phone_input, name_input, id_input, email_input,
                male, female, update, back);
        stage.setScene(new Scene(pane, 460, 350));
        stage.setTitle("客户登录界面");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
