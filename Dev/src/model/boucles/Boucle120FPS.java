package model.boucles;

import model.Manager;
import model.observers.Observer;

import java.util.Set;

public class Boucle120FPS extends BoucleDeJeu{

    public Boucle120FPS(Set<Observer> observers, Manager mgr) {
        this.observers = observers;
        this.mgr = mgr;
    }

    @Override
    protected int getFrameRate() {
        return 120;
    }
}
