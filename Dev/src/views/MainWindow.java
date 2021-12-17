package views;

import controllers.Manager;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import launch.Launcher;

public class MainWindow{
    // Attributes
    private final Manager mgr = Launcher.getManager();

    private final AnimationTimer mouvementTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            if (zPressed.get()){
                mgr.deplacerPersonnage(mgr.getPersonnagePrincipal(), 0);
            }
            if (sPressed.get()){
                mgr.deplacerPersonnage(mgr.getPersonnagePrincipal(), 1);
            }
            if (qPressed.get()){
                mgr.deplacerPersonnage(mgr.getPersonnagePrincipal(), 2);
            }
            if (dPressed.get()) {
                mgr.deplacerPersonnage(mgr.getPersonnagePrincipal(), 3);
            }
        }
    };

    // Properties
    private final BooleanProperty zPressed = new SimpleBooleanProperty();
    private final BooleanProperty sPressed = new SimpleBooleanProperty();
    private final BooleanProperty dPressed = new SimpleBooleanProperty();
    private final BooleanProperty qPressed = new SimpleBooleanProperty();
    private final BooleanBinding keyPressed = zPressed.or(sPressed).or(dPressed).or(qPressed);

    private final BooleanProperty spacePressed = new SimpleBooleanProperty();


    // FXML attributes
    @FXML
    public ImageView imageViewPP;
    @FXML
    public AnchorPane mainPane;
    @FXML
    public Rectangle hitboxTest;


    private void creerKeyListener() {
        Launcher.getStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> {
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
            if (event.getCode() == KeyCode.SPACE){
                spacePressed.set(true);
            }
        });
        Launcher.getStage().addEventHandler(KeyEvent.KEY_RELEASED, event -> {
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
                spacePressed.set(false);
            }
        });
    }



    @FXML
    public void initialize() {
        creerKeyListener();

        keyPressed.addListener(((observable, oldValue, newValue) -> {
            if (!oldValue) {
                mouvementTimer.start();
            }
            else {
                mouvementTimer.stop();
            }
        }));

        // Binding rectangle avec le PersonnagePrincipale
        imageViewPP.xProperty().bind(mgr.getPersonnagePrincipal().getHitbox().posXProperty());
        imageViewPP.yProperty().bind(mgr.getPersonnagePrincipal().getHitbox().posYProperty());
        imageViewPP.setImage(new Image(String.valueOf(getClass().getResource(mgr.getPersonnagePrincipal().getImage()))));
        imageViewPP.fitHeightProperty().bind(mgr.getPersonnagePrincipal().getHitbox().hauteurProperty());
        imageViewPP.fitWidthProperty().bind(mgr.getPersonnagePrincipal().getHitbox().longueurProperty());

        hitboxTest.xProperty().bind(mgr.getPersonnagePrincipal().getHitbox().posXProperty());
        hitboxTest.yProperty().bind(mgr.getPersonnagePrincipal().getHitbox().posYProperty());
        hitboxTest.heightProperty().bind(mgr.getPersonnagePrincipal().getHitbox().hauteurProperty());
        hitboxTest.widthProperty().bind(mgr.getPersonnagePrincipal().getHitbox().longueurProperty());

        mgr.getMonde().longueurProperty().bind(Launcher.getStage().widthProperty());
        mgr.getMonde().hauteurProperty().bind(Launcher.getStage().heightProperty());
    }


}
