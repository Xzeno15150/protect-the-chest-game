package model.data;

import model.metier.Monde;

/**
 * Loader est une interface qui permet de charger les données d'un Monde
 */
public interface Loader {
    /**
     * recupère un Monde avec des données
     * @return retourne un Monde avec des données
     */
    Monde load();
}
