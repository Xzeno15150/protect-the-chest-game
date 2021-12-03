package modele;

public abstract class Tireur {
    int vitesseTir;
    String skin;
    int sante;

    public abstract void tirer();
    public abstract Boolean isAlive();
}
