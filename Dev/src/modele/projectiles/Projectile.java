package modele.projectiles;

import modele.collisions.Hitbox;

public abstract class Projectile {
    protected String image;
    protected int maxDistance;
    protected int posX;
    protected int posY;
    protected Hitbox hitbox;

    public int getMaxDistance() {
        return maxDistance;
    }
    public String getImage() {
        return image;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public Hitbox getHb() {
        return hitbox;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
}
