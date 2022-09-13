package code;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
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
            ImageView imageView = new ImageView(image);

            //QQ头像
            Image image2 = new Image("E:\\code\\java\\QQ_login_gui\\QQ_login_gui\\src\\resources\\QQ_icon.png");
            ImageView imageView2 = new ImageView(image2);
            imageView2.relocate(50, 230);

            //QQ号码输入框
            TextField textField = new TextField();
            textField.setPrefSize(240, 29);
            textField.relocate(160, 250);

            //密码输入框
            PasswordField passwordField = new PasswordField();
            passwordField.setPrefSize(240, 29);
            passwordField.relocate(160, 280);

            //记住密码
            CheckBox checkBox = new CheckBox("记住密码");
            checkBox.relocate(160, 315);

            //自动登录
            CheckBox checkBox2 = new CheckBox("自动登录");
            checkBox2.relocate(300, 315);

            //注册账号
            Label label = new Label("注册账号");
            label.relocate(410, 250);
            label.setFont(new javafx.scene.text.Font(15));
            label.setTextFill(Color.web("#0000FF"));

            //找回密码
            Label label2 = new Label("找回密码");
            label2.relocate(410, 285);
            label2.setFont(new javafx.scene.text.Font(15));
            label2.setTextFill(Color.web("#0000FF"));

            //登录按钮
            Button button = new Button("登录");
            button.relocate(160, 350);
            button.setPrefSize(240, 29);
            button.setStyle("-fx-background-color: #00BFFF; -fx-text-fill: #FFFFFF;");
            button.setFont(new javafx.scene.text.Font(15));

            //创建一个Pane
            Pane pane = new Pane();
            pane.getChildren().addAll(imageView2, textField,passwordField,checkBox,checkBox2,label,label2,button);
            //创建一个StackPane
            StackPane root = new StackPane();
            root.getChildren().addAll(imageView,pane);
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
