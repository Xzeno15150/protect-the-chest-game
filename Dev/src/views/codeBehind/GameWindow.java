package views.codeBehind;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.StringConverter;
import launcher.Launch;
import model.Manager;
import model.metier.Entite;

/**
 * Code behind de la vue du jeu
 */
public class GameWindow {

    private final Manager mgr = Launch.getManager();

    @FXML
    private Pane mainPane;
    @FXML
    private Rectangle coffreVue;
    @FXML
    private Rectangle personnageVue;
    @FXML
    private Rectangle obstacle;
    @FXML
    private Rectangle obstacle2;
    @FXML
    private Rectangle obstacle3;
    @FXML
    private Label nbVie;
    @FXML
    private Label nbMort;
    @FXML
    private ImageView imageNbMort;

    /**
     * Factorise le binding des rectangles avec le modèle
     * @param rectangle Rectangle afficher sur la vue
     * @param entite Entite du modèle sur laquelle se bind
     */
    public void createBinding(Rectangle rectangle, Entite entite) {
        rectangle.xProperty().bind(entite.xProperty());
        rectangle.yProperty().bind(entite.yProperty());
        rectangle.heightProperty().bind(entite.hauteurProperty());
        rectangle.widthProperty().bind(entite.largeurProperty());
    }

    /**
     * Retire une Node n à la vue
     * @param n Node à retirer à la vue
     */
    public void removeNode(Node n) {
        mainPane.getChildren().remove(n);
    }

    /**
     * Ajouter une Node n à la vue
     * @param n Node à ajouter
     */
    public void addNode(Node n) {
        mainPane.getChildren().add(n);
    }

    @FXML
    public void initialize() {
        mgr.getMonde().hauteurProperty().bind(mainPane.heightProperty());
        mgr.getMonde().largeurProperty().bind(mainPane.widthProperty());

        createBinding(coffreVue, mgr.getMonde().getCoffre());
        createBinding(personnageVue, mgr.getMonde().getPersonnagePrincipal());
        createBinding(obstacle, mgr.getMonde().getLesEntites().get(2));
        createBinding(obstacle2, mgr.getMonde().getLesEntites().get(3));
        createBinding(obstacle3, mgr.getMonde().getLesEntites().get(4));

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
