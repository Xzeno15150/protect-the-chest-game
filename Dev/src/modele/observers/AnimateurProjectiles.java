package modele.observers;

import controllers.Manager;
import javafx.application.Platform;
import launch.Launcher;
import modele.collisions.CollisionneurProjectiles;
import modele.personnages.Ennemi;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

public class AnimateurProjectiles implements ObservateurBoucle{

    private final Manager mgr = Launcher.getManager();

    @Override
    public void update() {
        Object obj=null;
        for (Projectile p : mgr.getMonde().getLesProjectiles()) {
            if (!CollisionneurProjectiles.isOut(p.getHitbox(), 0, mgr.getMonde().getLongueur(), mgr.getMonde().getHauteur()) && (obj=CollisionneurProjectiles.isCollision(p.getHitbox())) == null) {
                Platform.runLater(
                        () -> p.getHitbox().setPosY(p.getHitbox().getPosY() - p.getVitesse())
                );
            }
            else{
                //if(obj.getClass()==Ennemi.class)

                Platform.runLater(
                        () -> mgr.getMonde().removeProjectile(p)
                        //mgr.getMonde().getLesPersonnages().get(obj).setSante(Sante-p.getDegats());
                );
            }
        }
    }
}
