package model.deplacement;

import jdk.jshell.spi.ExecutionControl;
import model.metier.Entite;

public interface Deplaceur {
    void deplacerHaut(Entite e);
    void deplacerBas(Entite e);
    void deplacerGauche(Entite e);
    void deplacerDroite(Entite e);
}
