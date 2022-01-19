package model.metier;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Monde {

    private static final double TAILLE_ENNEMI = 30;

    private final Personnage personnagePrincipal;
    private final Obstacle coffre;

    private final ListProperty<Entite> lesEntites;
        public List<Entite> getLesEntites(){
            return lesEntites.get();
        }
        public ListProperty<Entite> lesEntitesProperty() {
        return lesEntites;
    }
        public void setLesEntites(ObservableList<Entite> lesEntites) {
        this.lesEntites.set(lesEntites);
    }

    private final DoubleProperty largeur = new SimpleDoubleProperty();
        public double getLargeur() {
        return largeur.get();
    }
        public DoubleProperty largeurProperty() {
        return largeur;
    }
        public void setLargeur(double largeur) {
        this.largeur.set(largeur);
    }

    private final DoubleProperty hauteur = new SimpleDoubleProperty();
        public double getHauteur() {
        return hauteur.get();
    }
        public DoubleProperty hauteurProperty() {
        return hauteur;
    }
        public void setHauteur(double hauteur) {
        this.hauteur.set(hauteur);
    }

    public Monde(List<Entite> entites){
        lesEntites = new SimpleListProperty<>(FXCollections.observableList(entites));
        this.personnagePrincipal = (Personnage) lesEntites.get(0);
        this.coffre = (Obstacle) lesEntites.get(1);
    }

    public Personnage getPersonnagePrincipal() {
        return personnagePrincipal;
    }

    public Obstacle getCoffre() {
        return coffre;
    }

    public boolean addEntite(Entite entite) {
        if (!lesEntites.contains(entite)) {
            return lesEntites.add(entite);
        }
        return false;
    }

    public boolean removeEntite(Entite entite) {
        return lesEntites.remove(entite);
    }

    public void createRandomPosEnnemi() {
        double x, y;
        x = Math.random() * (getLargeur()-TAILLE_ENNEMI*2);
        y = Math.random() * (getHauteur()/5) + TAILLE_ENNEMI+5;
        while(!addEntite(new Ennemi(x,y,TAILLE_ENNEMI))){
            x = Math.random() * (getLargeur()-TAILLE_ENNEMI*2);
            y = Math.random() * (getHauteur()/5) + TAILLE_ENNEMI+5;
        }
    }
}
