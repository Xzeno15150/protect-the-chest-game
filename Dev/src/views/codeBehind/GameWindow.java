package views.codeBehind;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
import model.Manager;
import model.metier.Entite;


public class GameWindow {

    private final Manager mgr = Launch.getManager();
    @FXML
    private Pane mainPane;
    @FXML
    private Rectangle coffreVue;
    @FXML
    private Rectangle personnageVue;
    @FXML
    private Label nbVie;

    @FXML
    public void initialize(){
        mgr.getMonde().hauteurProperty().bind(mainPane.heightProperty());
        mgr.getMonde().largeurProperty().bind(mainPane.widthProperty());

        createBinding(coffreVue, mgr.getMonde().getCoffre());
        createBinding(personnageVue, mgr.getMonde().getPersonnagePrincipal());
        // TODO Bind nbVie sur le nbVie de manager
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

    public void removeNode(Node n) {
        mainPane.getChildren().remove(n);
    }

    public void addNode(Node n) {
        mainPane.getChildren().add(n);
    }

}
