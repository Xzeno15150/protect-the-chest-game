package model.boucles;

import model.Manager;
import model.observers.Observer;

import java.util.Set;

/**
 * Boucle120Fps permet de faire une boucle de jeu qui boucle 120 fois par secondes
 */
public class Boucle120FPS extends BoucleDeJeu{

    /**
     * constructeur récupere le Manager et la liste des observateurs et les passe à BoucleDeJeu
     * @param observers Set observers est la liste qui contient les observateurs
     * @param mgr Manager mgr on récupere le Manager
     */
    public Boucle120FPS(Set<Observer> observers, Manager mgr) {
        super(observers, mgr);
    }

    /**
     * Récupère le nombre de fois que la boucle doit boucler par seconde
     * @return retourne le nombre de boucle par seconde (int)
     */
    @Override
    protected int getFrameRate() {
        return 120;
    }
}
