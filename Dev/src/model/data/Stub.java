package model.data;

import model.Manager;
import model.metier.*;

import java.util.ArrayList;
import java.util.List;

public class Stub implements Loader{
    @Override
    public Monde load() {
        List<Entite> entites = new ArrayList<>();
        entites.add(new Personnage(200, 100, 50));
        entites.add(new Obstacle(540-50, 720-50, 50, 100));
        entites.add(new Ennemi(900,20,30));
        return new Monde(entites);
    }
}
