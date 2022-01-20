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
import model.metier.Ennemi;
import model.metier.Entite;
import model.metier.Projectile;
import views.codeBehind.GameWindow;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ManagerVue fait le lien entre les vues et le Manager
 */
public class ManagerVue {

    private final Manager mgr;
    private GameWindow gameWindow;
    private final Map<Entite, Rectangle> projectileRectangleMap = new HashMap<>();

    /**
     * constructeur il recupere le Manager pour la liste des Entite et pour lancer ses méthodes, il ajout un Listener sur gameRunningProperty pour pouvoir lancer la vue GameOver
     * @param mgr Manager mgr il récupère le Manager
     */
    public ManagerVue(Manager mgr){
        this.mgr = mgr;
        mgr.gameRunningProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue) {
                try {
                    gameOver();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * addListenerForEntites permet d'ajouter un Listener pour chaque Entite dans la liste du Manager afin de pouvoir ajouter/supprimer les Entite dans la vue
     */
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

    /**
     * récupère le bouton de la fenêtre pour récupérer sa Stage et pouvoir la fermer
     * @param btn Button btn est le bouton de la fenetre à fermer
     */
    public void quitter(Button btn){
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
        mgr.setGameRunning(false);
    }

    /**
     * charge la fenetre GameWindow et l'affiche puis appel la méthode StartGame du manager pour pouvoir lancer le jeu
     * @throws IOException Relance en cas d'Exception
     */
    public void jouer() throws IOException {
        var loader = new FXMLLoader(getClass().getResource("/fxml/GameWindow.fxml"));
        gameWindow = new GameWindow();
        loader.setController(gameWindow);
        Parent root;
        root = loader.load();

        addListenerForEntites();
        Launch.getPrimaryStage().setScene(new Scene(root));
        mgr.startGame();
    }

    /**
     * charge la fenetre GameOver et l'affiche
     * @throws IOException Relance en cas d'Exception
     */
    public void gameOver() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/GameOver.fxml"));
        Stage primaryStage = Launch.getPrimaryStage();
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
