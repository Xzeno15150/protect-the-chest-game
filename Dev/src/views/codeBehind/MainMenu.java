package views.codeBehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launcher.Launch;
import views.ManagerVue;


public class MainMenu {

    private ManagerVue managerVue = Launch.getManagerVue();
    @FXML
    public Button playBtn;


    @FXML
    public void onActionPlayButton(ActionEvent actionEvent) {
        managerVue.jouer();
    }

    @FXML
    public void initialize() {

    }
}
