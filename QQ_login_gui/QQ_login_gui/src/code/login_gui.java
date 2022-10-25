package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javafx.application.Application;
import javafx.application.Platform;
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

interface Mysql_controler_DAO {
    public int connect(String username, String password);
}



class QQLOGIN_DAO_IMPL implements Mysql_controler_DAO {
    String url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/qqdb?useSSL=false";
    String user = "java_lab";
    String password2 = "Hnist_jk20_2bj";

    @Override
    public int connect(String username, String password) {
        try { // 1.注册驱动
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");// 新版本的加载方式
            } catch (ClassNotFoundException e) {
                Class.forName("com.mysql.jdbc.Driver");// 旧版本的加载方式
            }
        } catch (Exception ee) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库连接失败");
            alert.setHeaderText("数据库连接失败");
            alert.setContentText("本数据库使用的是远端数据库，请检查你的互联网连接是否成功!");
            alert.showAndWait();
            return -1;
        }
        try {
            // 2.获取连接
            Connection conn = DriverManager.getConnection(url, user, password2);
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from users where username=? and password=?");
            pstm.setString(1, username);
            pstm.setString(2, password);
            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            if (rs.next()) {
                return 1;
            }
            // 6.释放资源
            if (rs != null) {
                rs.close();
            }
            return 0;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
            return -1;
        }
    }
}

public class Login_gui extends Application {
    @Override
    public void start(Stage stage) {
        try {
            // 背景图片
            Image image = new Image("E:\\code\\java\\QQ_login_gui\\QQ_login_gui\\src\\resources\\bkg.jpg");
            ImageView background = new ImageView(image);

            // QQ头像
            Image image2 = new Image("E:\\code\\java\\QQ_login_gui\\QQ_login_gui\\src\\resources\\QQ_icon.png");
            ImageView qq_icon = new ImageView(image2);
            qq_icon.relocate(50, 230);

            // QQ号码输入框
            TextField qqnumber = new TextField();
            qqnumber.setPrefSize(240, 29);
            qqnumber.relocate(160, 250);

            // 密码输入框
            PasswordField password = new PasswordField();
            password.setPrefSize(240, 29);
            password.relocate(160, 280);

            // 记住密码
            CheckBox remember_password = new CheckBox("记住密码");
            remember_password.relocate(160, 315);

            // 自动登录
            CheckBox auto_login = new CheckBox("自动登录");
            auto_login.relocate(300, 315);

            // 注册账号
            Label register = new Label("注册账号");
            register.relocate(410, 250);
            register.setFont(new javafx.scene.text.Font(15));
            register.setTextFill(Color.web("#0000FF"));

            // 找回密码
            Label forget_password = new Label("找回密码");
            forget_password.relocate(410, 285);
            forget_password.setFont(new javafx.scene.text.Font(15));
            forget_password.setTextFill(Color.web("#0000FF"));

            // 登录按钮
            Button login = new Button("登录");
            login.relocate(160, 350);
            login.setPrefSize(240, 29);
            login.setStyle("-fx-background-color: #00BFFF; -fx-text-fill: #FFFFFF;");
            login.setFont(new javafx.scene.text.Font(15));
            login.setOnAction(new javafx.event.EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Mysql_controler_DAO dao = new QQLOGIN_DAO_IMPL();
                    int val = dao.connect(qqnumber.getText(), password.getText());
                    if (val == 1) {
                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("登录成功");
                        alert.setHeaderText("登录成功");
                        alert.setContentText("登录成功");
                        alert.showAndWait();
                        App app = new App();
                        try {
                            app.init();
                            app.start(new Stage());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (val == 0) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("登录失败");
                        alert.setHeaderText("登录失败");
                        alert.setContentText("登录失败,密码错误!");
                        alert.showAndWait();
                    }
                }
            });

            // 创建一个Pane
            Pane pane = new Pane();
            pane.getChildren().addAll(qq_icon, qqnumber, password, remember_password, auto_login, register,
                    forget_password, login);
            // 创建一个StackPane
            StackPane root = new StackPane();
            root.getChildren().addAll(background, pane);
            // 创建一个scene
            Scene scene = new Scene(root, 530, 400);
            // 创建一个stage
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
