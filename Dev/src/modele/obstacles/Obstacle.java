package modele.obstacles;

import modele.collisions.Hitbox;

public class Obstacle {
    private int x;
    private int y;
    private String img;
    private Hitbox hitbox;

    public Obstacle(int x, int y, String img, Hitbox hitbox) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.hitbox = hitbox;
    }
}
