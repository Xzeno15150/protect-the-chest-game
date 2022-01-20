package views.codeBehind;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import launcher.Launch;
import model.Manager;
import views.ManagerVue;

import java.io.IOException;

/**
 * Code behind du menu principal
 */
public class MainMenu {

    private final ManagerVue managerVue = Launch.getManagerVue();
    private final Manager mgr = Launch.getManager();

    @FXML
    private Button playBtn;
    @FXML
    private Button leaveBtn;
    @FXML
    private Label meilleurScore;


    /**
     * Handler du bouton playBtn
     * Appelle la méthode jouer() de managerVue
     * @throws IOException Relance l'Exception
     */
    @FXML
    public void onActionPlayButton() throws IOException {
        managerVue.jouer();
    }

    /**
     * Handler du bouton leaveBtn
     * Appelle la méthode quitter() de managerVue
     */
    @FXML
    public void onActionLeaveButton(){
        managerVue.quitter(leaveBtn);
    }

    @FXML
    public void initialize() {
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
