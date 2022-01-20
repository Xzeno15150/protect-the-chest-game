package model.deplacement;

import model.metier.Entite;

/**
 * Interface de déplacement d'une entité en haut
 */
public interface DeplaceurHaut {
    /**
     * Deplacer une entite vers le haut
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    boolean deplacerHaut(Entite e);
}
