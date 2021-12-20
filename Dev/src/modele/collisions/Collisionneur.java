package modele.collisions;

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


    public static Boolean isCollisionDroite(Hitbox h1, Hitbox h2) {
        return  h1.getBRCornerX() >= h2.getTLCornerX()
                && (h1.getTLCornerY() <= h2.getBRCornerY() && h1.getTLCornerY() > h2.getTLCornerY()
                    || h1.getBRCornerY() <= h2.getBRCornerY() && h1.getBRCornerY() > h2.getTLCornerY());
    }

    //Verifie qu'on ne sort pas de la fenêtre
    public static Boolean isOut(Hitbox h, int dir, double longueur, double hauteur){
        switch (dir) {
            case 0 -> {
                return isOutHaut(h);
            }
            case 1 -> {
                System.out.println(hauteur);
                return isOutBas(h, hauteur);
            }
            case 2 -> {
                return isOutGauche(h);
            }
            case 3 -> {
                return isOutDroite(h, longueur);
            }
        }
        throw new IllegalArgumentException("La direction n'est pas bonne");
    }

    private static Boolean isOutDroite(Hitbox h, double longueur) {
        return h.getBRCornerX() >= longueur;
    }

    private static Boolean isOutGauche(Hitbox h) {
        return h.getTLCornerX() <= 0;
    }

    private static Boolean isOutBas(Hitbox h, double hauteur) {
        return h.getBRCornerY() >= hauteur;
    }

    private static Boolean isOutHaut(Hitbox h) {
        return h.getTLCornerY() <= 0;
    }
}
