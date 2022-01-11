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
import modele.obstacles.Obstacle;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

import java.net.URL;

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
    public Rectangle balleHB;

    public void ajouterProjectile(ImageView newI) {
        mainPane.getChildren().add(newI);
    }

    public void retirerProjectile(ImageView newI) {
            mainPane.getChildren().remove(newI);
    }


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

        for (Obstacle o: mgr.getMonde().getLesObstacles()) {
            ImageView imgObs= new ImageView();
            imgObs.setX(o.getHitbox().getPosX());
            imgObs.setY(o.getHitbox().getPosY());
            imgObs.setFitHeight(o.getHitbox().getHauteur());
            imgObs.setFitWidth(o.getHitbox().getLongueur());
            imgObs.setImage(new Image(o.getImage()));
            mainPane.getChildren().add(imgObs);

        }
        boolean pp=true;
        for (Personnage p: mgr.getMonde().getLesPersonnages()) {
            if(pp){
                pp=false;
                continue;
            }

            ImageView imgObs= new ImageView();
            imgObs.setX(p.getHitbox().getPosX());
            imgObs.setY(p.getHitbox().getPosY());
            imgObs.setFitHeight(p.getHitbox().getHauteur());
            imgObs.setFitWidth(p.getHitbox().getLongueur());
            imgObs.setImage(new Image(p.getImage()));
            mainPane.getChildren().add(imgObs);

        }
    }


}
