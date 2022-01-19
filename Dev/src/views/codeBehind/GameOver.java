package views.codeBehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import launcher.Launch;
import views.ManagerVue;

import java.io.IOException;

public class GameOver {
    private final ManagerVue managerVue = Launch.getManagerVue();

    @FXML
    Button buttonQuitter;

    @FXML
    public void initialize(){

    }

    public void onActionRejouer(ActionEvent actionEvent) throws IOException {
        managerVue.jouer();
    }

    public void onActionQuitter(ActionEvent actionEvent){
        managerVue.quitter(buttonQuitter);
    }
}
