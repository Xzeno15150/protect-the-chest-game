package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GestionnaireCollisions {

    protected Collisionneur collisionneur;
    protected Manager manager;

    public GestionnaireCollisions(Collisionneur collisionneur, Manager manager){
        this.collisionneur = collisionneur;
        this.manager = manager;
    }

    public boolean isCollision(Entite entite, double vitesse) {
        List<Entite> aTuer = new ArrayList<>();
        boolean collision= false;
        for (Entite e : manager.getMonde().getLesEntites()) {
            if (!e.equals(entite)){
                if (isDirectionCollision(entite, e, vitesse)) {
                    if(entite instanceof Ennemi){
                        if(e instanceof Projectile){
                            aTuer.add(entite);
                        }
                        if(e instanceof Personnage)
                            aTuer.add(entite);
                    }
                    collision= true;
                }
            }
        }
        for (Entite e :  aTuer){
            manager.tuer((Ennemi) e);
        }
        return collision;
    }

    protected abstract boolean isDirectionCollision(Entite entite, Entite e, double vitesse);
}
