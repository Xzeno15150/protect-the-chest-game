package controllers;

import data.LoaderMonde;
import data.Stub;
import javafx.scene.input.KeyCode;
import launch.Launcher;
import modele.Monde;
import modele.boucles.Boucle60FPS;
import modele.collisions.Hitbox;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.observers.AnimateurProjectiles;
import modele.observers.ObservateurBouclePrincipale;
import modele.personnages.Personnage;
import modele.projectiles.Projectile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

public class Manager {

    // Attributes
    private final Monde monde;
    private final Personnage personnagePrincipal;
    private boolean gameRunning;
    private final KeyboardListener keyboardListener = new KeyboardListener();
    private int lastShotTime = 0;

    public Manager() {
        LoaderMonde loaderMonde = new Stub();
        monde = loaderMonde.load();

        personnagePrincipal = monde.getLesPersonnages().get(0);
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

    public void startGame() {
        gameRunning = true;

        var gameLoop = new Boucle60FPS();

        // Attache des observateurs à la boucle principale
        gameLoop.attacher(new ObservateurBouclePrincipale());
        gameLoop.attacher(new AnimateurProjectiles());

        Thread gameLoopThread = new Thread(gameLoop);
        gameLoopThread.start();
    }

    public void deplacerPersonnage(Set<KeyCode> activeKeys){
        DeplaceurPersonnage dp = new DeplaceurNormal();
        if (activeKeys.contains(KeyCode.Z)) {
            dp.deplacerHaut(personnagePrincipal, monde.getLongueur(), monde.getHauteur());
        }
        if (activeKeys.contains(KeyCode.S)) {
            dp.deplacerBas(personnagePrincipal, monde.getLongueur(), monde.getHauteur());
        }
        if (activeKeys.contains(KeyCode.Q)) {
            dp.deplacerGauche(personnagePrincipal, monde.getLongueur(), monde.getHauteur());
        }
        if (activeKeys.contains(KeyCode.D)) {
            dp.deplacerDroite(personnagePrincipal, monde.getLongueur(), monde.getHauteur());
        }
    }

    public void tour() {
        var activeKeys = keyboardListener.getActiveKeys();

        if (isGameRunning()){
            deplacerPersonnage(activeKeys);
            if (activeKeys.contains(KeyCode.SPACE)) {
                var newShotTime = LocalDateTime.now().getSecond();
                if (newShotTime - lastShotTime > 0.25) {
                    tirer();
                    lastShotTime = newShotTime;
                }
            }
        }
    }
    private void tirer() {
        Hitbox hb = new Hitbox(20, 50, personnagePrincipal.getHitbox().getPosX(), personnagePrincipal.getHitbox().getPosY()-20);
        Projectile p = new Projectile("/images/bullet.png", 100, 10, hb);
        monde.addProjectile(p);
    }
}
