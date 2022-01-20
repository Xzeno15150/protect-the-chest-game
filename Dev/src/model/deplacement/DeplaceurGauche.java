package model.deplacement;

import model.metier.Entite;

/**
 * Interface de déplacement d'une entité à gauche
 */
public interface DeplaceurGauche {
    /**
     * Deplacer une entite vers la gauche
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    boolean deplacerGauche(Entite e);
}
