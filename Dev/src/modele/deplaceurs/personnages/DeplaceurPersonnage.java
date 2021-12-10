package modele.deplaceurs.personnages;

import modele.personnages.Personnage;

public interface DeplaceurPersonnage {
    void deplacerVers(Personnage perso, int x, int y);
    void deplacerDe(Personnage personnage, int x, int y);
}
