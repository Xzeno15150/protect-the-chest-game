package model.deplacement;

import model.metier.Entite;

/**
 * Interface de déplacement d'une entité en bas
 */
public interface DeplaceurBas {
    /**
     * Deplacer une entite vers le bas
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    boolean deplacerBas(Entite e);
}
