package model.metier;

/**
 * un Projectile est une Entite qui pourra se déplacer vers le haut
 */
public class Projectile extends Entite{
    /**
     * appelle des méthodes d'Entite pour créer l'objet Projectile rectangulaire
     * @param x coordonnée x
     * @param y coordonnée y
     * @param hauteur hauteur de l'Obstacle
     * @param largeur largeur de l'Obstacle
     */
    public Projectile(double x, double y, double hauteur, double largeur) {
        setX(x);
        setY(y);
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    /**
     * appelle des méthodes d'Entite pour créer l'objet Projectile carré
     * @param x coordonnée x
     * @param y coordonnée y
     * @param cote longueur du coté de Projectile
     */
    public Projectile (double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
