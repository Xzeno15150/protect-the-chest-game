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

public class Launch extends Application {

    private static Stage primaryStage;
    private static Manager mgr;
    private static ManagerVue managerVue;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Launch.primaryStage = primaryStage;
        mgr = new Manager();
        managerVue = new ManagerVue(mgr);


        Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainMenu.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Test");
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    public static Manager getManager() {
        return mgr;
    }

    public static ManagerVue getManagerVue() {
        return managerVue;
    }
}
