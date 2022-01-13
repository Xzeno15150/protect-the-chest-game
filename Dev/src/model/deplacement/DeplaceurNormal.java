package model.deplacement;

import model.collisions.Collisionneur;
import model.collisions.gestionnaires.*;
import model.metier.Entite;
import model.metier.Monde;

public class DeplaceurNormal implements Deplaceur{

    private static final double VITESSE = 1;
    private Monde monde;
    private Collisionneur collisionneur;

    public DeplaceurNormal(Collisionneur collisionneur, Monde monde) {
        this.monde = monde;
        this.collisionneur = collisionneur;
    }

    @Override
    public void deplacerHaut(Entite e) {
        var gestionnaire = new GestionnaireCollisionsHaut(collisionneur, monde);
        if (!gestionnaire.isCollision(e, VITESSE)) {
            e.setY(e.getY() - VITESSE);
        }
    }

    @Override
    public void deplacerBas(Entite e) {
        var gestionnaire = new GestionnaireCollisionsBas(collisionneur, monde);
        if (!gestionnaire.isCollision(e, VITESSE)) {
            e.setY(e.getY() + VITESSE);
        }
    }

    @Override
    public void deplacerGauche(Entite e) {
        var gestionnaire = new GestionnaireCollisionsGauche(collisionneur, monde);
        if (!gestionnaire.isCollision(e, VITESSE)) {
            e.setX(e.getX() - VITESSE);
        }
    }

    @Override
    public void deplacerDroite(Entite e) {
        var gestionnaire = new GestionnaireCollisionsDroite(collisionneur, monde);
        if (!gestionnaire.isCollision(e, VITESSE)) {
            e.setX(e.getX() + VITESSE);
        }
    }
}
