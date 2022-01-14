package model.deplacement;

import model.collisions.Collisionneur;
import model.collisions.gestionnaires.*;
import model.metier.Entite;
import model.metier.Monde;

public abstract class DeplaceurNormal implements DeplaceurDroite, DeplaceurHaut, DeplaceurGauche, DeplaceurBas {

    private Monde monde;
    private Collisionneur collisionneur;

    public DeplaceurNormal(Collisionneur collisionneur, Monde monde) {
        this.monde = monde;
        this.collisionneur = collisionneur;
    }

    @Override
    public boolean deplacerHaut(Entite e) {
        var gestionnaire = new GestionnaireCollisionsHaut(collisionneur, monde);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setY(e.getY() - getVitesse());
            return true;
        }
        else return false;
    }

    @Override
    public boolean deplacerBas(Entite e) {
        var gestionnaire = new GestionnaireCollisionsBas(collisionneur, monde);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setY(e.getY() + getVitesse());
            return true;
        }
        else return false;
    }

    @Override
    public boolean deplacerGauche(Entite e) {
        var gestionnaire = new GestionnaireCollisionsGauche(collisionneur, monde);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setX(e.getX() - getVitesse());
            return true;
        }
        else return false;
    }

    @Override
    public boolean deplacerDroite(Entite e) {
        var gestionnaire = new GestionnaireCollisionsDroite(collisionneur, monde);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setX(e.getX() + getVitesse());
            return true;
        }
        else return false;
    }

    public abstract double getVitesse() ;
}
