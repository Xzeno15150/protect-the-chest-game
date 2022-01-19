package views;

import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
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
import model.metier.Ennemi;
import model.metier.Entite;
import model.metier.Projectile;
import views.codeBehind.GameOver;
import views.codeBehind.GameWindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ManagerVue {

    private final Manager mgr;
    private GameWindow gameWindow;
    private final Map<Entite, Rectangle> projectileRectangleMap = new HashMap<>();

    public ManagerVue(Manager mgr){
        this.mgr = mgr;
    }

    private void addListenerForEntites(){
        mgr.getMonde().lesEntitesProperty().addListener((ListChangeListener<? super Entite>) c -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    Entite e = c.getAddedSubList().get(0);
                    Rectangle r = new Rectangle();
                    if (e instanceof Projectile) {
                        r.setFill(Color.GREEN);
                    }
                    if (e instanceof Ennemi) {
                        r.setFill(Color.BLUE);
                    }
                    gameWindow.createBinding(r, e);
                    projectileRectangleMap.put(e, r);
                    gameWindow.addNode(r);
                }
                if (c.wasRemoved()) {
                    Entite e = c.getRemoved().get(0);
                    gameWindow.removeNode(projectileRectangleMap.get(e));
                    projectileRectangleMap.remove(e);
                }
            }
        });
    }

    public void quitter(Button btn){
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        mgr.setGameRunning(false);
    }

    public void jouer() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));
        gameWindow = new GameWindow();
        loader.setController(gameWindow);
        Parent root;
        root = loader.load();

        addListenerForEntites();
        Launch.getPrimaryStage().setScene(new Scene(root));
        mgr.startGame();
        //gameOver();
    }

    public void gameOver() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameOver.fxml"));
        Stage primaryStage = Launch.getPrimaryStage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
