package model.metier;

public class Ennemi extends Personnage{
    public Ennemi(double x, double y, double hauteur, double largeur) {
        super(x, y, hauteur, largeur);
    }

    public Ennemi(double x, double y, double cote) {
        this(x, y, cote, cote);
    }
}
