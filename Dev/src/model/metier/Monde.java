package model.metier;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Monde contient le personnage principal, le coffre, les ennemis et les obstacles
 */
public class Monde {

    private static final double TAILLE_ENNEMI = 30;

    private final Personnage personnagePrincipal;
    private final Obstacle coffre;

    private final ListProperty<Entite> lesEntites;
        /**
         * Récupère la liste des Entite du Monde
         * @return retourne la liste des Entite du Monde (List)
         */
        public List<Entite> getLesEntites(){
            return lesEntites.get();
        }
        /**
         * Récupère la ListProperty des Entite du Monde
         * @return retourne la ListProperty des Entite du Monde
         */
        public ListProperty<Entite> lesEntitesProperty() {
            return lesEntites;
        }
        /**
         * change la liste des Entite du Monde
         * @param lesEntites Par lesEntites (ObservableList)
         */
        public void setLesEntites(ObservableList<Entite> lesEntites) {
                this.lesEntites.set(lesEntites);
            }

    private final DoubleProperty largeur = new SimpleDoubleProperty();
        /**
         * Récupère la valeur de la largeur du monde
         * @return retourne la valeur de la largeur du monde (double)
         */
        public double getLargeur() {
            return largeur.get();
        }
        /**
         * Récupère la Property de la largeur du Monde
         * @return retourne la Property de la largeur du Monde (DoubleProperty)
         */
        public DoubleProperty largeurProperty() {
            return largeur;
        }
        /**
         * change la valeur de la largeur du Monde
         * @param largeur Par largeur (double)
         */
        public void setLargeur(double largeur) {
            this.largeur.set(largeur);
        }

    private final DoubleProperty hauteur = new SimpleDoubleProperty();
        /**
         * Récupère la valeur de la hauteur du Monde
         * @return retourne la valeur de la hauteur du Monde (double)
         */
        public double getHauteur() {
            return hauteur.get();
        }
        /**
         * Récupère la Property de la hauteur du Monde
         * @return retourne la Property de la hauteur du Monde (DoubleProperty)
         */
        public DoubleProperty hauteurProperty() {
            return hauteur;
        }

        /**
         * change la valeur de la hauteur du Monde
         * @param hauteur Par hauteur (double)
         */
        public void setHauteur(double hauteur) {
            this.hauteur.set(hauteur);
        }

    /**
     * constructeur du monde
     * @param entites Prend une liste d'Entite (la premiere est le personnage principal et la seconde est le coffre le reste sont des obstacles ou des ennemis)
     */
    public Monde(List<Entite> entites){
        lesEntites = new SimpleListProperty<>(FXCollections.observableList(entites));
        this.personnagePrincipal = (Personnage) lesEntites.get(0);
        this.coffre = (Obstacle) lesEntites.get(1);
    }

    /**
     * Récupère le personnage principal
     * @return retourne le personnage principal (Personnage)
     */
    public Personnage getPersonnagePrincipal() {
        return personnagePrincipal;
    }

    /**
     * Récupère le coffre
     * @return retourne le coffre (Obstacle)
     */
    public Obstacle getCoffre() {
        return coffre;
    }

    /**
     * Ajoute une Entite à la liste des Entite si possible
     * @param entite entite à ajouter à la liste (Entite)
     * @return retourne un boolean : true si l'Entite n'est pas déjà dans la liste et a pu être ajoutée, false sinon
     */
    public boolean addEntite(Entite entite) {
        if (!lesEntites.contains(entite)) {
            return lesEntites.add(entite);
        }
        return false;
    }

    /**
     * Supprime une Entite de la liste si possible
     * @param entite entite à supprimer de la liste (Entite)
     * @return retourne un boolean : true si la suppression c'est effectué, false sinon
     */
    public boolean removeEntite(Entite entite) {
        return lesEntites.remove(entite);
    }

    /**
     * permet de créer un Ennemi à une position aléatoire puis appel la méthode addEntite pour l'ajouter à la liste
     */
    public void createRandomPosEnnemi() {
        double x, y;
        x = Math.random() * (getLargeur()-TAILLE_ENNEMI-10);
        y = Math.random() * (getHauteur()/5) + TAILLE_ENNEMI+5;
        while(!addEntite(new Ennemi(x,y,TAILLE_ENNEMI))){
            x = Math.random() * (getLargeur()-TAILLE_ENNEMI-5);
            y = Math.random() * (getHauteur()/5) + TAILLE_ENNEMI+5;
        }
    }
}
