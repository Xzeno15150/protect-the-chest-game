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
        // Cas où une Hitbox est à gauche de l'autre
        if(h1.getTLCornerX() >= h2.getBRCornerX() || h2.getTLCornerX() >= h1.getBRCornerX()) {
            return false;
        }
        // Cas où une Hitbox est au dessus de l'autre
        return h1.getTLCornerY() < h2.getBRCornerY() && h2.getTLCornerY() < h1.getBRCornerY();

    }

    //Verifie qu'on ne sort pas de la fenêtre
    public static Boolean isOut(Hitbox h, int dir, double longueur, double hauteur){
        switch (dir) {
            case 0 -> {
                return isOutHaut(h);
            }
            case 1 -> {
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
