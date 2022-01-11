package modele.collisions;

import controllers.Manager;
import launch.Launcher;
import modele.obstacles.Obstacle;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

public class Collisionneur {

    private static final Manager mgr = Launcher.getManager();
    private static final int PIX = 2;

    public static Boolean isCollisionPersonnage(Personnage personnage, int dir){
        // Vérifie que la hitbox n'est pas une ligne
        if (personnage.getHitbox().getBRCornerX() == personnage.getHitbox().getTLCornerX() || personnage.getHitbox().getBRCornerY() == personnage.getHitbox().getTLCornerY()){
            return false;
        }
        for( Obstacle o: mgr.getMonde().getLesObstacles()){
            if(isCollisionPersonnage(personnage, o.getHitbox(), dir)){
                return true;
            }
        }
        for (Personnage p : mgr.getMonde().getLesPersonnages()) {
            if(isCollisionPersonnage(personnage, p.getHitbox(), dir)){
                return true;
            }
        }
        for (Projectile p : mgr.getMonde().getLesProjectiles()) {
            if(isCollisionPersonnage(personnage, p.getHitbox(), dir)){
                return true;
            }
        }
        return false;
    }

    public static Boolean isCollisionPersonnage(Personnage personnage, Hitbox h2, int dir) {
        // Vérifie que la hitbox n'est pas une ligne
        if (h2.getBRCornerX() == h2.getTLCornerX() || h2.getBRCornerY() == h2.getTLCornerY()){
            return false;
        }
        //Vérifie qu'on ne compare pas le même objet
        if(personnage.getHitbox().equals(h2)) {
            return false;
        }
        //Verifie pour chaque direction si il y'a une collision
        /*
        Dir :
            0 = haut
            1 = bas
            2 = gauche
            3 = droite
         */
        switch (dir) {
            case 0 -> {
                return personnage.getHitbox().getTLCornerY() + personnage.getVitesse() <= h2.getBRCornerY()
                        && personnage.getHitbox().getBRCornerY() + personnage.getVitesse() >= h2.getTLCornerY()
                        && personnage.getHitbox().getTLCornerX() > h2.getTLCornerX() - personnage.getHitbox().getLongueur() + PIX
                        && personnage.getHitbox().getBRCornerX() < h2.getBRCornerX() + personnage.getHitbox().getLongueur() - PIX;
            }
            case 1 -> {
                return personnage.getHitbox().getBRCornerY() + personnage.getVitesse() >= h2.getTLCornerY()
                        && personnage.getHitbox().getTLCornerY() + personnage.getVitesse() <= h2.getBRCornerY()
                        && personnage.getHitbox().getTLCornerX() > h2.getTLCornerX() - personnage.getHitbox().getLongueur() + PIX
                        && personnage.getHitbox().getBRCornerX() < h2.getBRCornerX() + personnage.getHitbox().getLongueur() - PIX;
            }
            case 2 -> {
                return personnage.getHitbox().getTLCornerX() + personnage.getVitesse() <= h2.getBRCornerX()
                        && personnage.getHitbox().getBRCornerX() + personnage.getVitesse() >= h2.getTLCornerX()
                        && personnage.getHitbox().getTLCornerY() > h2.getTLCornerY() - personnage.getHitbox().getHauteur()  + PIX
                        && personnage.getHitbox().getBRCornerY() < h2.getBRCornerY() + personnage.getHitbox().getHauteur() - PIX;
            }
            case 3 -> {
                return personnage.getHitbox().getBRCornerX() + personnage.getVitesse() >= h2.getTLCornerX()
                        && personnage.getHitbox().getTLCornerX() + personnage.getVitesse() <= h2.getBRCornerX()
                        && personnage.getHitbox().getTLCornerY() > h2.getTLCornerY() - personnage.getHitbox().getHauteur() + PIX
                        && personnage.getHitbox().getBRCornerY() < h2.getBRCornerY() + personnage.getHitbox().getHauteur() - PIX;
            }
        }
        throw new IllegalArgumentException("La direction n'est pas bonne");
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
