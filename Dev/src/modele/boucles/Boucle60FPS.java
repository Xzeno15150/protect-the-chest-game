package modele.boucles;

import java.util.ArrayList;

public class Boucle60FPS extends BoucleDeJeu{

    public Boucle60FPS() {
        setLesObservateurs(new ArrayList<>());
    }
    @Override
    protected int getFrameRate() {
        return 60;
    }
}
