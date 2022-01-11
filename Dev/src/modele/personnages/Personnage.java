package modele.personnages;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.ElementScene;
import modele.collisions.Hitbox;

public class Personnage implements ElementScene, Cloneable{
    // Attributs
    private String image;
    private int sante;
    private final int santeMax;
    private Hitbox hitbox;
    private int vitesse;
    public static final int DEFAULT_VITESSE = 3;

    public Personnage(String skin, int santemax, Hitbox hb, int vitesse){
        this.image = skin;
        this.santeMax = santemax;
        sante = santemax;
        hitbox = hb;
        this.vitesse = vitesse;
    }

    public Personnage(String skin, int santemax, Hitbox hb){
        this(skin, santemax, hb, DEFAULT_VITESSE);
    }


    public Hitbox getHitbox() {
        return hitbox;
    }
    public int getSante() {
        return sante;
    }
    public String getImage() {
        return image;
    }
    public int getSanteMax() {
        return santeMax;
    }
    public Boolean isAlive(){ return getSante() > 0;}

    protected void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
    public void setSante(int sante) {
        this.sante = sante;
    }
    public void setImage(String skin) {
        image = skin;
    }
    public void setPos(int x, int y) {
        hitbox.setPosX(x);
        hitbox.setPosY(y);
    }
    public int getVitesse() {
        return vitesse;
    }
    public void setVitesse(int vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public Personnage clone() {
        try {
            Personnage clone = (Personnage) super.clone();
            clone.setHitbox(clone.getHitbox().clone());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}

