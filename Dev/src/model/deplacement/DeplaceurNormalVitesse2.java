package model.deplacement;

import model.collisions.Collisionneur;
import model.deplacement.DeplaceurNormal;
import model.metier.Monde;

public class DeplaceurNormalVitesse2 extends DeplaceurNormal {
    public DeplaceurNormalVitesse2(Collisionneur collisionneur, Monde m) {
        super(collisionneur, m);
    }

    @Override
    public double getVitesse() {
        return 2;
    }


}
