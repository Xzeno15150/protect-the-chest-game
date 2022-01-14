package model.data;

import model.Manager;
import model.metier.Entite;
import model.metier.Monde;
import model.metier.Obstacle;
import model.metier.Personnage;

import java.util.ArrayList;
import java.util.List;

public class Stub implements Loader{
    @Override
    public Monde load() {
        List<Entite> entites = new ArrayList<>();
        entites.add(new Personnage(200, 100, 50));
        entites.add(new Obstacle(540-50, 720-25, 50, 100));
        entites.add(new Personnage(900,20,30));
        return new Monde(entites);
    }
}
