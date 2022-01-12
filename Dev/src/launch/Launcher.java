package launch;

import controllers.Manager;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import views.MainWindow;
import views.ManagerVue;

public class Launcher extends Application {
    private static Stage stage;
    private ManagerVue managerVue;

    private static final ObjectProperty<Manager> manager = new SimpleObjectProperty<>();
    public static Manager getManager() {
        return manager.get();
    }
    public static ObjectProperty<Manager> managerProperty() {
        return manager;
    }
    public static void setManager(Manager manager) {
        Launcher.manager.set(manager);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        setManager(new Manager());
        MainWindow mainWindow = new MainWindow();
        managerVue = new ManagerVue(mainWindow);

        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setController(mainWindow);
        fxmlLoader.setLocation(getClass().getResource("/fxml/MainWindow.fxml"));
        Parent racine = fxmlLoader.load();
        Scene s = new Scene(racine);

        getManager().getMonde().longueurProperty().bind(s.widthProperty());
        getManager().getMonde().hauteurProperty().bind(s.heightProperty());
        stage.setScene(s);
        stage.setTitle("Test");
        stage.show();
        managerVue.addListenerToProjectileCollection();
        getManager().startGame();
    }

    public static Stage getStage(){
        return stage;
    }
}
