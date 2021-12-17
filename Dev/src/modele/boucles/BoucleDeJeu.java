package modele.boucles;

import observers.ObservateurBoucle;

import java.util.List;

public abstract class BoucleDeJeu implements Runnable{
    private List<ObservateurBoucle> lesObservateurs;
    @Override
    public void run() {
        try {
            Thread.sleep(1000/getFrameRate());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract int getFrameRate();

    protected List<ObservateurBoucle> getLesObservateurs() {
        return lesObservateurs;
    }
    protected void setLesObservateurs(List<ObservateurBoucle> lesObservateurs) {
        this.lesObservateurs = lesObservateurs;
    }

    public void attacher() {

    }
}
