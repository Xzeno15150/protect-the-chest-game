package modele.collisions;

import controllers.Manager;
import launch.Launcher;
import modele.obstacles.Obstacle;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

import controllers.Manager;
import launch.Launcher;

public class Collisionneur {

    private static final Manager mgr = Launcher.getManager();

    public static Boolean isCollision(Hitbox h, int dir){
        // Vérifie que la hitbox n'est pas une ligne
        if (h.getBRCornerX() == h.getTLCornerX() || h.getBRCornerY() == h.getTLCornerY()){
            return false;
        }
        for( Obstacle o: mgr.getMonde().getLesObstacles()){
            if(isCollision(h, o.getHitbox(), dir)){
                return true;
            }
        }
        for (Personnage p : mgr.getMonde().getLesPersonnages()) {
            if(isCollision(h, p.getHitbox(), dir)){
                return true;
            }
        }
        for (Projectile p : mgr.getMonde().getLesProjectiles()) {
            if(isCollision(h, p.getHitbox(), dir)){
                return true;
            }
        }
        return false;
    }

    public static Boolean isCollision(Hitbox h1, Hitbox h2, int dir) {
        // Vérifie que la hitbox n'est pas une ligne
        if (h2.getBRCornerX() == h2.getTLCornerX() || h2.getBRCornerY() == h2.getTLCornerY()){
            return false;
        }
        //Vérifie qu'on ne compare pas le même objet
        if(h1.equals(h2)) {
            return false;
        }
        // variable pour ajuster les collisions (surement à retravailler)
        int pix=2;
        //Verifie pour chaque direction si il y'a une collision
        switch (dir) {
            case 0 : {
                return h1.getTLCornerY()<= h2.getBRCornerY() && h1.getBRCornerY() >= h2.getTLCornerY() && h1.getTLCornerX()> h2.getTLCornerX()-h1.getLongueur()+pix && h1.getBRCornerX() < h2.getBRCornerX()+ h1.getLongueur()-pix;
            }
            case 1 : {
                return h1.getBRCornerY()>= h2.getTLCornerY() && h1.getTLCornerY() <= h2.getBRCornerY() && h1.getTLCornerX()> h2.getTLCornerX()-h1.getLongueur()+pix && h1.getBRCornerX() < h2.getBRCornerX()+ h1.getLongueur()-pix;
            }
            case 2 : {
                return h1.getTLCornerX()<= h2.getBRCornerX() && h1.getBRCornerX() >= h2.getTLCornerX() && h1.getTLCornerY()> h2.getTLCornerY()- h1.getHauteur()+pix && h1.getBRCornerY()< h2.getBRCornerY()+ h1.getHauteur()-pix;
            }
            case 3 : {
                return h1.getBRCornerX()>= h2.getTLCornerX() && h1.getTLCornerX() <= h2.getBRCornerX() && h1.getTLCornerY()> h2.getTLCornerY()- h1.getHauteur()+pix && h1.getBRCornerY()< h2.getBRCornerY()+ h1.getHauteur()-pix;
            }
        }
        throw new IllegalArgumentException("La direction n'est pas bonne");
    }


    //Verifie qu'on ne sort pas de la fenêtre
    public static Boolean isOut(Hitbox h, int dir, double longueur, double hauteur){
        switch (dir) {
            case 0 : {
                return isOutHaut(h);
            }
            case 1 : {
                return isOutBas(h, hauteur);
            }
            case 2 : {
                return isOutGauche(h);
            }
            case 3 : {
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
