package modele.deplaceurs.personnages;

import modele.personnages.Personnage;

public class DeplaceurNormal implements DeplaceurPersonnage {

    private static final int VITESSE = 1;

    public void deplacerVers(Personnage perso, int x, int y) {
        perso.setPos(x, y);
    }

    @Override
    public void deplacerDroite(Personnage perso) {
        perso.setPos(perso.getHitbox().getPosX() + VITESSE, perso.getHitbox().getPosY());
    }
    @Override
    public void deplacerGauche(Personnage personnage) {
        personnage.setPos(personnage.getHitbox().getPosX() - VITESSE, personnage.getHitbox().getPosY());
    }
    @Override
    public void deplacerHaut(Personnage personnage) {
        personnage.setPos(personnage.getHitbox().getPosX(), personnage.getHitbox().getPosY() - VITESSE);
    }
    @Override
    public void deplacerBas(Personnage personnage) {
        personnage.setPos(personnage.getHitbox().getPosX(), personnage.getHitbox().getPosY() + VITESSE);
    }
}
