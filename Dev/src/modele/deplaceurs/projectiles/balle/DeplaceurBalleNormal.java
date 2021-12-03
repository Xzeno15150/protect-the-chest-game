package modele.deplaceurs.projectiles.balle;

import modele.deplaceurs.projectiles.DeplaceurProjectile;
import modele.projectiles.Projectile;

public class DeplaceurBalleNormal implements DeplaceurProjectile {
    private int vitesse_balle = 1;

    @Override
    public void move(Projectile p, int dir) {
        switch (dir) {
            default :
                    p.setPosY(p.getPosY() + vitesse_balle * 10);
        }
    }
}
