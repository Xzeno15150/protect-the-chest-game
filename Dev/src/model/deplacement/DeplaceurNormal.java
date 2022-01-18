package model.deplacement;

import model.Manager;
import model.collisions.Collisionneur;
import model.collisions.gestionnaires.*;
import model.metier.Entite;
import model.metier.Monde;

public abstract class DeplaceurNormal implements DeplaceurDroite, DeplaceurHaut, DeplaceurGauche, DeplaceurBas {

    private final Manager manager;
    private final Collisionneur collisionneur;

    public DeplaceurNormal(Collisionneur collisionneur, Manager manager) {
        this.manager = manager;
        this.collisionneur = collisionneur;
    }

    @Override
    public boolean deplacerHaut(Entite e) {
        var gestionnaire = new GestionnaireCollisionsHaut(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setY(e.getY() - getVitesse());
            return true;
        }
        return false;
    }

    @Override
    public boolean deplacerBas(Entite e) {
        var gestionnaire = new GestionnaireCollisionsBas(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setY(e.getY() + getVitesse());
            return true;
        }
        return false;
    }

    @Override
    public boolean deplacerGauche(Entite e) {
        var gestionnaire = new GestionnaireCollisionsGauche(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setX(e.getX() - getVitesse());
            return true;
        }
        return false;
    }

    @Override
    public boolean deplacerDroite(Entite e) {
        var gestionnaire = new GestionnaireCollisionsDroite(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setX(e.getX() + getVitesse());
            return true;
        }
        return false;
    }

    public abstract double getVitesse() ;
}
