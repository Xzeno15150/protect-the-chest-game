package model.metier;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.Objects;

public abstract class Entite {

    // Properties
    private DoubleProperty x = new SimpleDoubleProperty();
    public double getX() {return x.get();}
    public DoubleProperty xProperty() {return x;}
    public void setX(double x) {this.x.set(x);}

    private DoubleProperty y = new SimpleDoubleProperty();
    public double getY() {return y.get();}
    public DoubleProperty yProperty() {return y;}
    public void setY(double y) {this.y.set(y);}

    private DoubleProperty hauteur = new SimpleDoubleProperty();
    public double getHauteur() {return hauteur.get();}
    public DoubleProperty hauteurProperty() {return hauteur;}
    public void setHauteur(double hauteur) {this.hauteur.set(hauteur);}

    private DoubleProperty largeur = new SimpleDoubleProperty();
    public double getLargeur() {return largeur.get();}
    public DoubleProperty largeurProperty() {return largeur;}
    public void setLargeur(double largeur) {this.largeur.set(largeur);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entite entite = (Entite) o;
        return x.equals(entite.x) && y.equals(entite.y) && hauteur.equals(entite.hauteur) && largeur.equals(entite.largeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, hauteur, largeur);
    }
}
