package views;

import controllers.Manager;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
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
import modele.personnages.Personnage;

public class MainWindow{

    // Attributes
    private final Manager mgr = Launcher.getManager();

    private final AnimationTimer mouvementTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (zPressed.get()){
                mgr.deplacerPersonnage(personnagePrincipale, 0);
            }
            if (sPressed.get()){
                mgr.deplacerPersonnage(personnagePrincipale, 1);
            }
            if (qPressed.get()){
                mgr.deplacerPersonnage(personnagePrincipale, 2);
            }
            if (dPressed.get()) {
                mgr.deplacerPersonnage(personnagePrincipale, 3);
            }
        }
    };

    private Personnage personnagePrincipale;

    // Property
    private final BooleanProperty zPressed = new SimpleBooleanProperty();
    private final BooleanProperty sPressed = new SimpleBooleanProperty();
    private final BooleanProperty dPressed = new SimpleBooleanProperty();
    private final BooleanProperty qPressed = new SimpleBooleanProperty();

    private final BooleanBinding keyPressed = zPressed.or(sPressed).or(dPressed).or(qPressed);

    private final BooleanProperty pPressed = new SimpleBooleanProperty();


    // FXML attributes
    @FXML
    public Rectangle rectanglePersonnagePrincipale;
    @FXML
    public Label labelTest;
    @FXML
    public AnchorPane mainPane;

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
            if (event.getCode() == KeyCode.P){
                pPressed.set(true);
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
            if (event.getCode() == KeyCode.P){
                pPressed.set(false);
            }
        });
    }


    @FXML
    public void handleClickBtn(ActionEvent actionEvent) {
        personnagePrincipale.getHitbox().setPosX(130);
        personnagePrincipale.getHitbox().setPosY(100);
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

        personnagePrincipale = mgr.getPersonnagePrincipale();

        // Binding rectangle avec le PersonnagePrincipale
        rectanglePersonnagePrincipale.xProperty().bind(personnagePrincipale.getHitbox().posXProperty());
        rectanglePersonnagePrincipale.yProperty().bind(personnagePrincipale.getHitbox().posYProperty());
    }


}
