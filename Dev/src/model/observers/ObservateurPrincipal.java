package model.observers;

import javafx.application.Platform;
import model.Manager;

/**
 * ObservateurPrincipal est un Observer qui permet d'update le manager à chaque tour de la boucle
 */
public class ObservateurPrincipal implements Observer{

    private Manager mgr;

    /**
     * constructeur d'ObservateurPrincipal qui récupere le Manager
     * @param mgr Manager mgr permet de mettre à jour le Manager
     */
    public ObservateurPrincipal(Manager mgr){
        this.mgr = mgr;
    }

    /**
     * update appelle les méthodes deplacerPersonnagePrincipal() et tirer() à chaque tour de boucle
     */
    @Override
    public void update() {
        Platform.runLater(() -> {
            mgr.deplacerPersonnagePrincipal();
            mgr.tirer();
        });
    }
}
