package launcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Manager;
import views.ManagerVue;
import views.codeBehind.MainWindow;

public class Launch extends Application {

    private static Stage primaryStage;
    private static Manager mgr;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Launch.primaryStage = primaryStage;
        mgr = new Manager();

        var mainWindow = new MainWindow();
        var managerVue = new ManagerVue(mgr, mainWindow);
        managerVue.addListenerForProjectiles();
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(mainWindow);
        fxmlLoader.setLocation(getClass().getResource("/fxml/MainWindow.fxml"));
        Parent root = fxmlLoader.load();

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
}
