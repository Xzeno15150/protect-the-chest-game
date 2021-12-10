package modele.personnages;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.collisions.Hitbox;

public abstract class Personnage {
    // Attributs
    private String image;
    private int sante;
    private int santeMax;
    private Hitbox hitbox;

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

    protected void setSanteMax(int santeMax) {
        this.santeMax = santeMax;
    }
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
}

