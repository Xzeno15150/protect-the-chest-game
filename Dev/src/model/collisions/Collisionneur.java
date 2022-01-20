package model.collisions;

/**
 * Test s'il y a intersection de deux objets via leurs coordonnées
 */
public interface Collisionneur {
    /**
     * Test s'il deux objets dont on connait les coordonnées de leur coin haut-gauche et bas-droit sont en intersection
     * @param TLX X du coin haut-gauche du premier objet
     * @param TLY Y du coin haut-gauche du premier objet
     * @param BRX X du coin bas-droite du premier objet
     * @param BRY Y du coin bas-droite du premier objet
     * @param tlx2 X du coin haut-gauche du deuxième objet
     * @param tly2 Y du coin haut-gauche du deuxième objet
     * @param brx2 X du coin bas-droite du deuxième objet
     * @param bry2 Y du coin bas-droite du deuxième objet
     * @return True s'ils sont en intersection, false sinon
     */
    boolean isCollision(double TLX, double TLY, double BRX, double BRY,
                        double tlx2, double tly2, double brx2, double bry2);
}
