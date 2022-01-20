package views.codeBehind;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import javafx.util.converter.BooleanStringConverter;
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
    private Label nbMort;
    @FXML
    private ImageView imageNbMort;

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

    @FXML
    public void initialize() {
        mgr.getMonde().hauteurProperty().bind(mainPane.heightProperty());
        mgr.getMonde().largeurProperty().bind(mainPane.widthProperty());

        createBinding(coffreVue, mgr.getMonde().getCoffre());
        createBinding(personnageVue, mgr.getMonde().getPersonnagePrincipal());

        nbVie.textProperty().bindBidirectional(mgr.nbVieProperty(), new StringConverter<>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.getInteger(string);
            }
        });
        nbMort.textProperty().bindBidirectional(mgr.numMancheProperty(), new StringConverter<>() {
            @Override
            public String toString(Number object) {
                return String.valueOf(object);
            }

            @Override
            public Number fromString(String string) {
                return Integer.getInteger(string);
            }
        });

        mainPane.widthProperty().addListener((observable, oldValue, newValue) -> {
            nbMort.setLayoutX(newValue.doubleValue() - 50);
            imageNbMort.setLayoutX(newValue.doubleValue() - 105);
        });

    }
}
