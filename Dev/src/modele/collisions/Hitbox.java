package modele.collisions;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class Hitbox {

    // Properties
    private final IntegerProperty longueur = new SimpleIntegerProperty();
    public int getLongueur() {
        return longueur.get();
    }
    public IntegerProperty longueurProperty() {
        return longueur;
    }
    public void setLongueur(int longueur) {
        this.longueur.set(longueur);
    }

    private final IntegerProperty hauteur = new SimpleIntegerProperty();
    public int getHauteur() {
        return hauteur.get();
    }
    public IntegerProperty hauteurProperty() {
        return hauteur;
    }
    public void setHauteur(int hauteur) {
        this.hauteur.set(hauteur);
    }

    private final IntegerProperty posX = new SimpleIntegerProperty();
    public int getPosX() {
        return posX.get();
    }
    public void setPosX(int posX) {
        this.posX.set(posX);
    }
    public IntegerProperty posXProperty() {
        return posX;
    }

    private final IntegerProperty posY = new SimpleIntegerProperty();
    public int getPosY() {
        return posY.get();
    }
    public IntegerProperty posYProperty() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY.set(posY);
    }


    // Constructeurs
    public Hitbox(int longueur, int largeur, int x, int y) {
        setHauteur(largeur);
        setLongueur(longueur);
        setPosX(x);
        setPosY(y);
    }

    public Hitbox(int cote, int x, int y){
        this(cote, cote, x, y);
    }

    // Methods

    /**
     * Renvoi la position X du coin supérieur gauche
     * @return position X du coin supérieur gauche
     */
    public int getTLCornerX(){
        return getPosX() - getLongueur()/2;
    }

    /**
     * Renvoi la position Y du coin supérieur gauche
     * @return position Y du coin supérieur gauche
     */
    public int getTLCornerY(){
        return getPosY() - getHauteur()/2;
    }

    /**
     * Renvoi la position X du coin inférieur droit
     * @return position X du coin inférieur droit
     */
    public int getBRCornerX(){
        return getPosX() + getLongueur()/2;
    }

    /**
     * Renvoi la position Y du coin inférieur droit
     * @return position Y du coin inférieur droit
     */
    public int getBRCornerY(){
        return getPosY() + getHauteur()/2;
    }
}
