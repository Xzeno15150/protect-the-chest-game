package modele.projectiles;

public class Balle extends Projectile{

    public Balle(String img, int maxD, int x, int y) {
        image = img;
        maxDistance = maxD;
        posX = x;
        posY = y;
    }
}
