package modele.boucles;

import java.util.ArrayList;

public class Boucle30FPS extends BoucleDeJeu{

    public Boucle30FPS() {
        setLesObservateurs(new ArrayList<>());
    }
    @Override
    protected int getFrameRate() {
        return 30;
    }
}
