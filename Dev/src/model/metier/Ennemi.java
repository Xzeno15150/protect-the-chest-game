package model.metier;

/**
 * un Ennemi est un Personnage simple
 */
public class Ennemi extends Personnage{
    /**
     * appel le constructeur de Personnage pour un rectangle
     * @param x coordonnée x
     * @param y coordonnée y
     * @param hauteur hauteur de l'Entite
     * @param largeur largeur de l'Entite
     */
    public Ennemi(double x, double y, double hauteur, double largeur) {
        super(x, y, hauteur, largeur);
    }

    /**
     * appel le constructeur de Personnage pour un carré
     * @param x coordonnée x
     * @param y coordonnée y
     * @param cote longueur d'un coté
     */
    public Ennemi(double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
