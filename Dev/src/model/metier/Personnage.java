package model.metier;

public class Personnage extends Entite{

    public Personnage(double x, double y, double hauteur, double largeur) {
        setX(x);
        setY(y);
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    public Personnage (double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
