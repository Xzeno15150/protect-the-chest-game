package model.boucles;

import launcher.Launch;
import model.Manager;
import model.observers.Observer;

import java.util.Set;

public abstract class BoucleDeJeu implements Runnable{

    protected Set<Observer> observers;
    protected Manager mgr;

    protected abstract int getFrameRate();

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

    public void notifier(){
        for (Observer o : observers) {
            o.update();
        }
    }

    public void attacher(Observer o){
        observers.add(o);
    }

    public void detacher(Observer o){
        observers.remove(o);
    }
}
