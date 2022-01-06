package modele.observers;

import controllers.Manager;
import javafx.application.Platform;
import launch.Launcher;
import modele.collisions.CollisionneurProjectiles;
import modele.projectiles.Projectile;

public class AnimateurProjectiles implements ObservateurBoucle{

    private final Manager mgr = Launcher.getManager();

    @Override
    public void update() {
        for (Projectile p : mgr.getMonde().getLesProjectiles()) {
            if (!CollisionneurProjectiles.isOut(p.getHitbox(), 0, mgr.getMonde().getLongueur(), mgr.getMonde().getHauteur())) {
                Platform.runLater(() -> p.getHitbox().setPosY(p.getHitbox().getPosY() - p.getVitesse()));
            }
        }
    }
}
