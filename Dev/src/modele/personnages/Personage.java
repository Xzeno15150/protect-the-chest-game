package modele.personnages;

public abstract class Personage {
    protected String image;
    protected int sante;
    protected int posX;
    protected int posY;
    protected int santeMax;

    public abstract Boolean isAlive();

    public int getSante() {
        return sante;
    }

    public String getImage() {
        return image;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public void setImage(String skin) {
        image = skin;
    }

    public int getPosY() {
        return posY;
    }

    public int getPosX() {
        return posX;
    }

    public int getSanteMax() {
        return santeMax;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}

