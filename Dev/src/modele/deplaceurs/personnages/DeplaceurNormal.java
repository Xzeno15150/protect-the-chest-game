package modele.deplaceurs.personnages;

import javafx.application.Platform;
import modele.collisions.Collisionneur;
import modele.personnages.Personnage;

public class DeplaceurNormal implements DeplaceurPersonnage {

    private static final int VITESSE = 3;

    public void deplacerVers(Personnage perso, int x, int y) {
        perso.setPos(x, y);
    }

    @Override
    public void deplacerDroite(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(), 3, longueur, hauteur) && !Collisionneur.isCollision(personnage.getHitbox(), 3)) {
            Platform.runLater(() -> personnage.setPos(personnage.getHitbox().getPosX() + VITESSE, personnage.getHitbox().getPosY()));
        }
    }
    @Override
    public void deplacerGauche(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(), 2, longueur, hauteur) && !Collisionneur.isCollision(personnage.getHitbox(),2)) {

            Platform.runLater(() -> personnage.setPos(personnage.getHitbox().getPosX() - VITESSE, personnage.getHitbox().getPosY()));
        }
    }
    @Override
    public void deplacerHaut(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(),0,  longueur, hauteur) && !Collisionneur.isCollision(personnage.getHitbox(),0)){
            Platform.runLater(() -> personnage.setPos(personnage.getHitbox().getPosX(), personnage.getHitbox().getPosY() - VITESSE));
        }
    }
    @Override
    public void deplacerBas(Personnage personnage, double longueur, double hauteur) {
        if(!Collisionneur.isOut(personnage.getHitbox(), 1, longueur, hauteur) && !Collisionneur.isCollision(personnage.getHitbox(),1)){
            Platform.runLater(() -> personnage.setPos(personnage.getHitbox().getPosX(), personnage.getHitbox().getPosY() + VITESSE));
        }
    }
}
