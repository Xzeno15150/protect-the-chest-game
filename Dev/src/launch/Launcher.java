package launch;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Launcher extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent racine = FXMLLoader.load(getClass().getResource("/fxml/MainWindow.fxml"));
        Scene s = new Scene(racine);
        primaryStage.setScene(s);
        primaryStage.setTitle("test");
        primaryStage.show();
    }
}
