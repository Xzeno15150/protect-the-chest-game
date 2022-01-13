package model.collisions.gestionnaires;

import model.collisions.Collisionneur;
import model.metier.Entite;
import model.metier.Monde;

public class GestionnaireCollisionsHaut extends GestionnaireCollisions{
    public GestionnaireCollisionsHaut(Collisionneur collisionneur, Monde monde) {
        super(collisionneur, monde);
    }

    @Override
    protected boolean isDirectionCollision(Entite entite, Entite e, double vitesse) {
        return collisionneur.isCollision(entite.getX(), entite.getY() - vitesse, entite.getX() + entite.getLargeur(), entite.getY() + entite.getHauteur() - vitesse, e.getX(), e.getY(), e.getX()+e.getLargeur(), e.getY()+e.getHauteur());
    }
}
