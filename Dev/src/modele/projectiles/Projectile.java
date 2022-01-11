package modele.projectiles;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import modele.ElementScene;
import modele.collisions.Hitbox;

import java.util.Objects;

public class Projectile implements ElementScene {
    private String image;
    private int maxDistance;
    private final int vitesse;
    private int degats;
    private Hitbox hitbox;

    public Projectile(String image, int maxDistance, int vitesse,int degats, Hitbox hitbox) {
        this.image = image;
        this.maxDistance = maxDistance;
        this.vitesse = vitesse;
        this.hitbox = hitbox;
        this.degats = degats;
    }

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
    public int getVitesse() {
        return vitesse;
    }
    public int getDegats() {
        return degats;
    }
    private void setImage(String image) {
        this.image = image;
    }
    private void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }
    private void setHitbox(Hitbox hitbox) {
        this.hitbox = hitbox;
    }
    public void setDegats(int degats) {
        this.degats = degats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projectile that = (Projectile) o;
        return maxDistance == that.maxDistance && vitesse == that.vitesse && image.equals(that.image) && hitbox.equals(that.hitbox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(image, maxDistance, vitesse, hitbox);
    }

}
