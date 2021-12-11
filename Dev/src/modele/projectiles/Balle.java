package modele.projectiles;

import com.sun.javafx.scene.text.TextLayout;
import modele.collisions.Hitbox;

public class Balle extends Projectile{

    public Balle(String img, int maxD, Hitbox hb) {
        setHitbox(hb);
        setImage(img);
        setMaxDistance(maxD);
    }
}
