package modele.projectiles;

public abstract class Projectile {
    protected String image;
    protected int maxDistance;
    protected int posX;
    protected int posY;

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

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
