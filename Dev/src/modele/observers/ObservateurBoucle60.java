package modele.observers;

import launch.Launcher;

public class ObservateurBoucle60 implements ObservateurBoucle{
    @Override
    public void update() {
        Launcher.getManager().tour();
    }
}
