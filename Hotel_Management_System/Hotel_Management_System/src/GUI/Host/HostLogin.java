package GUI.Host;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HostLogin extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Label username = new Label("用户名:");
        label.relocate(100, 100);
        Label password


        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll();// 将按钮添加到pane中
        stage.setScene(new Scene(pane, 450, 250));
        stage.setTitle("店主登录界面");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
        
    }
    
}
