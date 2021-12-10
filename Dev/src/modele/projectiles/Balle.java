package modele.projectiles;

import com.sun.javafx.scene.text.TextLayout;
import modele.collisions.Hitbox;

public class Balle extends Projectile{

    public Balle(String img, int maxD, int x, int y, Hitbox hb) {
        image = img;
        maxDistance = maxD;
        posX = x;
        posY = y;
        hitbox = hb;
    }
}
