package views;

import controllers.Manager;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import launch.Launcher;
import modele.collisions.Hitbox;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.personnages.Personnage;
import modele.personnages.PersonnagePrincipal;

public class MainWindow{

    // Attributes
    private Manager mgr = Launcher.getManager();

    AnimationTimer mouvementTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            // Attibutes
            if (zPressed.get()){
                //rectangleTest.setLayoutY(rectangleTest.getLayoutY() + mouvement);
                mgr.deplacerPersonnage(personnagePrincipale, 0);
            }
            if (sPressed.get()){
                //rectangleTest.setLayoutY(rectangleTest.getLayoutY() + mouvement);
                mgr.deplacerPersonnage(personnagePrincipale, 1);
            }
            if (qPressed.get()){
                //rectangleTest.setLayoutX(rectangleTest.getLayoutX() - mouvement);
                mgr.deplacerPersonnage(personnagePrincipale, 2);
            }
            if (dPressed.get()) {
                //rectangleTest.setLayoutX(rectangleTest.getLayoutX() + mouvement);
                mgr.deplacerPersonnage(personnagePrincipale, 3);
            }
        }
    };

    private Personnage personnagePrincipale;

    // Property
    private BooleanProperty zPressed = new SimpleBooleanProperty();
    private BooleanProperty sPressed = new SimpleBooleanProperty();
    private BooleanProperty dPressed = new SimpleBooleanProperty();
    private BooleanProperty qPressed = new SimpleBooleanProperty();

    private BooleanBinding keyPressed = zPressed.or(sPressed).or(dPressed).or(qPressed);

    // FXML attributes
    @FXML
    public Rectangle rectangleTest;
    @FXML
    public Label labelTest;
    @FXML
    public AnchorPane mainPane;

    @FXML
    public void handleClickBtn(ActionEvent actionEvent) {
        personnagePrincipale.getHitbox().setPosX(130);
        personnagePrincipale.getHitbox().setPosY(100);
    }


    private void creerMouvement() {
        mainPane.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
            if (event.getCode() == KeyCode.Z) {
                zPressed.set(true);
            }
            if (event.getCode() == KeyCode.S){
                sPressed.set(true);
            }
            if (event.getCode() == KeyCode.Q){
                qPressed.set(true);
            }
            if (event.getCode() == KeyCode.D){
                dPressed.set(true);
            }
        });

        mainPane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.Z) {
                zPressed.set(false);
            }
            if (event.getCode() == KeyCode.S){
                sPressed.set(false);
            }
            if (event.getCode() == KeyCode.Q){
                qPressed.set(false);
            }
            if (event.getCode() == KeyCode.D){
                dPressed.set(false);
            }
        });
    }

    @FXML
    public void initialize() {
        creerMouvement();

        keyPressed.addListener(((observable, oldValue, newValue) -> {
            if (!oldValue) {
                mouvementTimer.start();
            }
            else {
                mouvementTimer.stop();
            }
        }));

        personnagePrincipale = new PersonnagePrincipal("", 20, new Hitbox(50, 200, 150));
        //personnagePrincipale.getHitbox().posXProperty().bind(rectangleTest.layoutXProperty());
        //personnagePrincipale.getHitbox().posYProperty().bind(rectangleTest.layoutYProperty());
        rectangleTest.xProperty().bind(personnagePrincipale.getHitbox().posXProperty());
        rectangleTest.xProperty().bind(personnagePrincipale.getHitbox().posYProperty());
    }
}
