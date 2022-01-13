package views;

import javafx.collections.ListChangeListener;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.Manager;
import model.metier.Entite;
import model.metier.Projectile;
import views.codeBehind.MainWindow;

import java.util.HashMap;
import java.util.Map;

public class ManagerVue {

    private final Manager mgr;
    private final MainWindow mainWindow;
    private final Map<Projectile, Rectangle> projectileRectangleMap = new HashMap<>();

    public ManagerVue(Manager mgr, MainWindow mainWindow){
        this.mgr = mgr;
        this.mainWindow = mainWindow;
    }


    public void addListenerForProjectiles(){
        mgr.getMonde().lesEntitesProperty().addListener((ListChangeListener<? super Entite>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Entite e = c.getAddedSubList().get(0);
                    if (e instanceof Projectile) {
                        Rectangle r = new Rectangle();
                        r.setFill(Color.GREEN);
                        mainWindow.createBinding(r, e);
                        projectileRectangleMap.put((Projectile) e, r);
                        mainWindow.getMainPane().getChildren().add(r);
                    }
                }
                if (c.wasRemoved()) {
                    Entite e = c.getRemoved().get(0);
                    if (e instanceof Projectile) {
                        mainWindow.getMainPane().getChildren().remove(projectileRectangleMap.get(e));
                        projectileRectangleMap.remove(e);
                    }
                }
            }
        });
    }
}
