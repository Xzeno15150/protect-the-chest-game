package launcher;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Manager;
import views.ManagerVue;
import views.codeBehind.GameWindow;
import views.codeBehind.MainMenu;

/**
 * Lauch est la classe appellé au lancement de l'application elle permet de charger la vue et de créer les managers
 */
public class Launch extends Application {

    private static Stage primaryStage;
    private static Manager mgr;
    private static ManagerVue managerVue;

    /**
     * charge la vue MainMenu et instancie le Manager
     * @param primaryStage Prend la fenetre principale
     * @throws Exception Relance en cas d'Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Launch.primaryStage = primaryStage;
        mgr = new Manager();
        mgr.init();
        managerVue = new ManagerVue(mgr);
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Protect the Trunk");
        primaryStage.show();

    }

    /**
     * recupere la fenetre principale
     * @return retourne la fenetre principale (Stage)
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * recupere le Manager
     * @return retourne le Manager (Manager)
     */
    public static Manager getManager() {
        return mgr;
    }

    /**
     * recupere le ManagerVue
     * @return retourne le ManagerVue (ManagerVue)
     */
    public static ManagerVue getManagerVue() {
        return managerVue;
    }
}
