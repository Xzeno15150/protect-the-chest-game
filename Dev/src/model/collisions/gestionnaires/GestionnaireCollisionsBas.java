package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.Entite;
import model.metier.Monde;

public class GestionnaireCollisionsBas extends GestionnaireCollisions{
    public GestionnaireCollisionsBas(Collisionneur collisionneur, Manager manager) {
        super(collisionneur, manager);
    }

    @Override
    protected boolean isDirectionCollision(Entite entite, Entite e, double vitesse) {
        return collisionneur.isCollision(entite.getX(), entite.getY() + vitesse, entite.getX() + entite.getLargeur(), entite.getY() + entite.getHauteur() + vitesse, e.getX(), e.getY(), e.getX()+e.getLargeur(), e.getY()+e.getHauteur());
    }
}
