package model.metier;

public class Obstacle extends Entite {
    public Obstacle(double x, double y, double hauteur, double largeur) {
        setX(x);
        setY(y);
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    public Obstacle (double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
