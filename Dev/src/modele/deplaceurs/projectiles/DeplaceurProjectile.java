package modele.deplaceurs.projectiles;

import modele.projectiles.Projectile;

public interface DeplaceurProjectile {
    void deplacerVers(Projectile p, int x, int y);
    void deplacerDe(Projectile p, int x, int y);
}
