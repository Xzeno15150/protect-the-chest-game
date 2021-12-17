package modele.collisions;
import modele.Monde;

public class Collisionneur {
    public static Boolean isCollision(Hitbox h1, Hitbox h2) {
        // Vérifie que les hitbox ne sont pas des lignes
        if (h1.getBRCornerX() == h1.getTLCornerX() || h1.getBRCornerY() == h1.getTLCornerY()){
            return false;
        }
        if (h2.getBRCornerX() == h2.getTLCornerX() || h2.getBRCornerY() == h2.getTLCornerY()) {
            return false;
        }

        // Cas où une Hitbox est à gauche de l'autre
        if(h1.getTLCornerX() >= h2.getBRCornerX() || h2.getTLCornerX() >= h1.getBRCornerX()) {
            return false;
        }
        // Cas où une Hitbox est au dessus de l'autre
        return h1.getTLCornerY() < h2.getBRCornerY() && h2.getTLCornerY() < h1.getBRCornerY();
    }

    //Verifie qu'on ne sort pas de la fenêtre
    public static Boolean isOut(Hitbox h, double longueur, double largeur){
        System.out.println(largeur);
        if (h.getTLCornerX() >= largeur ){
            return true;
        }
        if (h.getTLCornerY() <= 0 || h.getBRCornerY()>= longueur) {
            return true;
        }
        return false;
    }
}
