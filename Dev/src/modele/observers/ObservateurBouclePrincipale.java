package modele.observers;

import javafx.application.Platform;
import launch.Launcher;

public class ObservateurBouclePrincipale implements ObservateurBoucle{
    @Override
    public void update() {
        Platform.runLater(() -> Launcher.getManager().tour());
    }
}
