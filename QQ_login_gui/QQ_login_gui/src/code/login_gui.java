package code;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

public class Login_gui extends Application {
    @Override
    public void start(Stage stage) {
        try {
        StackPane root = new StackPane();
        Label label=new Label("This is my first javafx program.");
        label.setStyle("-fx-font-size: 20px; -fx-text-fill: red;");
        label.setTranslateX(-50);
        label.setTranslateY(-50);
        root.setBackground(new Background(arg0));
        Image image=new Image("file:src\\loginFrame\\bk.jpg");
        
        // label.setTranslateZ(50);
        //以上是调整坐标的方法
        label.setText("This label has been changed.");
        // label.setScaleX(0.5);
        // label.setScaleY(0.5);
        // label.setScaleZ(0.5);
        //以上是缩放
        // label.relocate(100, 1);
        Circle circle=new Circle(5,5,5,Color.RED);
        circle.setStroke(Color.BLACK);
        root.getChildren().add(label);
        root.getChildren().add(circle);
        //create a scene
        Scene scene = new Scene(root,450,350);
        stage.setTitle("QQ Gui");
        stage.setScene(scene);
        stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
