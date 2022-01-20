package model.boucles;

import model.Manager;
import model.observers.Observer;

import java.util.Set;

/**
 * BoucleDeJeu est la boucle principale qui fait tourner le jeu
 */
public abstract class  BoucleDeJeu implements Runnable{

    protected Set<Observer> observers;
    protected Manager mgr;

    /**
     * constructeur récupere le Manager et la liste des observateurs
     * @param observers Set observers est la liste qui contient les observateurs
     * @param mgr Manager mgr on récupere le Manager
     */
    public BoucleDeJeu(Set<Observer> observers, Manager mgr) {
        this.observers = observers;
        this.mgr = mgr;
    }

    /**
     * Récupère le nombre de fois que la boucle doit boucler par seconde
     * @return retourne le nombre de boucle par seconde (int)
     */
    protected abstract int getFrameRate();

    /**
     * run est la boucle de jeu qui tant que le jeu est en cours, notifie les observateurs le bon nombre de fois par seconde
     */
    @Override
    public void run() {
        while (mgr.isGameRunning()) {
            try {
                Thread.sleep(1000 / getFrameRate());
                notifier();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * notifier appelle les methodes updates des observateurs
     */
    public void notifier(){
        for (Observer o : observers) {
            o.update();
        }
    }

    /**
     * attacher permet d'ajouter un Observer à la liste des observateurs
     * @param o Observer o est ajouté à la liste observers(Set)
     */
    public void attacher(Observer o){
        observers.add(o);
    }

    /**
     * detacher permet de supprimer un Observer à la liste des observateurs
     * @param o Observer o est l'observateur à retirer de la liste observers (Set)
     */
    public void detacher(Observer o){
        observers.remove(o);
    }
}
