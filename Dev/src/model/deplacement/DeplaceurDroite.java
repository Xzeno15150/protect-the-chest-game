package model.deplacement;

import model.metier.Entite;

/**
 * Interface de déplacement d'une entité à droite
 */
public interface DeplaceurDroite {
    /**
     * Deplacer une entite vers la droite
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    boolean deplacerDroite(Entite e);
}
