package GUI.Guest;

import javafx.application.Application;
import javafx.stage.Stage;
import GUI.Guest.GuestLogin;
import GUI.Host.HostLogin;
import GUI.Selector.OptionSelector;
import Mysql.Mysql_Obj.User_Info;

class PanelSelector extends OptionSelector {
    protected String phone="";

    public PanelSelector(String title, String options1, String options2, Stage stage) {
        super(title, options1, options2, stage);
    }

    public PanelSelector(String title, String options1, String options2, Stage stage,String phone) {
        super(title, options1, options2, stage);
        this.phone=phone;
    }

    @Override
    public void option1Click() {
        HostLogin hostLogin = new HostLogin();
        try {
            new Choose_Room().start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void option2Click() {
        User_Info user_info = new User_Info();
        user_info.setPhone_number(phone);
        Update_Info update_info = new Update_Info(user_info);
        try {
            update_info.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class Guest_Panel extends Application {
    protected String phone="";
    Guest_Panel(){}
    Guest_Panel(String phone){
        this.phone=phone;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        PanelSelector panelSelector = new PanelSelector("客户页面", "预定房间", "更新信息", primaryStage,phone);
        panelSelector.start_selecting();
    }

    public static void main(String[] args) {
        launch(args);
    }
}