package GUI.Selector;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public abstract class OptionSelector {
        String options1;
        String options2;
        String title;
        Stage stage;

        public OptionSelector(String title, String options1, String options2, Stage stage) {
                this.title = title;
                this.options1 = options1;
                this.options2 = options2;
                this.stage=stage;
        }

        // 选项1点击事件
        public abstract void option1Click();

        // 选项2点击事件
        public abstract void option2Click();

        public void start_selecting() {
                Button btn_host = new Button(options1);
                btn_host.relocate(50, 50);
                btn_host.setPrefSize(150, 150);
                btn_host.setOnAction(e -> {
                        option1Click();
                });
                // 设置字体大小和阴影
                btn_host.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ffffff; -fx-background-color: #0066ff; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
                // 设置鼠标悬停时的样式,出现边框
                btn_host.setOnMouseEntered(event -> btn_host.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ff0000; -fx-background-color: #99ccff; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 5, 0, 10, 10); -fx-border-color: #000000; -fx-border-width: 2px;"));
                // 设置鼠标离开时的样式,去除边框
                btn_host.setOnMouseExited(event -> btn_host.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ffffff; -fx-background-color: #0066ff; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"));
                // 设置鼠标点击动画
                btn_host.setOnMousePressed(event -> btn_host.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ffffff; -fx-background-color: #ff0000; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); -fx-translate-y: 2px;"));

                Button btn_guest = new Button(options2);
                btn_guest.relocate(250, 50);
                btn_guest.setPrefSize(150, 150);
                btn_guest.setOnMouseClicked(event -> {
                        option2Click();
                });
                // 设置字体大小和阴影
                btn_guest.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ffffff; -fx-background-color: #0066ff; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);");
                // 设置鼠标悬停时的样式,出现边框
                btn_guest.setOnMouseEntered(event -> btn_guest.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ff0000; -fx-background-color: #99ccff; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 5, 0, 10, 10); -fx-border-color: #000000; -fx-border-width: 2px;"));
                // 设置鼠标离开时的样式,去除边框
                btn_guest.setOnMouseExited(event -> btn_guest.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ffffff; -fx-background-color: #0066ff; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);"));
                // 设置鼠标点击动画
                btn_guest.setOnMousePressed(event -> btn_guest.setStyle(
                                "-fx-font-size: 20px; -fx-text-fill: #ffffff; -fx-background-color: #ff0000; -fx-background-radius: 10px; -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0); -fx-translate-y: 2px;"));

                Pane pane = new Pane();// 新建pane
                pane.getChildren().addAll(btn_host, btn_guest);// 将按钮添加到pane中

                stage.setScene(new Scene(pane, 450, 250));
                stage.setTitle(title);
                stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
                stage.show();
        }
}
