package data;

import launch.Launcher;
import modele.Monde;
import modele.collisions.Hitbox;
import modele.obstacles.Obstacle;
import modele.personnages.Ennemi;
import modele.personnages.Personnage;
import modele.personnages.PersonnagePrincipal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Stub implements LoaderMonde{
    @Override
    public Monde load() {
        Personnage personnagePrincipal = new PersonnagePrincipal("/images/pp.png", 20, new Hitbox(100, 0, 0));
        Personnage ennemi = new Ennemi("/images/boite.png", 10,new Hitbox(100, 600,300));
        List<Personnage> l = new ArrayList<>();
        l.add(personnagePrincipal);
        l.add(ennemi);

        Obstacle coffre = new Obstacle("/images/coffre.png",new Hitbox(120,80, 540-60,720-80));

        List<Obstacle> lesObstacles = new ArrayList<>();
        lesObstacles.add(coffre);

        return new Monde(l, new ArrayList<>(), lesObstacles, 1080, 720);
    }
}
