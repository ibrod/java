package GUI.Host;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Tools.Graphical_CAPTCHA.Get_Picture;

public class HostLogin extends Application {
    String verify_code_pic_path;
    String verify_code_text;

    public void refresh_verify_code() {
        // 获取图片验证码
        StringBuffer verify_code_pic_path_buffer = new StringBuffer();
        StringBuffer verify_code_text_buffer = new StringBuffer();// 必须先new出来,在方法内修改才能在外面使用，方法内不能new，因为地址是值传递，只有地址指向的对象才是引用传递
        Get_Picture.get(verify_code_pic_path_buffer, verify_code_text_buffer);
        verify_code_pic_path = verify_code_pic_path_buffer.toString();
        verify_code_text = verify_code_text_buffer.toString();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Label username = new Label("用户名:");
        username.relocate(50, 30);
        Label password = new Label("密码:");
        password.relocate(50, 80);

        TextField username_input = new TextField();
        username_input.relocate(100, 30);
        username_input.setPrefWidth(300);

        // 密码输入框
        PasswordField password_input = new PasswordField();
        password_input.relocate(100, 80);
        password_input.setPrefWidth(300);

        // 验证码
        Label verify_code = new Label("验证码:");
        verify_code.relocate(50, 130);
        TextField verify_code_input = new TextField();
        verify_code_input.relocate(100, 130);

        refresh_verify_code();

        // 图片控件
        ImageView imageView = new ImageView(new Image(verify_code_pic_path));
        imageView.relocate(280, 130);
        imageView.setFitWidth(100);
        imageView.setFitHeight(25);

        // 点击图片刷新验证码
        imageView.setOnMouseClicked(event -> {
            refresh_verify_code();
            imageView.setImage(new Image(verify_code_pic_path));
        });

        // 登录按钮
        Button login = new Button("登录");
        login.relocate(100, 180);
        login.setPrefWidth(300);
        login.setOnAction(event -> {
            if (verify_code_input.getText().equals(verify_code_text)) {
                // 图片验证码正确

            } else {
                // 图片验证码错误
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("图片验证码错误");
                alert.setContentText("请重新输入");
                alert.showAndWait();
            }
        });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(username, password, username_input, password_input, verify_code, verify_code_input,
                imageView, login);// 将控件添加到pane中
        stage.setScene(new Scene(pane, 460, 220));
        stage.setTitle("店家登录界面");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
