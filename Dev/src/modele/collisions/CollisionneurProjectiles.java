package modele.collisions;

import controllers.Manager;
import launch.Launcher;
import modele.ElementScene;
import modele.obstacles.Obstacle;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

public class CollisionneurProjectiles extends Collisionneur{

    private static final Manager mgr = Launcher.getManager();

    //return object pour pouvoir mettre des dégats
    public static ElementScene isCollision(Hitbox h){
        // Vérifie que la hitbox n'est pas une ligne
        if (h.getBRCornerX() == h.getTLCornerX() || h.getBRCornerY() == h.getTLCornerY()){
            return null;
        }
        for( Obstacle o: mgr.getMonde().getLesObstacles()){
            if(isCollision(h, o.getHitbox())){
                return o;
            }
        }
        var pp = true;
        for (Personnage p : mgr.getMonde().getLesPersonnages()) {
            if(!pp && isCollision(h, p.getHitbox())){
                return p;
            }
            pp = false;
        }
        for (Projectile p : mgr.getMonde().getLesProjectiles()) {
            if(isCollision(h, p.getHitbox())){
                return p;
            }
        }
        return null;
    }

    public static Boolean isCollision(Hitbox h, Hitbox h2){
        if (h2.getBRCornerX() == h2.getTLCornerX() || h2.getBRCornerY() == h2.getTLCornerY()){
            return false;
        }
        //Vérifie qu'on ne compare pas le même objet
        if(h.equals(h2)) {
            return false;
        }
        // Cas où une Hitbox est à gauche de l'autre
        if(h.getTLCornerX() >= h2.getBRCornerX() || h2.getTLCornerX() >= h.getBRCornerX()) {
            return false;
        }
        // Cas où une Hitbox est au dessus de l'autre
        return h.getTLCornerY() < h2.getBRCornerY() && h2.getTLCornerY() <h.getBRCornerY();
    }
}
