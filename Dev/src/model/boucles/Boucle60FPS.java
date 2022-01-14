package model.boucles;

import model.Manager;
import model.observers.Observer;

import java.util.Set;

public class Boucle60FPS extends BoucleDeJeu{
    public Boucle60FPS(Set<Observer> observers, Manager manager) {
        super(observers, manager);
    }

    @Override
    protected int getFrameRate() {
        return 60;
    }
}
