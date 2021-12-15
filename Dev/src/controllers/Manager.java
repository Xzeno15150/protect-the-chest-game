package controllers;

import modele.Monde;
import modele.collisions.Hitbox;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.personnages.Personnage;
import modele.personnages.PersonnagePrincipal;

public class Manager {

    // Attributes
    private final Monde monde;
    private final Personnage personnagePrincipal;

    // Constructor
    public Manager(Monde monde) {
        this.monde = monde;
        //personnagePrincipale = monde.getLesPersonnages().get(0);
        personnagePrincipal = new PersonnagePrincipal("", 20, new Hitbox(100, 200, 200));
    }

    // Getter/Setter
    public Monde getMonde() {
        return monde;
    }
    public Personnage getPersonnagePrincipal() {
        return personnagePrincipal;
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
