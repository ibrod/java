package UDP_Chat;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    public void start(Stage stage) {
        //Java聊天室APP
        

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll();// 将控件加入pane

        stage.setScene(new Scene(pane, 400, 240));
        stage.setTitle("实验七 计科20-2BJ 向杰");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();

    }   
    public static void main(String[] args) {
        launch(args);
    }
}
