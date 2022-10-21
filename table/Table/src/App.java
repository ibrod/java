import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {

    public static class Food {//创建Food类, 为后面绑定表格表头做好工作
        private IntegerProperty order;//序号
        private StringProperty name;//菜名
        private IntegerProperty price;//价格

        public Food(int order, String name, int price) {//写构造
            this.order = new SimpleIntegerProperty(order);
            this.name = new SimpleStringProperty(name);
            this.price = new SimpleIntegerProperty(price);
        }

        public Food() {
            this.order = new SimpleIntegerProperty();
            this.name = new SimpleStringProperty();
            this.price = new SimpleIntegerProperty();
        }// 保留默认构造

        public int getOrder() {
            return order.get();
        }

        public String getName() {
            return name.get();
        }

        public int getPrice() {
            return price.get();
        }

    }

    ObservableList<String> ob = FXCollections.observableArrayList();//列表FXCollections
    ObservableList<Food> ob2 = FXCollections.observableArrayList();//表格FXCollections

    public void init() {// 重写Application的init方法,初始化数据
        try {
            ob.add("鱼香肉丝饭 16元");
            ob.add("香菇滑鸡饭 18元");
            ob.add("黑椒牛排饭 20元");
            ob.add("梅菜扣肉饭 17元");
            ob.add("糖醋里脊饭 19元");
            ob.add("红烧排骨饭 17元");
            ob.add("台式卤肉饭 15元");
            ob2.add(new Food(1, "鱼香肉丝饭", 16));
            ob2.add(new Food(2, "香菇滑鸡饭", 18));
            ob2.add(new Food(3, "黑椒牛排饭", 20));
            ob2.add(new Food(4, "梅菜扣肉饭", 17));
            ob2.add(new Food(5, "糖醋里脊饭", 19));
            ob2.add(new Food(6, "红烧排骨饭", 17));
            ob2.add(new Food(7, "台式卤肉饭", 15));
        } catch (Exception e) {
            throw (e);
        }
    }

    public void start(Stage stage) {
        //列表视图
        ListView<String> list = new ListView<String>();
        list.setPrefSize(400, 170);
        list.relocate(0, 30);
        list.setItems(ob);

        //表格视图
        TableView<Food> table = new TableView<Food>();
        table.setPrefSize(400, 170);
        table.relocate(0, 30);

        //表头
        TableColumn<Food, String> column1 = new TableColumn<Food, String>("序号");
        column1.setCellValueFactory(new PropertyValueFactory<Food, String>("order"));
        TableColumn<Food, String> column2 = new TableColumn<Food, String>("菜名");
        column2.setCellValueFactory(new PropertyValueFactory<Food, String>("name"));
        TableColumn<Food, String> column3 = new TableColumn<Food, String>("价格");
        column3.setCellValueFactory(new PropertyValueFactory<Food, String>("price"));
        table.getColumns().addAll(column1, column2, column3);//绑定表头
        table.setItems(ob2);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);//自适应列宽

        column1.setVisible(false);
        column2.setVisible(false);
        column3.setVisible(false);
        table.setVisible(false);
        list.setVisible(true);

        // The button of showing list
        Button show_listButton = new Button("显示列表");
        show_listButton.relocate(100, 0);
        show_listButton.setPrefSize(100, 30);
        show_listButton.setOnAction(e -> {//写事件
            column1.setVisible(false);
            column2.setVisible(false);
            column3.setVisible(false);
            table.setVisible(false);
            list.setVisible(true);
        });
        // The button of showing table
        Button show_tableButton = new Button("显示表格");
        show_tableButton.relocate(200, 0);
        show_tableButton.setPrefSize(100, 30);
        show_tableButton.setOnAction(e -> {//写事件
            column1.setVisible(true);
            column2.setVisible(true);
            column3.setVisible(true);
            table.setVisible(true);
            list.setVisible(false);
        });

        Pane pane = new Pane();//新建pane
        pane.getChildren().addAll(show_listButton, show_tableButton, list, table);//将控件加入pane

        stage.setScene(new Scene(pane, 400, 200));
        stage.setTitle("实验二 计科20-2BJ 向杰");
        stage.resizableProperty().setValue(Boolean.FALSE);//禁用最大化按钮
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch();
    }
}

