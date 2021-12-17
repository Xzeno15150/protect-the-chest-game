package controllers;

import data.LoaderMonde;
import data.Stub;
import modele.Monde;
import modele.collisions.Hitbox;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.personnages.Personnage;
import modele.personnages.PersonnagePrincipal;

public class Manager {

    // Attributes
    private Monde monde;
    private Personnage personnagePrincipal;

    public Manager() {
        startGame();
    }


    // Getter/Setter
    public Monde getMonde() {
        return monde;
    }
    public Personnage getPersonnagePrincipal() {
        return personnagePrincipal;
    }

    // Methods

    private void startGame() {
        LoaderMonde loaderMonde = new Stub();
        monde = loaderMonde.load();
        personnagePrincipal = monde.getLesPersonnages().get(0);
    }

    public void deplacerPersonnage(Personnage p, int dir){
        DeplaceurPersonnage dp = new DeplaceurNormal();
        switch (dir) {
            case 0 -> dp.deplacerHaut(p, monde.getLongueur(), monde.getHauteur());
            case 1 -> dp.deplacerBas(p, monde.getLongueur(), monde.getHauteur());
            case 2 -> dp.deplacerGauche(p, monde.getLongueur(), monde.getHauteur());
            case 3 -> dp.deplacerDroite(p, monde.getLongueur(), monde.getHauteur());
        }
    }

    public void tirer() {

    }
}
