package views;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import launcher.Launch;
import model.Manager;
import model.metier.Entite;
import model.metier.Projectile;
import views.codeBehind.GameWindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ManagerVue {

    private final Manager mgr;
    private final GameWindow gameWindow;
    private final Map<Projectile, Rectangle> projectileRectangleMap = new HashMap<>();

    public ManagerVue(Manager mgr){
        this.mgr = mgr;
        gameWindow = new GameWindow();
    }

    private void addListenerForEntites(){
        mgr.getMonde().lesEntitesProperty().addListener((ListChangeListener<? super Entite>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Entite e = c.getAddedSubList().get(0);
                    if (e instanceof Projectile) {
                        Rectangle r = new Rectangle();
                        r.setFill(Color.GREEN);
                        gameWindow.createBinding(r, e);
                        projectileRectangleMap.put((Projectile) e, r);
                        gameWindow.getMainPane().getChildren().add(r);
                    }
                }
                if (c.wasRemoved()) {
                    Entite e = c.getRemoved().get(0);
                    if (e instanceof Projectile) {
                        gameWindow.getMainPane().getChildren().remove(projectileRectangleMap.get(e));
                        projectileRectangleMap.remove(e);
                    }
                }
            }
        });
    }

    public void jouer() {
        mgr.startGame();
        var gameWindow = new GameWindow();

        var loader = new FXMLLoader();
        loader.setController(gameWindow);
        Parent root = null;

        try {

            root = loader.load(getClass().getResource("/fxml/GameWindow.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        addListenerForEntites();
        Launch.getPrimaryStage().setScene(new Scene(root));

        // TODO Modifier les vues pour que se soit des fxroot, et ajouter une vue contenant ces fxroot pour faire le changement
    }
}
