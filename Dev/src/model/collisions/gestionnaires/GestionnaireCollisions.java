package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GestionnaireCollisions {
    protected List<Entite> aTuer;
    protected Collisionneur collisionneur;
    protected Manager manager;

    public GestionnaireCollisions(Collisionneur collisionneur, Manager manager){
        this.collisionneur = collisionneur;
        this.manager = manager;
    }

    public boolean isCollision(Entite entite, double vitesse) {
        aTuer = new ArrayList<>();
        for (Entite e : manager.getMonde().getLesEntites()) {
            if (!e.equals(entite)){
                if (isDirectionCollision(entite, e, vitesse)) {
                    if(entite instanceof Ennemi){
                        if(e.equals(manager.getMonde().getPersonnagePrincipal()) || e.equals(manager.getMonde().getCoffre())) {
                            manager.retirerVie();
                        }
                        aTuer.add(entite);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public List<Entite> getEntiteATuer(){
        return aTuer;
    }

    protected abstract boolean isDirectionCollision(Entite entite, Entite e, double vitesse);
}
