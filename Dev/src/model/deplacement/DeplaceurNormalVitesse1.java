package model.deplacement;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.Monde;

/**
 * DéplaceurNormal qui possède un pas de 1
 */
public class DeplaceurNormalVitesse1 extends DeplaceurNormal {
    /**
     * Constructeur de la classe DeplaceurNormalVitese1
     * @param collisionneur Collisionneur à utiliser pour gérer les collisions
     * @param manager Manager de l'application
     */
    public DeplaceurNormalVitesse1(Collisionneur collisionneur, Manager manager) {
        super(collisionneur, manager);
    }

    /**
     * Renvoie la vitesse de déplacement
     * @return Retourne 1
     */
    @Override
    public double getVitesse() {
        return 1;
    }
}
