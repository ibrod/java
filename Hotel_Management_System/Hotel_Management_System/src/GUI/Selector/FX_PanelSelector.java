package GUI.Selector;
import javafx.application.Application;
import javafx.stage.Stage;


class PanelSelector extends OptionSelector {
    public PanelSelector(String title, String options1, String options2) {
        super(title, options1, options2);
    }
    @Override
    public void option1Click() {
        System.out.println("Option 1 Clicked");
    }
    @Override
    public void option2Click() {
        System.out.println("2");
    }
}


public class FX_PanelSelector extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PanelSelector panelSelector = new PanelSelector("酒店管理系统", "我是店家", "我是客户");
        panelSelector.start_selecting(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}