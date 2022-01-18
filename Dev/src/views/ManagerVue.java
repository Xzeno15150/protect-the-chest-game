package views;

import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
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
    private GameWindow gameWindow;
    private final Map<Projectile, Rectangle> projectileRectangleMap = new HashMap<>();

    public ManagerVue(Manager mgr){
        this.mgr = mgr;
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
                        gameWindow.addNode(r);
                    }
                }
                if (c.wasRemoved()) {
                    Entite e = c.getRemoved().get(0);
                    if (e instanceof Projectile) {
                        gameWindow.removeNode(projectileRectangleMap.get(e));
                        projectileRectangleMap.remove(e);
                    }
                }
            }
        });
    }

    public void quitter(Button btn){
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    public void jouer() throws IOException {
        mgr.startGame();

        var loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));
        // gameWindow = loader.getController();
        gameWindow = new GameWindow();
        loader.setController(gameWindow);
        Parent root;
        root = loader.load();

        addListenerForEntites();
        Launch.getPrimaryStage().setScene(new Scene(root));
    }
}
