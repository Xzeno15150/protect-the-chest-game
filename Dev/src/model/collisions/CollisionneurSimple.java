package model.collisions;

import model.metier.Entite;
import model.metier.Monde;

public class CollisionneurSimple implements Collisionneur{

    private final Monde monde;

    public CollisionneurSimple(Monde monde){
        this.monde = monde;
    }

    @Override
    public boolean isCollision(double tlx1, double tly1, double brx1, double bry1,
                                double tlx2, double tly2, double brx2, double bry2) {
        return !(tlx1 > brx2 || brx1 < tlx2 || tly1 > bry2 || bry1 < tly2) || isOut(tlx1, tly1, brx1, bry1);
    }

    private boolean isOut(double tlx, double tly, double brx, double bry) {
        return tlx < 0 || tly < 0 || brx > monde.getLargeur() || bry > monde.getHauteur();
    }
}
