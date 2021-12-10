package modele.personnages;


public class PersonnagePrincipal extends Personnage {

    public PersonnagePrincipal(String skin, int santemax, int x, int y){
        image = skin;
        super.santeMax = santemax;
        super.sante = santemax;
        posX = x;
        posY = y;
    }

    @Override
    public Boolean isAlive() {
        return sante > 0;
    }
}
