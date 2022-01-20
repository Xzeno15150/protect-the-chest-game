package model.collisions;

import model.metier.Monde;

/**
 * Collisionneur qui test aussi les collisions avec les bordures du monde
 */
public class CollisionneurSimple implements Collisionneur{

    private final Monde monde;

    /**
     * Constructeur de la classe CollisionneurSimple
     * @param monde Monde dont la hauteur et la largeur change
     */
    public CollisionneurSimple(Monde monde){
        this.monde = monde;
    }

    /**
     * Test s'il deux objets dont on connait les coordonnées de leur coin haut-gauche et bas-droit sont en intersection
     * @param tlx1 X du coin haut-gauche du premier objet
     * @param tly1 Y du coin haut-gauche du premier objet
     * @param brx1 X du coin bas-droite du premier objet
     * @param bry1 Y du coin bas-droite du premier objet
     * @param tlx2 X du coin haut-gauche du deuxième objet
     * @param tly2 Y du coin haut-gauche du deuxième objet
     * @param brx2 X du coin bas-droite du deuxième objet
     * @param bry2 Y du coin bas-droite du deuxième objet
     * @return True s'ils sont en intersection ou si l'objet se trouve à l'extérieur du monde, false sinon
     */
    @Override
    public boolean isCollision(double tlx1, double tly1, double brx1, double bry1,
                                double tlx2, double tly2, double brx2, double bry2) {
        return !(tlx1 > brx2 || brx1 < tlx2 || tly1 > bry2 || bry1 < tly2) || isOut(tlx1, tly1, brx1, bry1);
    }

    /**
     * Test si l'objet sort des bordures du monde
     * @param tlx X du coin haut-gauche de l'objet
     * @param tly Y du coin haut-gauche de l'objet
     * @param brx X du coin bas-droite l'objet
     * @param bry Y du coin bas-droite de l'objet
     * @return True si l'objet est en dehors des bordures du monde, false sinon
     */
    private boolean isOut(double tlx, double tly, double brx, double bry) {
        return tlx < 0 || tly < 0 || brx > monde.getLargeur() || bry > monde.getHauteur();
    }
}
