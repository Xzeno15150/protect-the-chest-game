package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.Entite;
import model.metier.Monde;

/**
 * Gestionnaire de collisions vers la droite
 */
public class GestionnaireCollisionsDroite extends GestionnaireCollisions{
    /**
     * constructeur renvoie au GestionnaireCollisions
     * @param collisionneur Collisionneur utilisé pour tester les collisions
     * @param manager Manager de l'application
     */
    public GestionnaireCollisionsDroite(Collisionneur collisionneur, Manager manager) {
        super(collisionneur, manager);
    }

    /**
     * Test les collisions entre les entités vers la droite
     * @param entite1 Entité qui veut se déplacer
     * @param entite2 Entité sur qui tester s'il y a collision
     * @param vitesse vitesse de déplacement
     * @return True s'il y a collisions entre les entité, false sinon
     */
    @Override
    protected boolean isDirectionCollision(Entite entite1, Entite entite2, double vitesse) {
        return collisionneur.isCollision(entite1.getX() + vitesse, entite1.getY(), entite1.getX() + entite1.getLargeur() + vitesse, entite1.getY() + entite1.getHauteur(), entite2.getX(), entite2.getY(), entite2.getX()+ entite2.getLargeur(), entite2.getY()+ entite2.getHauteur());
    }
}
