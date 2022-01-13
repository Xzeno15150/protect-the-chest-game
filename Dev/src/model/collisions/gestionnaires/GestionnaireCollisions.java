package model.collisions.gestionnaires;

import model.collisions.Collisionneur;
import model.metier.Entite;
import model.metier.Monde;

public abstract class GestionnaireCollisions {

    protected Collisionneur collisionneur;
    protected Monde monde;

    public GestionnaireCollisions(Collisionneur collisionneur, Monde monde){
        this.collisionneur = collisionneur;
        this.monde = monde;
    }

    public boolean isCollision(Entite entite, double vitesse) {
        for (Entite e : monde.getLesEntites()) {
            if (!e.equals(entite)){
                if (isDirectionCollision(entite, e, vitesse)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected abstract boolean isDirectionCollision(Entite entite, Entite e, double vitesse);
}
