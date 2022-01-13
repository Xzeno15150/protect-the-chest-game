package model.observers;

import javafx.application.Platform;
import model.Manager;
import model.collisions.Collisionneur;
import model.collisions.gestionnaires.GestionnaireCollisionsHaut;
import model.deplacement.Deplaceur;
import model.metier.Entite;
import model.metier.Projectile;

public class AnimateurProjectile implements Observer, Deplaceur {

    private static final int VITESSE = 3;

    private final Manager mgr;
    private final Collisionneur collisionneur;

    public AnimateurProjectile(Collisionneur collisionneur, Manager mgr) {
        this.mgr = mgr;
        this.collisionneur = collisionneur;
    }

    @Override
    public void update() {
        for (Entite e : mgr.getMonde().getLesEntites()) {
            if (e instanceof Projectile) {
                Platform.runLater(() -> deplacerHaut(e));
            }
        }
    }

    @Override
    public void deplacerHaut(Entite e) {
        var gestionnaire = new GestionnaireCollisionsHaut(collisionneur, mgr.getMonde());
        if (!gestionnaire.isCollision(e, VITESSE)) {
            e.setY(e.getY() - VITESSE);
        }
        else {
            mgr.getMonde().getLesEntites().remove(e);
        }
    }

    @Override
    public void deplacerBas(Entite e) {
    }

    @Override
    public void deplacerGauche(Entite e){
    }

    @Override
    public void deplacerDroite(Entite e){
    }
}
