package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.Entite;
import model.metier.Monde;

public abstract class GestionnaireCollisions {

    protected Collisionneur collisionneur;
    protected Manager manager;

    public GestionnaireCollisions(Collisionneur collisionneur, Manager manager){
        this.collisionneur = collisionneur;
        this.manager = manager;
    }

    public boolean isCollision(Entite entite, double vitesse) {
        for (Entite e : manager.getMonde().getLesEntites()) {
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
