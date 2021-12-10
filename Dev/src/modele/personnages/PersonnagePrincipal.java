package modele.personnages;


import modele.collisions.Hitbox;

public class PersonnagePrincipal extends Personnage {

    public PersonnagePrincipal(String skin, int santemax, Hitbox hb){
        setImage(skin);
        setSanteMax(santemax);
        setSante(santemax);
        setHitbox(hb);
    }
}
