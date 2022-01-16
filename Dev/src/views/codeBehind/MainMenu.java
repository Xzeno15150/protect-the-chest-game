package views.codeBehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import launcher.Launch;
import views.ManagerVue;


public class MainMenu {

    private final ManagerVue managerVue = Launch.getManagerVue();
    @FXML
    public Button playBtn;

    @FXML
    public Button leaveBtn;


    @FXML
    public void onActionPlayButton(ActionEvent actionEvent) {
        managerVue.jouer();
    }

    @FXML
    public void onActionLeaveButton(ActionEvent actionEvent){
        managerVue.quitter(leaveBtn);
    }

    @FXML
    public void initialize() {

    }
}
