import java.math.BigDecimal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    public void calc(int mode,TextField input1,TextField input2,TextField output) {//运算函数
        if (mode == 0) {
            try {
                BigDecimal b1 = new BigDecimal(input1.getText());
                BigDecimal b2 = new BigDecimal(input2.getText());
                BigDecimal b3 = b1.divide(b2,8,BigDecimal.ROUND_HALF_UP);
                output.setText(b3.toString());
            } catch (Exception e) {
                output.setText("Error");
            }
        } else if (mode == 1) {
            try {
                BigDecimal b1 = new BigDecimal(input1.getText());
                BigDecimal b2 = new BigDecimal(input2.getText());
                BigDecimal b3 = b1.multiply(b2);
                output.setText(b3.toString());
            } catch (Exception e) {
                output.setText("Error");
            }
        } else if (mode == 2) {
            try {
                BigDecimal b1 = new BigDecimal(input1.getText());
                BigDecimal b2 = new BigDecimal(input2.getText());
                BigDecimal b3 = b1.add(b2);
                output.setText(b3.toString());
            } catch (Exception e) {
                output.setText("Error");
            }
        } else if (mode == 3) {
            try {
                BigDecimal b1 = new BigDecimal(input1.getText());
                BigDecimal b2 = new BigDecimal(input2.getText());
                BigDecimal b3 = b1.subtract(b2);
                output.setText(b3.toString());
            } catch (Exception e) {
                output.setText("Error");
            }
        }
    }

    public void start(Stage stage) {
        // calculator
        Label label1 = new Label("数1");
        label1.relocate(20, 30);
        TextField num1 = new TextField();
        num1.setPrefSize(620, 20);
        num1.relocate(50, 30);
        Label label2 = new Label("数2");
        label2.relocate(20, 60);
        TextField num2 = new TextField();
        num2.setPrefSize(620, 20);
        num2.relocate(50, 60);
        Label label3 = new Label("结果");
        label3.relocate(20, 90);
        TextField result = new TextField();
        result.setPrefSize(620, 20);
        result.relocate(50, 90);
        result.setEditable(false);
        Button button1 = new Button("加");
        button1.relocate(50, 120);
        Button button2 = new Button("减");
        button2.relocate(100, 120);
        Button button3 = new Button("乘");
        button3.relocate(150, 120);
        Button button4 = new Button("除");
        button4.relocate(200, 120);
        
        //Tip
        Label tip=new Label("Tip:该计算器支持大数运算");
        tip.relocate(250, 125);
        tip.setStyle("-fx-text-fill: #ff0000");


        //处理button事件
        button1.setOnAction(e -> {
            calc(2,num1,num2,result);
        });
        button2.setOnAction(e -> {
            calc(3,num1,num2,result);
        });
        button3.setOnAction(e -> {
            calc(1,num1,num2,result);
        });
        button4.setOnAction(e -> {
            calc(0,num1,num2,result);
        });
        
        

        Pane pane = new Pane();// 新建pane
        // 将控件加入pane
        pane.getChildren().addAll(label1, num1, label2, num2, label3, result, button1, button2, button3, button4,tip);
        stage.setScene(new Scene(pane, 700, 170));
        stage.setTitle("作业一 图形界面编程及事件处理(计算器)(支持大数运算版) 计科20-2BJ 向杰");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}
