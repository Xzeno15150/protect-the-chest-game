package modele.deplaceurs.personnages;

import modele.personnages.Personnage;

public class DeplaceurNormal implements DeplaceurPersonnage {

    public void deplacerVers(Personnage perso, int x, int y) {
        perso.setPos(x, y);
    }

    @Override
    public void deplacerDe(Personnage perso, int x, int y) {
        perso.setPos(perso.getPosX() + x, perso.getPosY() + y);
    }
}
