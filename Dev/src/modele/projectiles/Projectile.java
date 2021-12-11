package modele.projectiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.collisions.Hitbox;

public abstract class Projectile {
    private String image;
    private int maxDistance;
    private Hitbox hitbox;

    // Getter/Setter
    public int getMaxDistance() {
        return maxDistance;
    }
    public String getImage() {
        return image;
    }
    public Hitbox getHitbox() {
        return hitbox;
    }
    protected void setImage(String image) {
        this.image = image;
    }
    protected void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }
    protected void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
}
