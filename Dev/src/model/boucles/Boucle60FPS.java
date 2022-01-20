package model.boucles;

import model.Manager;
import model.observers.Observer;

import java.util.Set;

/**
 * Boucle60Fps permet de faire une boucle de jeu qui boucle 60 fois par secondes
 */
public class Boucle60FPS extends BoucleDeJeu{
    /**
     * constructeur récupere le Manager et la liste des observateurs et les passe à BoucleDeJeu
     * @param observers Set<Observer> observers est la liste qui contient les observateurs
     * @param manager Manager manager on récupere le Manager
     */
    public Boucle60FPS(Set<Observer> observers, Manager manager) {
        super(observers, manager);
    }

    /**
     * Récupère le nombre de fois que la boucle doit boucler par seconde
     * @return retourne le nombre de boucle par seconde (int)
     */
    @Override
    protected int getFrameRate() {
        return 60;
    }
}
