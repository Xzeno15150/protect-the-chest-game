package model.observers;

/**
 * Observer est une interface qui observe la boucle pour mettre à jour les objets
 */
public interface Observer {
    /**
     * update permet d'appeler des méthodes pour mettre à jour les objets à chaque tour de boucle
     */
    void update();
}
