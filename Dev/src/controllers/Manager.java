package controllers;

import modele.Monde;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.personnages.Personnage;

public class Manager {

    // Attributes
    private Monde monde;

    // Constructor
    public Manager(Monde monde) {
        this.monde = monde;
    }

    // Getter/Setter
    public Monde getMonde() {
        return monde;
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
}
