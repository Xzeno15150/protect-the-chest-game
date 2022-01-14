package model.deplacement;

import model.collisions.Collisionneur;
import model.metier.Monde;

public class DeplaceurNormalVitesse1 extends DeplaceurNormal {
    public DeplaceurNormalVitesse1(Collisionneur collisionneur, Monde monde) {
        super(collisionneur, monde);
    }

    @Override
    public double getVitesse() {
        return 1;
    }
}
