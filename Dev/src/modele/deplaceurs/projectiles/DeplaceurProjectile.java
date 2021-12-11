package modele.deplaceurs.projectiles;

import modele.projectiles.Projectile;

public interface DeplaceurProjectile {
    void deplacerDroite(Projectile p);
    void deplacerGauche(Projectile p);
    void deplacerHaut(Projectile p);
    void deplacerBas(Projectile p);
}
