package modele.deplaceurs.personnages;

import modele.personnages.Personnage;

public interface DeplaceurPersonnage {
    void deplacerVers(Personnage perso, int x, int y);
    void deplacerDroite(Personnage personnage, double longueur, double largeur);
    void deplacerGauche(Personnage personnage, double longueur, double largeur);
    void deplacerHaut(Personnage personnage, double longueur, double largeur);
    void deplacerBas(Personnage personnage, double longueur, double largeur);
}

