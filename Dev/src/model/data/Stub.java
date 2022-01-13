package model.data;

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
        entites.add(new Personnage(0, 0, 50));
        entites.add(new Obstacle(400, 400, 50, 100));
        return new Monde(entites);
    }
}
