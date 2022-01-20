package model.data;

import model.metier.Monde;

/**
 * Saver est une interface qui permet d'enregistrer les données d'un Monde
 */
public interface Saver {
    /**
     * permet d'enregistrer un Monde
     * @param monde Prend en paramètre un Monde qui sera enregistré
     */
    void save(Monde monde);
}
