package model.IA;

import model.collisions.Collisionneur;
import model.deplacement.Deplaceur;
import model.deplacement.DeplaceurNormal;
import model.metier.Entite;
import model.metier.Monde;
import model.metier.Obstacle;
import model.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

public class IA {
    private List<Entite> lesEntites;
    private Monde m;
    private Obstacle coffre;
    private Deplaceur deplaceur;

    public IA(Monde m, Collisionneur collisionneur){
        this.m=m;
        lesEntites= m.getLesEntites();
        coffre= m.getCoffre();
        deplaceur= new DeplaceurNormal(collisionneur,m);
    }

    public void gererEnnemis(){
        int i=0;
        for(Entite e : lesEntites) {
            if(e.getClass() == Personnage.class &&i>1){
                deplacerEnnemis((Personnage) e, coffre);
            }
            i++;
        }
    }

    private void deplacerEnnemis(Personnage p, Obstacle coffre) {
        if (p.getX() + (p.getLargeur() / 2) < coffre.getX() + (coffre.getLargeur() / 2)) {
            deplaceur.deplacerDroite(p);
        }
        if (p.getX() + (p.getLargeur() / 2) > coffre.getX() + (coffre.getLargeur() / 2)) {
            deplaceur.deplacerGauche(p);
        }
        if (p.getY() + (p.getHauteur() / 2) < coffre.getY() + (coffre.getHauteur() / 2)){
            deplaceur.deplacerBas(p);
        }
        if(p.getY()+(p.getHauteur()/2)  > coffre.getY()+(coffre.getHauteur()/2))
                deplaceur.deplacerHaut(p);
    }
}