package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.Entite;
import model.metier.Monde;

public class GestionnaireCollisionsGauche extends GestionnaireCollisions{

    public GestionnaireCollisionsGauche(Collisionneur collisionneur, Manager manager) {
        super(collisionneur, manager);
    }

    @Override
    protected boolean isDirectionCollision(Entite entite, Entite e, double vitesse) {
        return collisionneur.isCollision(entite.getX() - vitesse, entite.getY(), entite.getX() + entite.getLargeur() - vitesse, entite.getY() + entite.getHauteur(), e.getX(), e.getY(), e.getX()+e.getLargeur(), e.getY()+e.getHauteur());
    }
}
