package model.IA;

import javafx.application.Platform;
import model.collisions.Collisionneur;
import model.deplacement.DeplaceurDroite;
import model.deplacement.DeplaceurNormal;
import model.deplacement.DeplaceurNormalVitesse1;
import model.metier.*;
import model.observers.Observer;

import java.util.List;

public class IASimple implements IA, Observer {
    private List<Entite> lesEntites;
    private Monde m;
    private Obstacle coffre;
    private DeplaceurNormal deplaceur;

    public IASimple(Monde m, Collisionneur collisionneur){
        this.m=m;
        lesEntites= m.getLesEntites();
        coffre= m.getCoffre();
        deplaceur= new DeplaceurNormalVitesse1(collisionneur,m);
    }

    @Override
    public void gererEnnemis(){
        for(Entite e : lesEntites) {
            if(e instanceof Ennemi){
                deplacerEnnemis((Personnage) e);
            }
        }
    }

    private void deplacerEnnemis(Personnage p) {
        if (p.getX() + (p.getLargeur() / 2) < coffre.getX() + (coffre.getLargeur() / 2)) {
            deplaceur.deplacerDroite(p);
        }
        if (p.getX() + (p.getLargeur() / 2) > coffre.getX() + (coffre.getLargeur() / 2)) {
            deplaceur.deplacerGauche(p);
        }
        if (p.getY() + (p.getHauteur() / 2) < coffre.getY() + (coffre.getHauteur() / 2)){
            deplaceur.deplacerBas(p);
        }
        if(p.getY()+(p.getHauteur()/2)  > coffre.getY()+(coffre.getHauteur()/2)) {
            deplaceur.deplacerHaut(p);
        }
    }

    @Override
    public void update() {
        Platform.runLater(this::gererEnnemis);
    }
}