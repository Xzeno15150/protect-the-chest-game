package controllers;

import data.LoaderMonde;
import data.Stub;
import javafx.scene.input.KeyCode;
import modele.Monde;
import modele.boucles.Boucle30FPS;
import modele.boucles.Boucle60FPS;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.observers.ObservateurBoucle;
import modele.observers.ObservateurBouclePrincipale;
import modele.personnages.Personnage;

import java.util.Set;

public class Manager {

    // Attributes
    private Monde monde;
    private Personnage personnagePrincipal;
    private boolean gameRunning;
    private final KeyboardListener keyboardListener = new KeyboardListener();
    private ObservateurBoucle observateurMainBoucle;

    public Manager() {
        startGame();
    }


    // Getter/Setter
    public Monde getMonde() {
        return monde;
    }
    public Personnage getPersonnagePrincipal() {
        return personnagePrincipal;
    }
    public boolean isGameRunning() {
        return gameRunning;
    }

    // Methods

    private void startGame() {
        LoaderMonde loaderMonde = new Stub();
        monde = loaderMonde.load();
        personnagePrincipal = monde.getLesPersonnages().get(0);
        gameRunning = true;

        var gameLoop = new Boucle60FPS();
        gameLoop.attacher(new ObservateurBouclePrincipale());

        Thread gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();
    }

    public void deplacerPersonnage(Set<KeyCode> activeKeys){
        DeplaceurPersonnage dp = new DeplaceurNormal();
        if (activeKeys.contains(KeyCode.getKeyCode("Z"))) {
            dp.deplacerHaut(monde.getLesPersonnages().get(0), monde.getLongueur(), monde.getHauteur());
        }
        if (activeKeys.contains(KeyCode.getKeyCode("S"))) {
            dp.deplacerBas(monde.getLesPersonnages().get(0), monde.getLongueur(), monde.getHauteur());
        }

        if (activeKeys.contains(KeyCode.getKeyCode("Q"))) {
            dp.deplacerGauche(monde.getLesPersonnages().get(0), monde.getLongueur(), monde.getHauteur());
        }

        if (activeKeys.contains(KeyCode.getKeyCode("D"))) {
            dp.deplacerDroite(monde.getLesPersonnages().get(0), monde.getLongueur(), monde.getHauteur());
        }
    }

    public void tour() {
        var activeKeys = keyboardListener.getActiveKeys();
        deplacerPersonnage(activeKeys);

        if (activeKeys.contains(KeyCode.getKeyCode("P"))) {
            gameRunning = !gameRunning;
        }
    }
    public void tirer() {

    }
}
