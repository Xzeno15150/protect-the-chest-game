package modele.personnages;

import modele.collisions.Hitbox;

public class Ennemi extends Personnage {
    public Ennemi(String skin, int santemax, Hitbox hb) {
        setImage(skin);
        setSanteMax(santemax);
        setSante(santemax);
        setHitbox(hb);
    }

}
