package model.metier;

/**
 * un Obstacle est une Entite simple
 */
public class Obstacle extends Entite {
    /**
     * appelle des méthodes d'Entite pour créer l'objet Obstacle rectangulaire
     * @param x coordonnée x
     * @param y coordonnée y
     * @param hauteur hauteur de l'Obstacle
     * @param largeur largeur de l'Obstacle
     */
    public Obstacle(double x, double y, double hauteur, double largeur) {
        setX(x);
        setY(y);
        setHauteur(hauteur);
        setLargeur(largeur);

    }

    /**
     * appelle des méthodes d'Entite pour créer l'objet Obstacle carré
     * @param x coordonnée x
     * @param y coordonnée y
     * @param cote longueur du coté de l'Obstacle
     */
    public Obstacle (double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
