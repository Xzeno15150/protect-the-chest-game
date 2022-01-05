package modele.deplaceurs.personnages;

import modele.collisions.Collisionneur;
import modele.personnages.Personnage;

public class DeplaceurNormal implements DeplaceurPersonnage {

    private static final int VITESSE = 8;

    public void deplacerVers(Personnage perso, int x, int y) {
        perso.setPos(x, y);
    }

    @Override
    public void deplacerDroite(Personnage perso, double longueur, double hauteur) {
        if(!Collisionneur.isOut(perso.getHitbox(), 3, longueur, hauteur)) {
            perso.setPos(perso.getHitbox().getPosX() + VITESSE, perso.getHitbox().getPosY());
        }
    }
    @Override
    public void deplacerGauche(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(), 2, longueur, hauteur)) {
            personnage.setPos(personnage.getHitbox().getPosX() - VITESSE, personnage.getHitbox().getPosY());
        }
    }
    @Override
    public void deplacerHaut(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(),0,  longueur, hauteur)){
            personnage.setPos(personnage.getHitbox().getPosX(), personnage.getHitbox().getPosY() - VITESSE);
        }
    }
    @Override
    public void deplacerBas(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(), 1, longueur, hauteur)){
            personnage.setPos(personnage.getHitbox().getPosX(), personnage.getHitbox().getPosY() + VITESSE);
        }
    }
}
