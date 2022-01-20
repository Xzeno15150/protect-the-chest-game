package views.codeBehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import launcher.Launch;
import model.Manager;
import views.ManagerVue;

import java.io.IOException;

public class GameOver {
    private final ManagerVue managerVue = Launch.getManagerVue();
    private final Manager mgr = Launch.getManager();

    @FXML
    private Label score;
    @FXML
    private Button buttonQuitter;
    @FXML
    private Label meilleurScore;

    public void onActionRejouer(ActionEvent actionEvent) throws IOException {
        managerVue.jouer();
    }

    public void onActionQuitter(ActionEvent actionEvent){
        managerVue.quitter(buttonQuitter);
    }

    @FXML
    public void initialize(){
        score.textProperty().bindBidirectional(mgr.numMancheProperty(), new StringConverter<>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.getInteger(string);
            }
        });

        meilleurScore.textProperty().bindBidirectional(mgr.bestScoreProperty(), new StringConverter<>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.getInteger(string);
            }
        });
    }
}
