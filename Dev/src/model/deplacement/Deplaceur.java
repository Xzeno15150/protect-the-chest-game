package model.deplacement;

import model.metier.Entite;

public interface Deplaceur {
    boolean deplacerHaut(Entite e);
    boolean deplacerBas(Entite e);
    boolean deplacerGauche(Entite e);
    boolean deplacerDroite(Entite e);
}
