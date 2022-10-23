package code;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

interface Mysql_controler_DAO2 {
    public boolean read_data(Vector<Food> arr_food);
}

class APP_DAO_IMPL implements Mysql_controler_DAO2 {
    String url = "jdbc:mysql://xiangjie.mysql.rds.aliyuncs.com:3306/restaurant?useSSL=false";
    String user = "java_lab";
    String password2 = "Hnist_jk20_2bj";
    Connection conn;
    @Override
    public boolean read_data(Vector<Food> arr_food) {
        // 1.注册驱动
        try {
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
            return false;
        }
        try {
            // 2.获取连接
            conn = DriverManager.getConnection(url, user, password2);
            // 3.获取操作数据库的预处理对象
            PreparedStatement pstm = conn.prepareStatement("select * from menu");
            // 4.执行SQL语句
            ResultSet rs = pstm.executeQuery();
            // 5.遍历结果集
            while (rs.next()) {
                Food food = new Food(rs.getInt("id"), rs.getString("name"), rs.getFloat("price"));
                arr_food.add(food);
            }
            // 6.释放资源
            if (rs != null) {
                rs.close();
            }
            return true;
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("数据库操作失败");
            alert.setHeaderText("数据库操作失败");
            alert.setContentText("请检查互联网连接是否正常，或者数据输入是否合法!");
            alert.showAndWait();
            return false;
         } }
}

public class App extends Application {

    ObservableList<String> ob = FXCollections.observableArrayList();// 列表FXCollections
    ObservableList<Food> ob2 = FXCollections.observableArrayList();// 表格FXCollections

    public void init() {// 重写init方法，用于初始化数据
        try {
            APP_DAO_IMPL app_dao_impl = new APP_DAO_IMPL();
            Vector<Food> arr_food = new Vector<Food>();
            if (app_dao_impl.read_data(arr_food)) {
                for (int i = 0; i < arr_food.size(); i++) {
                    ob2.add(arr_food.get(i));
                    ob.add(arr_food.get(i).getName() + "  " + String.valueOf(arr_food.get(i).getPrice()) + "元");
                }
            }
        } catch (Exception e) {
            throw (e);
        }
    }

    public void start(Stage stage) {
        // 显示文本“欢迎使用本系统”，通过该文本的交替显示和消失，实现闪烁动画效果,并滚动
        Label welcome = new Label("欢迎使用本系统");
        welcome.relocate(150, 5);
        welcome.setStyle("-fx-font-size: 15px; -fx-text-fill: red;");

        // 创建一个过渡对象
        FadeTransition ft = new FadeTransition(Duration.millis(500), welcome);
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(Animation.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        // 创建移动路径
        PathTransition pt = new PathTransition(Duration.millis(2000), new Line(-30, 5, 150, 5), welcome);
        pt.setCycleCount(Animation.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        // 底部文字显示
        Label label = new Label("已选菜品:");
        label.relocate(80, 220);
        // 列表视图
        ListView<String> list = new ListView<String>();
        list.setPrefSize(400, 190);
        list.relocate(0, 50);
        list.setItems(ob);
        list.getSelectionModel().selectedItemProperty()
                .addListener((ChangeListener<? super String>) new ChangeListener<String>() {
                    @Override
                    public void changed(ObservableValue<? extends String> arg0, String old_str, String new_str) {
                        // getSelectedIndex方法可获得选中项的序号，getSelectedItem方法可获得选中项的对象
                        String desc = String.format("您点了第%d项，快餐名称是%s",
                                list.getSelectionModel().getSelectedIndex(),
                                list.getSelectionModel().getSelectedItem().toString());
                        label.setText(desc); // 在标签上显示当前选中的文本项
                    }
                });

        // 表格视图
        TableView<Food> table = new TableView<Food>();
        table.setPrefSize(400, 190);
        table.relocate(0, 50);

        // 表头
        TableColumn<Food, String> column1 = new TableColumn<Food, String>("序号");
        column1.setCellValueFactory(new PropertyValueFactory<Food, String>("order"));
        TableColumn<Food, String> column2 = new TableColumn<Food, String>("菜名");
        column2.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        TableColumn<Food, String> column3 = new TableColumn<Food, String>("价格");
        column3.setCellValueFactory(new PropertyValueFactory<Food, String>("price"));
        table.getColumns().addAll(column1, column2, column3);// 绑定表头
        table.setItems(ob2);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);// 自适应列宽

        column1.setVisible(false);
        column2.setVisible(false);
        column3.setVisible(false);
        table.setVisible(false);
        list.setVisible(true);

        // The button of showing list
        Button show_listButton = new Button("显示列表");
        show_listButton.relocate(100, 20);
        show_listButton.setPrefSize(100, 30);
        show_listButton.setOnAction(e -> {// 写事件
            column1.setVisible(false);
            column2.setVisible(false);
            column3.setVisible(false);
            table.setVisible(false);
            list.setVisible(true);
            label.setVisible(true);
        });
        // The button of showing table
        Button show_tableButton = new Button("显示表格");
        show_tableButton.relocate(200, 20);
        show_tableButton.setPrefSize(100, 30);
        show_tableButton.setOnAction(e -> {// 写事件
            column1.setVisible(true);
            column2.setVisible(true);
            column3.setVisible(true);
            table.setVisible(true);
            list.setVisible(false);
            label.setVisible(false);
        });

        Pane pane = new Pane();// 新建pane
        pane.getChildren().addAll(show_listButton, show_tableButton, list, table, label, welcome);// 将控件加入pane

        stage.setScene(new Scene(pane, 400, 240));
        stage.setTitle("实验二 计科20-2BJ 向杰");
        stage.resizableProperty().setValue(Boolean.FALSE);// 禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
