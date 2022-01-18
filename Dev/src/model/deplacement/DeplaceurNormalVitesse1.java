package model.deplacement;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.Monde;

public class DeplaceurNormalVitesse1 extends DeplaceurNormal {
    public DeplaceurNormalVitesse1(Collisionneur collisionneur, Manager manager) {
        super(collisionneur, manager);
    }

    @Override
    public double getVitesse() {
        return 1;
    }
}
