package model.metier;

/**
 * un Personnage est une Entite qui pourra se déplacer
 */
public class Personnage extends Entite{
    /**
     * appelle des méthodes d'Entite pour créer l'objet Personnage rectangulaire
     * @param x coordonnée x
     * @param y coordonnée y
     * @param hauteur hauteur de l'Obstacle
     * @param largeur largeur de l'Obstacle
     */
    public Personnage(double x, double y, double hauteur, double largeur) {
        setX(x);
        setY(y);
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    /**
     * appelle des méthodes d'Entite pour créer l'objet Personnage carré
     * @param x coordonnée x
     * @param y coordonnée y
     * @param cote longueur du coté de Personnage
     */
    public Personnage (double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
