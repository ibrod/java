package GUI.Selector;
import javafx.application.Application;
import javafx.stage.Stage;
import GUI.Guest.GuestLogin;
import GUI.Host.HostLogin;

class PanelSelector extends OptionSelector {
    public PanelSelector(String title, String options1, String options2,Stage stage) {
        super(title, options1, options2,stage);
    }
    @Override
    public void option1Click() {
        HostLogin hostLogin = new HostLogin();
        try {
            hostLogin.start(new Stage());
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public void option2Click() {
        GuestLogin guestLogin=new GuestLogin();
        try {
            guestLogin.start(new Stage());
            stage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class FX_PanelSelector extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        PanelSelector panelSelector = new PanelSelector("身份选择", "我是店家", "我是客户",primaryStage);
        panelSelector.start_selecting();
    }

    public static void main(String[] args) {
        launch(args);
    }
}