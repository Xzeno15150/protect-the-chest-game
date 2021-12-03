package modele;

public class Personnage extends Tireur{

    public Personnage(int vitesse, String skin, int sante){
        this.vitesseTir= vitesse;
        this.skin = skin;
        this.sante = sante;
    }

    @Override
    public void tirer() {

    }

    @Override
    public Boolean isAlive() {
        return sante==0;
    }
}
