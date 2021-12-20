package modele.boucles;

import launch.Launcher;
import modele.observers.ObservateurBoucle;

import java.util.List;

public abstract class BoucleDeJeu implements Runnable{
    private List<ObservateurBoucle> lesObservateurs;

    // Getter/Setter
    protected abstract int getFrameRate();
    protected List<ObservateurBoucle> getLesObservateurs() {
        return lesObservateurs;
    }
    protected void setLesObservateurs(List<ObservateurBoucle> lesObservateurs) {
        this.lesObservateurs = lesObservateurs;
    }

    // Methods
    @Override
    public void run() {
        while (Launcher.getManager().isGameRunning()){
            try {
                Thread.sleep(1000 / getFrameRate());
                notifier();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void attacher(ObservateurBoucle o) {
        lesObservateurs.add(o);
    }

    public void detacher(ObservateurBoucle o){
        lesObservateurs.remove(o);
    }

    public void notifier(){
        for (ObservateurBoucle o: lesObservateurs) {
            o.update();
        }
    }
}
