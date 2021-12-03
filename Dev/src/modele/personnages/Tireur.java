package modele.personnages;

public abstract class Tireur {
    protected int vitesseTir;
    protected String skin;
    protected int sante;

    public abstract void tirer();
    public abstract Boolean isAlive();
}
