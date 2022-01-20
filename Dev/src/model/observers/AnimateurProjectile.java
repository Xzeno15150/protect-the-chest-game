package model.observers;

import javafx.application.Platform;
import model.Manager;
import model.collisions.Collisionneur;
import model.collisions.gestionnaires.GestionnaireCollisionsHaut;
import model.deplacement.DeplaceurHaut;
import model.metier.Ennemi;
import model.metier.Entite;
import model.metier.Projectile;

/**
 * AnimateurProjectile permet la gestion du déplacement et de la vie des projectiles
 */
public class AnimateurProjectile implements Observer, DeplaceurHaut {

    private static final int VITESSE = 3;

    private final Manager mgr;
    private final Collisionneur collisionneur;

    /**
     * constructeur qui recupere le Manager et le Collisionneur
     * @param collisionneur Collisionneur collisionneur qui permet de savoir si le projectile est en collision ou non
     * @param mgr Manager mgr qui permet de récuperer la liste des Entite
     */
    public AnimateurProjectile(Collisionneur collisionneur, Manager mgr) {
        this.mgr = mgr;
        this.collisionneur = collisionneur;
    }

    /**
     * update permet d'appeler deplacerHaut pour chaque projectile à chaque tour de boucle
     */
    @Override
    public void update() {
        for (Entite e : mgr.getMonde().getLesEntites()) {
            if (e instanceof Projectile) {
                Platform.runLater(() -> deplacerHaut(e));
            }
        }
    }

    /**
     * deplacerHaut permet de deplacer verticalement un projectile si c'est possible et recupere la liste des projectiles à tuer
     * @param e Entite e est le projectile à deplacer
     * @return retourne un boolean : true si le déplacement c'est fait, false sinon
     */
    @Override
    public boolean deplacerHaut(Entite e) {
        var gestionnaire = new GestionnaireCollisionsHaut(collisionneur, mgr);
        if (!gestionnaire.isCollision(e, VITESSE)) {
            e.setY(e.getY() - VITESSE);
            return true;
        }
        else {
            for (Entite aTuer : gestionnaire.getEntiteATuer()){
                mgr.tuer((Ennemi) aTuer);
            }
            mgr.getMonde().getLesEntites().remove(e);
            return false;
        }
    }
}
