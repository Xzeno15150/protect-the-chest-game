package modele.boucles;

public abstract class BoucleDeJeu implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(getFrameRate());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected abstract int getFrameRate();
}
