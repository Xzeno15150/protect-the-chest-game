package modele.collisions;

public class Hitbox {
    private int longueur;
    private int largeur;

    public Hitbox(int longueur, int largeur) {
        this.longueur = longueur;
        this.largeur = largeur;
    }
    public Hitbox(int cote){
        this(cote, cote);
    }

    public int getLongueur() {
        return longueur;
    }
    public int getLargeur() {
        return largeur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }
    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
