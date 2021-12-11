package controllers;

import modele.Monde;
import modele.collisions.Hitbox;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.personnages.Personnage;
import modele.projectiles.Balle;
import modele.projectiles.Projectile;

public class Manager {

    // Attributes
    private final Monde monde;
    private final Personnage personnagePrincipale;

    // Constructor
    public Manager(Monde monde) {
        this.monde = monde;
        personnagePrincipale = monde.getLesPersonnages().get(0);
    }

    // Getter/Setter
    public Monde getMonde() {
        return monde;
    }
    public Personnage getPersonnagePrincipale() {
        return personnagePrincipale;
    }

    // Methods
    public void deplacerPersonnage(Personnage p, int dir){
        DeplaceurPersonnage dp = new DeplaceurNormal();
        switch (dir) {
            case 0 -> dp.deplacerHaut(p);
            case 1 -> dp.deplacerBas(p);
            case 2 -> dp.deplacerGauche(p);
            case 3 -> dp.deplacerDroite(p);
        }
    }

    public void tirer() {

    }
}
