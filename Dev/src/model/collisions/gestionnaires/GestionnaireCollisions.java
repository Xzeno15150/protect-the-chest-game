package model.collisions.gestionnaires;

import model.Manager;
import model.collisions.Collisionneur;
import model.metier.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de gestion des collisions entre une entité et toutes les autres
 */
public abstract class GestionnaireCollisions {
    protected List<Entite> aTuer;
    protected Collisionneur collisionneur;
    protected Manager manager;

    /**
     * Constructeur du gestionnaire de collisions
     * @param collisionneur Collisionneur utilisé pour tester les collisions
     * @param manager Manager de l'application
     */
    public GestionnaireCollisions(Collisionneur collisionneur, Manager manager){
        this.collisionneur = collisionneur;
        this.manager = manager;
    }

    /**
     * Vérifie s'il y a une collisions dans la direction donnée par la fille
     * @param entite Entité que l'on veut déplacer
     * @param vitesse vitesse de déplacement
     * @return true s'il y a collisions avec une autre entité, false sinon
     */
    public boolean isCollision(Entite entite, double vitesse) {
        aTuer = new ArrayList<>();
        for (Entite e : manager.getMonde().getLesEntites()) {
            if (!e.equals(entite)){
                if (isDirectionCollision(entite, e, vitesse)) {
                    if(entite instanceof Ennemi){
                        if(e.equals(manager.getMonde().getPersonnagePrincipal()) || e.equals(manager.getMonde().getCoffre())) {
                            manager.retirerVie();
                            aTuer.add(entite);
                        }
                    }
                    if(entite instanceof Projectile && e instanceof Ennemi){
                        aTuer.add(e);
                    }
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Test s'il y a collisions entre deux entité dans la direction donnée par les filles
     * @param entite1 Entité qui veut se déplacer
     * @param entite2 Entité sur qui tester s'il y a collision
     * @param vitesse vitesse de déplacement
     * @return True s'il y a collisions entre les entité, false sinon
     */
    protected abstract boolean isDirectionCollision(Entite entite1, Entite entite2, double vitesse);

    public List<Entite> getEntiteATuer(){
        return aTuer;
    }
}
