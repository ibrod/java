package GUI.Guest;

import GUI.Selector.FX_PanelSelector;
import Tools.Sms_Tool.Sms;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

class CountDown implements Runnable {
    private int count;
    private Text text;
    Button button;

    public CountDown(int count, Text text, Button button) {
        this.count = count;
        this.text = text;
        this.button = button;
        text.setVisible(true);
        // 设置按钮为不可用状态
        button.setText("重新发送");
        button.setVisible(false);
    }

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            text.setText("验证码已发送，" + count + "秒后可重新发送");
        }
        text.setVisible(false);
        button.setVisible(true);
    }

}

public class GuestLogin extends Application {

    String sms_code = null;
    String phone_number;

    @Override
    public void start(Stage stage) {
        Label username = new Label("手机号:");
        username.relocate(50, 30);
        TextField phone = new TextField();
        phone.relocate(100, 30);
        phone.setPrefWidth(300);

        // 验证码
        Label verify_code = new Label("短信验证码:");
        verify_code.relocate(50, 80);
        TextField verify_code_input = new TextField();
        verify_code_input.relocate(120, 80);
        verify_code_input.setPrefSize(100, 25);

        // 点击获取验证码
        Button get_verify_code = new Button("获取验证码");
        get_verify_code.relocate(230, 80);
        get_verify_code.setPrefSize(100, 25);

        // 验证码等待提示: 60s
        Text verify_code_wait = new Text("验证码已发送");
        verify_code_wait.relocate(230, 80);
        verify_code_wait.setVisible(false);
        // 将文字设置为红色
        verify_code_wait.setStyle("-fx-fill: red;");

        // 绑定事件
        get_verify_code.setOnAction(event -> {
            CountDown countDown = new CountDown(60, verify_code_wait, get_verify_code);
            new Thread(countDown).start();
            phone_number = phone.getText();
            sms_code = Sms.send_sms(phone_number);
        });

        // 登录按钮
        Button login = new Button("登录/注册");
        login.relocate(50, 120);
        login.setPrefWidth(250);
        login.setOnAction(event -> {
            if (verify_code_input.getText().equals("1316489465")) {// 仅用于测试
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("成功");
                alert.setHeaderText("登录成功");
                alert.showAndWait();
            } else if (sms_code == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("请先获取验证码");
                alert.showAndWait();
            } else if (!sms_code.equals(verify_code_input.getText()) || !phone_number.equals(phone.getText())) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("错误");
                alert.setHeaderText("验证码错误");
                alert.setContentText("输入的验证码与向对应号码发送的验证码不匹配");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("成功");
                alert.setHeaderText("登录成功");
                alert.showAndWait();
            }
        });

        // 返回按钮
        Button back = new Button("返回");
        back.relocate(320, 120);
        back.setPrefWidth(80);
        back.setOnAction(event -> {
            FX_PanelSelector panelSelector = new FX_PanelSelector();
            try {
                panelSelector.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            stage.close();
        });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(username, phone, verify_code, verify_code_input, login, get_verify_code,
                verify_code_wait, back);// 将控件添加到pane中
        stage.setScene(new Scene(pane, 450, 170));
        stage.setTitle("客户登录界面");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
