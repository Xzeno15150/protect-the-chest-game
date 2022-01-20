package model.IA;

import javafx.application.Platform;
import model.Manager;
import model.collisions.Collisionneur;
import model.collisions.CollisionneurSimple;
import model.deplacement.DeplaceurDroite;
import model.deplacement.DeplaceurNormal;
import model.deplacement.DeplaceurNormalVitesse1;
import model.metier.*;
import model.observers.Observer;

import java.util.List;

/**
 * IASimple permet de deplacer les ennemis et se déclenche grâce à Observer
 */
public class IASimple implements IA, Observer {
    private final List<Entite> lesEntites;
    private final Manager m;
    private final Obstacle coffre;
    private final DeplaceurNormal deplaceur;

    /**
     * constructeur de IASimple qui récupere la liste des Entite de Monde et instancie un deplaceur pour les ennemis
     * @param m Manager m permet de récupérere la liste des Entite
     * @param collisionneur Collisionneur collisionneur permet de créer un DeplaceurNormalVitesse1 pour les ennemis
     */
    public IASimple(Manager m, Collisionneur collisionneur){
        this.m=m;
        lesEntites= m.getMonde().getLesEntites();
        coffre= m.getMonde().getCoffre();
        deplaceur= new DeplaceurNormalVitesse1(collisionneur,m);

    }

    /**
     * gererEnnemis parcours la liste des Entite et lorsqu'une Entite est un Ennemi, elle appelle deplacerEnnemis. Elle recupère aussi la liste des Ennemi à tuer pour les tuer.
     */
    @Override
    public void gererEnnemis(){
        for(Entite e : lesEntites) {
            if(e instanceof Ennemi){
                deplacerEnnemis((Personnage) e);
            }
        }
        for (Entite e: deplaceur.getATuer()) {
            m.tuer((Ennemi) e);
        }
    }

    /**
     * deplacerEnnemis choisie en fonction de la position de l'Ennemi et de ses collisions ou il doit se déplacer
     * @param p Personnage p est l'Ennemi à déplacer
     */
    private void deplacerEnnemis(Personnage p) {
        if (p.getX() + (p.getLargeur() / 2) < coffre.getX() + (coffre.getLargeur() / 2) && deplaceur.deplacerBas(p)) {
            if(deplaceur.deplacerDroite(p))
                return;
        }
        if (p.getX() + (p.getLargeur() / 2) > coffre.getX() + (coffre.getLargeur() / 2) && deplaceur.deplacerBas(p)) {
            if(deplaceur.deplacerGauche(p))
                return;
        }
        if (p.getY() + (p.getHauteur() / 2) < coffre.getY() + (coffre.getHauteur() / 2)){
            if(deplaceur.deplacerBas(p))
                return;
            else deplaceur.deplacerGauche(p);
        }
        if(p.getY()+(p.getHauteur()/2)  > coffre.getY()+(coffre.getHauteur()/2)) {
            if(!deplaceur.deplacerHaut(p))
                deplaceur.deplacerDroite(p);
        }
    }

    /**
     * update est appellé à chaque tour de la boucle de jeu, elle appelle gererEnnemis
     */
    @Override
    public void update() {
        Platform.runLater(this::gererEnnemis);
    }
}