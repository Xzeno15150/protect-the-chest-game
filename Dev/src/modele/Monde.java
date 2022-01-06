package modele;

import com.sun.javafx.collections.ObservableSetWrapper;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.ObservableSet;
import modele.obstacles.Obstacle;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Monde {
    // Attributes
    private List<Personnage> lesPersonnages;
    private ObservableSet<Projectile> lesProjectiles;
    private List<Obstacle> lesObstacles;

    // Properties
    private final DoubleProperty longueur = new SimpleDoubleProperty();
    public DoubleProperty longueurProperty() {
        return longueur;
    }
    public void setLongueur(double longueur) {
        this.longueur.set(longueur);
    }
    public double getLongueur() {
        return longueur.get();
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



    public Monde(List<Personnage> lesPersonnages, Set<Projectile> lesProjectiles, List<Obstacle> lesObstacles, double longueur, double hauteur) {
        this.lesPersonnages = lesPersonnages;
        this.lesProjectiles = new ObservableSetWrapper<>(lesProjectiles);
        this.lesObstacles = lesObstacles;
        setLongueur(longueur);
        setHauteur(hauteur);
    }

    public List<Personnage> getLesPersonnages() {
        return lesPersonnages;
    }
    public void setLesPersonnages(List<Personnage> lesPersonnages) {
        this.lesPersonnages = lesPersonnages;
    }


    public Set<Projectile> getLesProjectiles() {
        return lesProjectiles;
    }
    public void setLesProjectiles(ObservableSet<Projectile> lesProjectiles) {
        this.lesProjectiles = lesProjectiles;
    }

    public List<Obstacle> getLesObstacles() {
        return lesObstacles;
    }
    public void setLesObstacles(List<Obstacle> lesObstacles) {
        this.lesObstacles = lesObstacles;
    }

    public void addPersonnage(Personnage p) {
        lesPersonnages.add(p);
    }
    public void addObstacle(Obstacle o){
        lesObstacles.add(o);
    }
    public void addProjectile(Projectile p) {
        lesProjectiles.add(p);
    }
    public void removePersonnage(Personnage p){
        lesPersonnages.remove(p);
    }
    public void removeObstacle(Obstacle o){
        lesObstacles.remove(o);
    }
    public void removeProjectile(Projectile p){
        lesProjectiles.remove(p);
    }
}
