package views.codeBehind;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
import model.Manager;
import model.metier.Entite;

public class GameWindow {

    private final Manager mgr = Launch.getManager();
    @FXML
    public Pane mainPane;
    @FXML
    public Rectangle coffreVue;
    @FXML
    public Rectangle personnageVue;
    @FXML
    public Rectangle ennemie;

    @FXML
    public void initialize(){
        mgr.getMonde().hauteurProperty().bind(mainPane.heightProperty());
        mgr.getMonde().largeurProperty().bind(mainPane.widthProperty());

        createBinding(coffreVue, mgr.getMonde().getCoffre());
        createBinding(personnageVue, mgr.getMonde().getPersonnagePrincipal());
        createBinding(ennemie, mgr.getMonde().getLesEntites().get(2));
    }

    public void createBinding(Rectangle rectangle, Entite e) {
        rectangle.xProperty().bind(e.xProperty());
        rectangle.yProperty().bind(e.yProperty());
        rectangle.heightProperty().bind(e.hauteurProperty());
        rectangle.widthProperty().bind(e.largeurProperty());
    }

    public Pane getMainPane() {
        return mainPane;
    }

}