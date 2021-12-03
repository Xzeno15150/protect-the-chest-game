package modele.deplaceurs.projectiles;

import modele.projectiles.Projectile;

public interface DeplaceurProjectile {
    void move(Projectile p, int dir);
}
