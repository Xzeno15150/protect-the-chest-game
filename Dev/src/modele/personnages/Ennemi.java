package modele.personnages;

public class Ennemi extends Personage {
    public Ennemi(String skin, int santemax, int x, int y) {
        image = skin;
        santeMax = santemax;
        sante = santemax;
        posX = x;
        posY = y;
    }

    @Override
    public Boolean isAlive() {
        return sante==0;
    }
}
