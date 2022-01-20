package model.metier;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Objects;

/**
 * Une Entite possède des coordonnées, une hauteur et une largeur
 */
public abstract class Entite {

    // Properties

    private DoubleProperty x = new SimpleDoubleProperty();

    /**
     * Récupère la valeur de x
     * @return Retourne la valeur de x (double)
     */
    public double getX() {return x.get();}

    /**
     * Récupère la Property de x
     * @return Retourne la Property de x (DoubleProperty)
     */
    public DoubleProperty xProperty() {return x;}

    /**
     * change la valeur de x
     * @param x Par x (double)
     */
    public void setX(double x) {this.x.set(x);}


    private DoubleProperty y = new SimpleDoubleProperty();

    /**
     * Récupère la valeur de y
     * @return Retourne la valeur de y (double)
     */
    public double getY() {return y.get();}

    /**
     * Récupère la Property de y
     * @return Retourne la Property de y (DoubleProperty)
     */
    public DoubleProperty yProperty() {return y;}

    /**
     * change la valeur de y
     * @param y Par y (double)
     */
    public void setY(double y) {this.y.set(y);}


    private DoubleProperty hauteur = new SimpleDoubleProperty();

    /**
     * Récupère la valeur de hauteur
     * @return Retourne la valeur de hauteur (double)
     */
    public double getHauteur() {return hauteur.get();}

    /**
     * Récupère la Property de hauteur
     * @return Retourne la Property de y (DoubleProperty)
     */
    public DoubleProperty hauteurProperty() {return hauteur;}

    /**
     * change la valeur de hauteur
     * @param hauteur Par hauteur (double)
     */
    public void setHauteur(double hauteur) {this.hauteur.set(hauteur);}


    private DoubleProperty largeur = new SimpleDoubleProperty();

    /**
     * Récupère la valeur de largeur
     * @return Retourne la valeur de largeur (double)
     */
    public double getLargeur() {return largeur.get();}

    /**
     * Récupère la Property de largeur
     * @return Retourne la Property de largeur (DoubleProperty)
     */
    public DoubleProperty largeurProperty() {return largeur;}

    /**
     * change la valeur de largeur
     * @param largeur Par largeur (double)
     */
    public void setLargeur(double largeur) {this.largeur.set(largeur);}

    /**
     * regarde si deux objets sont des Entite égales
     * @param o Objet que l'on veut étudier
     * @return retourne un boolean : true si l'Objet passé est une Entite, false sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entite entite = (Entite) o;
        return x.equals(entite.x) && y.equals(entite.y) && hauteur.equals(entite.hauteur) && largeur.equals(entite.largeur);
    }

    /**
     * Créer le hash de l'Objet de type int
     * @return Retourne le hash de l'Objet (int)
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y, hauteur, largeur);
    }
}
