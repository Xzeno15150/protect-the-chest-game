package modele.observers;

import launch.Launcher;

public class ObservateurBouclePrincipale implements ObservateurBoucle{
    @Override
    public void update() {
        Launcher.getManager().tour();
    }
}
