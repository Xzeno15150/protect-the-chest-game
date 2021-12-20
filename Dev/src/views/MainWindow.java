package views;

import controllers.Manager;
import javafx.animation.AnimationTimer;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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

    // FXML attributes
    @FXML
    public ImageView imageViewPP;
    @FXML
    public AnchorPane mainPane;
    @FXML
    public Rectangle hitboxTest;
    @FXML
    public Label labelCoord;


    @FXML
    public void initialize() {
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
