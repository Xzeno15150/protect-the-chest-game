package modele.obstacles;

import modele.ElementScene;
import modele.collisions.Hitbox;

public class Obstacle implements ElementScene {
    private String img;
    private Hitbox hitbox;

    public Obstacle(String img, Hitbox hitbox) {
        this.img = img;
        this.hitbox = hitbox;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }
    public String getImage() {
        return img;
    }

    protected void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
    public void setImage(String skin) {
        img = skin;
    }
    public void setPos(int x, int y) {
        hitbox.setPosX(x);
        hitbox.setPosY(y);
    }
}
