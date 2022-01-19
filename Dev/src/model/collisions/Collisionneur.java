package model.collisions;

public interface Collisionneur {
    boolean isCollision(double TLX, double TLY, double BRX, double BRY,
                        double tlx2, double tly2, double brx2, double bry2);
}
