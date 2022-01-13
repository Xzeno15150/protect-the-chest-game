package model.observers;

import javafx.application.Platform;
import model.Manager;

public class ObservateurPrincipal implements Observer{

    private Manager mgr;

    public ObservateurPrincipal(Manager mgr){
        this.mgr = mgr;
    }
    @Override
    public void update() {
        Platform.runLater(() -> {
            mgr.deplacerPersonnagePrincipal();
            mgr.tirer();
        });
    }
}
