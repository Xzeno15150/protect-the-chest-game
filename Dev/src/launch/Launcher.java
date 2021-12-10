package launch;

import controllers.Manager;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modele.Monde;

import java.util.ArrayList;

public class Launcher extends Application {
    private static ObjectProperty<Manager> manager = new SimpleObjectProperty<>();
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
        Monde monde = new Monde(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        setManager(new Manager(monde));


        Parent racine = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
        Scene s = new Scene(racine);

        primaryStage.setScene(s);
        primaryStage.setTitle("test");
        primaryStage.show();
    }

}
