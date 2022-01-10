package views;

import controllers.Manager;
import javafx.collections.ListChangeListener;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import launch.Launcher;
import modele.projectiles.Projectile;

import java.util.HashMap;
import java.util.Map;

public class ManagerVue {

    private final MainWindow mainWindow;
    private final Map<Projectile, ImageView> projectileImageViewMap = new HashMap<>();

    public ManagerVue(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    public void addListenerToProjectileCollection() {
        Manager mgr = Launcher.getManager();
        mgr.getMonde().lesProjectilesProperty().addListener((ListChangeListener<? super Projectile>)  c -> {
            while(c.next()) {
                if (c.wasAdded()) {
                    Projectile p = c.getAddedSubList().get(0);
                    ImageView imageView = new ImageView(new Image(p.getImage()));
                    imageView.setFitHeight(p.getHitbox().getHauteur());
                    imageView.setFitWidth(p.getHitbox().getLongueur());
                    imageView.xProperty().bind(p.getHitbox().posXProperty());
                    imageView.yProperty().bind(p.getHitbox().posYProperty());

                    projectileImageViewMap.put(p, imageView);

                    mainWindow.ajouterProjectile(imageView);
                }
                if (c.wasRemoved()){
                    Projectile p = c.getRemoved().get(0);
                    mainWindow.retirerProjectile(projectileImageViewMap.get(p));
                    projectileImageViewMap.remove(p);
                }
            }
        });
    }
}
