package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.collections.SetChangeListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import launcher.Launch;
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
import model.metier.Entite;
import model.metier.Monde;
import model.metier.Projectile;
import model.observers.ObservateurPrincipal;
import model.observers.AnimateurProjectile;
import model.observers.Observer;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Manager {

    private final IntegerProperty numManche= new SimpleIntegerProperty(0);
        public int getNumManche() {
        return numManche.get();
    }
        public IntegerProperty numMancheProperty() {
        return numManche;
    }
        public void setNumManche(int numManche) {
        this.numManche.set(numManche);
    }

    private final IntegerProperty nbVie = new SimpleIntegerProperty();
        public int getNbVie() {
        return nbVie.get();
    }
        public IntegerProperty nbVieProperty() {
        return nbVie;
    }
        public void setNbVie(int nbVie) {
        this.nbVie.set(nbVie);
    }

    private boolean gameRunning = true;
    private final Loader loader = new Stub();
    private DeplaceurNormal deplaceur;
    private Collisionneur collisionneur;
    private  Monde monde;
    private long lastShotTime;

    private  KeyListener keyListener;

    public void init() {

        monde = loader.load();
        setNbVie(3);
        collisionneur = new CollisionneurSimple(monde);
        deplaceur = new DeplaceurNormalVitesse2(collisionneur, this);

        keyListener = new KeyListener(new HashSet<>());
        monde.hauteurProperty().addListener((observable, oldValue, newValue) ->
                monde.getCoffre().setY(newValue.doubleValue() - monde.getCoffre().getHauteur())
        );
        monde.largeurProperty().addListener((observable, oldValue, newValue) ->
                monde.getCoffre().setX((newValue.doubleValue() / 2) - monde.getCoffre().getLargeur() /2)
        );

        monde.lesEntitesProperty().addListener((ListChangeListener<? super Entite>)  c -> {
            while (c.next()){
                if (c.wasRemoved()) {
                    for (Entite e :
                            monde.getLesEntites()) {
                        if (e instanceof Ennemi) return;
                    }
                    mancheSuivante();
                }
            }
        });
    }

    public void startGame() {

        Set<Observer> observers = new HashSet<>();
        observers.add(new AnimateurProjectile(collisionneur, this));
        observers.add(new ObservateurPrincipal(this));
        observers.add(new IASimple(this, collisionneur));
        Thread mainBoucle = new Thread(new Boucle120FPS(observers, this));
        mainBoucle.start();

        mancheSuivante();

    }

    public void deplacerPersonnagePrincipal(){
        if (keyListener.getActiveKeys().contains(KeyCode.Z)) {
            deplaceur.deplacerHaut(monde.getPersonnagePrincipal());
        }
        if (keyListener.getActiveKeys().contains(KeyCode.S)) {
            deplaceur.deplacerBas(monde.getPersonnagePrincipal());
        }
        if (keyListener.getActiveKeys().contains(KeyCode.Q)) {
            deplaceur.deplacerGauche(monde.getPersonnagePrincipal());
        }
        if (keyListener.getActiveKeys().contains(KeyCode.D)) {
            deplaceur.deplacerDroite(monde.getPersonnagePrincipal());
        }
    }

    public void tirer() {
        if (keyListener.getActiveKeys().contains(KeyCode.SPACE)) {
            var newShotTime = System.currentTimeMillis();
            if (newShotTime - lastShotTime > 750) {
                lastShotTime = newShotTime;
                Projectile p = new Projectile(monde.getPersonnagePrincipal().getX(), monde.getPersonnagePrincipal().getY() - 40, 30, 10);
                monde.addEntite(p);
            }
        }
    }

    public void mancheSuivante() {
        setNumManche(getNumManche()+1);
        monde.createRandomPosEnnemi();
    }

    public void tuer(Ennemi ennemi) {
        monde.removeEntite(ennemi);
    }

    public void retirerVie() {
        if (getNbVie() == 0) {
            gameRunning = false;
            System.out.println("Game over !");
            return;
        }
        setNbVie(getNbVie() - 1);
    }

    public Monde getMonde() {
        return monde;
    }
    public boolean isGameRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }
}
