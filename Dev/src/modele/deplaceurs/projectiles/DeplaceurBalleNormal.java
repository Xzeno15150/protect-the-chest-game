package modele.deplaceurs.projectiles;

import modele.deplaceurs.projectiles.DeplaceurProjectile;
import modele.projectiles.Projectile;

public class DeplaceurBalleNormal implements DeplaceurProjectile {
    private final int VITESSE = 2;

    @Override
    public void deplacerDroite(Projectile p) {
        p.getHitbox().setPosX(p.getHitbox().getPosX() + VITESSE);
    }

    @Override
    public void deplacerGauche(Projectile p) {
        p.getHitbox().setPosX(p.getHitbox().getPosX() - VITESSE);
    }

    @Override
    public void deplacerHaut(Projectile p) {
        p.getHitbox().setPosY(p.getHitbox().getPosX() - VITESSE);
    }

    @Override
    public void deplacerBas(Projectile p) {
        p.getHitbox().setPosY(p.getHitbox().getPosX() + VITESSE);
    }
}
