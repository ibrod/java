package code;

import java.beans.EventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Login_gui extends Application {
    @Override
    public void start(Stage stage) {
        try {
            //背景图片
            Image image = new Image("E:\\code\\java\\QQ_login_gui\\QQ_login_gui\\src\\resources\\bkg.jpg");
            ImageView background = new ImageView(image);

            //QQ头像
            Image image2 = new Image("E:\\code\\java\\QQ_login_gui\\QQ_login_gui\\src\\resources\\QQ_icon.png");
            ImageView qq_icon = new ImageView(image2);
            qq_icon.relocate(50, 230);

            //QQ号码输入框
            TextField qqnumber = new TextField();
            qqnumber.setPrefSize(240, 29);
            qqnumber.relocate(160, 250);

            //密码输入框
            PasswordField password = new PasswordField();
            password.setPrefSize(240, 29);
            password.relocate(160, 280);

            //记住密码
            CheckBox remember_password = new CheckBox("记住密码");
            remember_password.relocate(160, 315);

            //自动登录
            CheckBox auto_login = new CheckBox("自动登录");
            auto_login.relocate(300, 315);

            //注册账号
            Label register = new Label("注册账号");
            register.relocate(410, 250);
            register.setFont(new javafx.scene.text.Font(15));
            register.setTextFill(Color.web("#0000FF"));

            //找回密码
            Label forget_password = new Label("找回密码");
            forget_password.relocate(410, 285);
            forget_password.setFont(new javafx.scene.text.Font(15));
            forget_password.setTextFill(Color.web("#0000FF"));

            //登录按钮
            Button login = new Button("登录");
            login.relocate(160, 350);
            login.setPrefSize(240, 29);
            login.setStyle("-fx-background-color: #00BFFF; -fx-text-fill: #FFFFFF;");
            login.setFont(new javafx.scene.text.Font(15));
            login.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if(qqnumber.getText().equals("ABC") && password.getText().equals("123456")) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("登录成功");
                        alert.setHeaderText("登录成功");
                        alert.setContentText("登录成功");
                        alert.showAndWait();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("登录失败");
                        alert.setHeaderText("登录失败");
                        alert.setContentText("登录失败,密码错误!");
                        alert.showAndWait();
                    }
                }
            });

            //创建一个Pane
            Pane pane = new Pane();
            pane.getChildren().addAll(qq_icon, qqnumber,password,remember_password,auto_login,register,forget_password,login);
            //创建一个StackPane
            StackPane root = new StackPane();
            root.getChildren().addAll(background,pane);
            //创建一个scene
            Scene scene = new Scene(root, 530, 400);
            //创建一个stage
            stage.setTitle("QQ Gui");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
