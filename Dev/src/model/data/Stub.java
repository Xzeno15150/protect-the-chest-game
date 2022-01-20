package model.data;

import model.Manager;
import model.metier.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Stub contient des données brutes permettant de créer un Monde
 */
public class Stub implements Loader{
    /**
     * load charge les données et créer un Monde
     * @return Retourne un Monde avec ses données
     */
    @Override
    public Monde load() {
        List<Entite> entites = new ArrayList<>();
        entites.add(new Personnage(540-25, 600-25, 50));
        entites.add(new Obstacle(540-50, 720-50, 50, 100));
        entites.add(new Obstacle(300,300, 60));
        entites.add(new Obstacle(500,250, 60,80));
        entites.add(new Obstacle(700,300, 30));
        return new Monde(entites);
    }
}
