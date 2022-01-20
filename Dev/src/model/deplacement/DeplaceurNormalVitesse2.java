package model.deplacement;

import model.Manager;
import model.collisions.Collisionneur;
import model.deplacement.DeplaceurNormal;
import model.metier.Monde;

/**
 * DéplaceurNormal qui possède un pas de 2
 */
public class DeplaceurNormalVitesse2 extends DeplaceurNormal {
    /**
     * Constructeur de la classe DeplaceurNormalVitese2
     * @param collisionneur Collisionneur à utiliser pour gérer les collisions
     * @param manager Manager de l'application
     */
    public DeplaceurNormalVitesse2(Collisionneur collisionneur, Manager manager) {
        super(collisionneur, manager);
    }

    /**
     * Renvoie la vitesse de déplacement
     * @return Retourne 2
     */
    @Override
    public double getVitesse() {
        return 2;
    }


}
