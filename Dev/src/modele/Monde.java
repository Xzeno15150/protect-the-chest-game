package modele;

import modele.obstacles.Obstacle;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

import java.util.List;

public class Monde {
    private List<Personnage> lesPersonnages;
    private List<Projectile> lesProjectiles;
    private List<Obstacle> lesObstacles;
    private double longueur;
    private double largeur;

    public Monde(List<Personnage> lesPersonnages, List<Projectile> lesProjectiles, List<Obstacle> lesObstacles, double longueur, double largeur) {
        this.lesPersonnages = lesPersonnages;
        this.lesProjectiles = lesProjectiles;
        this.lesObstacles = lesObstacles;
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public List<Personnage> getLesPersonnages() {
        return lesPersonnages;
    }
    public void setLesPersonnages(List<Personnage> lesPersonnages) {
        this.lesPersonnages = lesPersonnages;
    }

    public List<Projectile> getLesProjectiles() {
        return lesProjectiles;
    }
    public void setLesProjectiles(List<Projectile> lesProjectiles) {
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

    public double getLongueur() {
        return longueur;
    }
    public double getLargeur() {
        return largeur;
    }
}
