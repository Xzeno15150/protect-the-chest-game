package model.IA;

import javafx.application.Platform;
import model.Manager;
import model.collisions.Collisionneur;
import model.collisions.CollisionneurSimple;
import model.deplacement.DeplaceurDroite;
import model.deplacement.DeplaceurNormal;
import model.deplacement.DeplaceurNormalVitesse1;
import model.metier.*;
import model.observers.Observer;

import java.util.List;

public class IASimple implements IA, Observer {
    private final List<Entite> lesEntites;
    private final Manager m;
    private final Obstacle coffre;
    private final DeplaceurNormal deplaceur;

    public IASimple(Manager m, Collisionneur collisionneur){
        this.m=m;
        lesEntites= m.getMonde().getLesEntites();
        coffre= m.getMonde().getCoffre();
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
        if (p.getX() + (p.getLargeur() / 2) < coffre.getX() + (coffre.getLargeur() / 2) && deplaceur.deplacerBas(p)) {
            if(deplaceur.deplacerDroite(p));
                return;
        }
        if (p.getX() + (p.getLargeur() / 2) > coffre.getX() + (coffre.getLargeur() / 2) && deplaceur.deplacerBas(p)) {
            if(deplaceur.deplacerGauche(p));
                return;
        }
        if (p.getY() + (p.getHauteur() / 2) < coffre.getY() + (coffre.getHauteur() / 2)){
            if(deplaceur.deplacerBas(p))
                return;
            else deplaceur.deplacerGauche(p);
        }
        if(p.getY()+(p.getHauteur()/2)  > coffre.getY()+(coffre.getHauteur()/2)) {
            if(deplaceur.deplacerHaut(p))
                return;
            else deplaceur.deplacerDroite(p);
        }
    }

    @Override
    public void update() {
        Platform.runLater(this::gererEnnemis);
    }
}