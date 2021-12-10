package modele.personnages;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.collisions.Hitbox;

public abstract class Personnage {
    // Properties
    private IntegerProperty posX = new SimpleIntegerProperty();
    public int getPosX() {
        return posX.get();
    }
    public void setPosX(int posX) {
        this.posX.set(posX);
    }
    public IntegerProperty posXProperty() {
        return posX;
    }

    private IntegerProperty posY = new SimpleIntegerProperty();
    public int getPosY() {
        return posY.get();
    }
    public IntegerProperty posYProperty() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY.set(posY);
    }

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
        setPosX(x);
        setPosY(y);
    }
}

