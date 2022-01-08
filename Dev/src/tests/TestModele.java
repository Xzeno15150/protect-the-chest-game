package tests;

import modele.collisions.Collisionneur;
import modele.collisions.Hitbox;
import modele.personnages.Ennemi;
import modele.personnages.Personnage;
import modele.personnages.PersonnagePrincipal;

public class TestModele {
    public static void main(String[] args) {
        Personnage p1 = new PersonnagePrincipal("", 20,  new Hitbox(100, 100, 100));
        Personnage p2 = new Ennemi("", 20,  new Hitbox(100, 250, 150));

        Collisionneur c = new Collisionneur();
/*
        if (c.isCollision(p1.getHitbox(), p2.getHitbox())){
            System.out.println("Collision");
        }
        else{
            System.out.println("Pas collision");
        }*/
    }
}
