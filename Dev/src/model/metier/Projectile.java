package model.metier;

public class Projectile extends Entite{

    public Projectile(double x, double y, double hauteur, double largeur) {
        setX(x);
        setY(y);
        setHauteur(hauteur);
        setLargeur(largeur);
    }

    public Projectile (double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
