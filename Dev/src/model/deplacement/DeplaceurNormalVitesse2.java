package model.deplacement;

import model.Manager;
import model.collisions.Collisionneur;
import model.deplacement.DeplaceurNormal;
import model.metier.Monde;

public class DeplaceurNormalVitesse2 extends DeplaceurNormal {
    public DeplaceurNormalVitesse2(Collisionneur collisionneur, Manager m) {
        super(collisionneur, m);
    }

    @Override
    public double getVitesse() {
        return 2;
    }


}
