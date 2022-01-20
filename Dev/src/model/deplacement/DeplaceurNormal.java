package model.deplacement;

import model.Manager;
import model.collisions.Collisionneur;
import model.collisions.gestionnaires.*;
import model.metier.Entite;
import model.metier.Monde;

import java.util.ArrayList;
import java.util.List;

/**
 * Déplaceur classique du jeu, qui déplace l'entité d'un pas donné s'il n'y a pas de collisions
 */
public abstract class DeplaceurNormal implements DeplaceurDroite, DeplaceurHaut, DeplaceurGauche, DeplaceurBas {

    private final Manager manager;
    private final Collisionneur collisionneur;
    private List<Entite> aTuer;

    /**
     * Constructeur de la classe DeplaceurNormal
     * @param collisionneur Collisionneur à utiliser pour gérer les collisions
     * @param manager Manager de l'application
     */
    public DeplaceurNormal(Collisionneur collisionneur, Manager manager) {
        this.manager = manager;
        this.collisionneur = collisionneur;
        aTuer=new ArrayList<>();
    }

    /**
     * Deplacer une entite vers le haut
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    @Override
    public boolean deplacerHaut(Entite e) {
        var gestionnaire = new GestionnaireCollisionsHaut(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setY(e.getY() - getVitesse());
            return true;
        }
        aTuer= gestionnaire.getEntiteATuer();
        return false;
    }

    /**
     * Deplacer une entite vers le bas
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    @Override
    public boolean deplacerBas(Entite e) {
        var gestionnaire = new GestionnaireCollisionsBas(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setY(e.getY() + getVitesse());
            return true;
        }
        aTuer= gestionnaire.getEntiteATuer();
        return false;
    }

    /**
     * Deplacer une entite vers la gauche
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    @Override
    public boolean deplacerGauche(Entite e) {
        var gestionnaire = new GestionnaireCollisionsGauche(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setX(e.getX() - getVitesse());
            return true;
        }
        aTuer= gestionnaire.getEntiteATuer();
        return false;
    }

    /**
     * Deplacer une entite vers la droite
     * @param e Entité à déplacer
     * @return True si le déplacement s'est effectué, false s'il y a eu collision
     */
    @Override
    public boolean deplacerDroite(Entite e) {
        var gestionnaire = new GestionnaireCollisionsDroite(collisionneur, manager);
        if (!gestionnaire.isCollision(e, getVitesse())) {
            e.setX(e.getX() + getVitesse());
            return true;
        }
        aTuer= gestionnaire.getEntiteATuer();
        return false;
    }

    /**
     * Retourne la liste des entités à tuer
     * @return La liste avec les entités à tuer
     */
    public List<Entite> getATuer(){
        return aTuer;
    }

    /**
     * Retourne la vitesse de déplacement de l'entité
     * @return Retourne la vitesse de déplacement
     */
    public abstract double getVitesse() ;
}
