package model;

import javafx.scene.input.KeyCode;
import model.boucles.Boucle60FPS;
import model.deplacement.DeplaceurNormalVitesse2;
import model.IA.IA;
import model.IA.IASimple;
import model.boucles.Boucle120FPS;
import model.collisions.Collisionneur;
import model.collisions.CollisionneurSimple;
import model.controls.KeyListener;
import model.data.Loader;
import model.data.Stub;
import model.deplacement.DeplaceurNormal;
import model.metier.Ennemi;
import model.metier.Monde;
import model.metier.Projectile;
import model.observers.ObservateurPrincipal;
import model.observers.AnimateurProjectile;
import model.observers.Observer;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Manager {

    private final Loader loader = new Stub();
    private DeplaceurNormal deplaceur;
    private Collisionneur collisionneur;
    private  Monde monde;
    private int lastShotTime;

    private  KeyListener keyListener;

    public void startGame() {
        monde = loader.load();
        collisionneur = new CollisionneurSimple(monde);
        deplaceur = new DeplaceurNormalVitesse2(collisionneur, this);

        keyListener = new KeyListener(new HashSet<>());

        Set<Observer> observers = new HashSet<>();
        observers.add(new AnimateurProjectile(collisionneur, this));
        observers.add(new ObservateurPrincipal(this));
        observers.add(new IASimple(this, collisionneur));
        Thread mainBoucle = new Thread(new Boucle120FPS(observers, this));
        mainBoucle.start();

        monde.hauteurProperty().addListener((observable, oldValue, newValue) ->
                monde.getCoffre().setY(newValue.doubleValue() - monde.getCoffre().getHauteur())
        );
        monde.largeurProperty().addListener((observable, oldValue, newValue) ->
                monde.getCoffre().setX((newValue.doubleValue() / 2) - monde.getCoffre().getLargeur() /2)
        );
    }

    public void deplacerPersonnagePrincipal(){
        if (keyListener.getActiveKeys().contains(KeyCode.Z))
            deplaceur.deplacerHaut(monde.getPersonnagePrincipal());
        if (keyListener.getActiveKeys().contains(KeyCode.S))
            deplaceur.deplacerBas(monde.getPersonnagePrincipal());
        if (keyListener.getActiveKeys().contains(KeyCode.Q))
            deplaceur.deplacerGauche(monde.getPersonnagePrincipal());
        if (keyListener.getActiveKeys().contains(KeyCode.D))
            deplaceur.deplacerDroite(monde.getPersonnagePrincipal());
    }

    public void tirer() {
        if (keyListener.getActiveKeys().contains(KeyCode.SPACE)) {
            var newShotTime = LocalDateTime.now().getSecond();
            if (newShotTime - lastShotTime > 0.25) {
                lastShotTime = newShotTime;
                Projectile p = new Projectile(monde.getPersonnagePrincipal().getX(), monde.getPersonnagePrincipal().getY() - 40, 30, 10);
                monde.addEntite(p);
            }
        }
    }

    public void tuer(Ennemi ennemi) {
        monde.removeEntite(ennemi);
    }

    public void retirerVie() {

    }

    public Monde getMonde() {
        return monde;
    }
    public boolean isGameRunning() {
        return true;
    }
}
