package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.ListChangeListener;
import javafx.scene.input.KeyCode;
import model.boucles.BoucleDeJeu;
import model.deplacement.DeplaceurNormalVitesse2;
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

import java.util.HashSet;

/**
 * le Manager permet de gerer les données de l'application
 */
public class Manager {

    private final IntegerProperty numManche= new SimpleIntegerProperty(0);
        /**
         * Numéro de la manche actuelle
         * @return Retourne le numéro de la manche
         */
        public int getNumManche() {
                return numManche.get();
            }
        /**
         * Proriété qui encapsule le numéro de la manche
         * @return L'instance de la propriété
         */
        public IntegerProperty numMancheProperty() {
                return numManche;
            }
        /**
         * Change le numéro de la manche actuelle
         * @param numManche Noueau numéro de la manche
         */
        public void setNumManche(int numManche) {
                this.numManche.set(numManche);
            }

    private final IntegerProperty nbVie = new SimpleIntegerProperty();
        /**
         * Retourne le nombre de vie(s) restante(s)
         * @return Nombre de vie(s)
         */
        public int getNbVie() {
                return nbVie.get();
            }
        /**
         * Propriété qui encapsule le nombre de vie
         * @return L'instance de la propriété
         */
        public IntegerProperty nbVieProperty() {
                return nbVie;
            }
        /**
         * Change le nombre de vie restante
         * @param nbVie Nouveau nombre de vie
         */
        public void setNbVie(int nbVie) {
                this.nbVie.set(nbVie);
            }

    private final BooleanProperty gameRunning= new SimpleBooleanProperty();
        /**
         * Propriété qui encapsule gameRunning
         * @return L'instance de la propriété
         */
        public BooleanProperty gameRunningProperty(){
                return gameRunning;
            }
        /**
         * Change la valeur de gameRunning
         * @param gameRunning Nouvelle valeur de gameRunning
         */
        public void setGameRunning(boolean gameRunning) {
                this.gameRunning.set(gameRunning);
            }
        /**
         * Retourne la valeur de gameRunning
         * @return Retourne un booleen
         */
        public boolean isGameRunning() {
                return gameRunning.get();
            }

    private final IntegerProperty bestScore = new SimpleIntegerProperty();
        /**
         * Retourne la meilleur score
         * @return Retourne le meilleur score
         */
        public int getBestScore() {
        return bestScore.get();
    }
        /**
         * Propriété qui encapsule le meilleur score
         * @return L'instance de la propriété
         */
        public IntegerProperty bestScoreProperty() {
        return bestScore;
    }
        /**
         * Change la valeur de bestScore
         * @param bestScore Nouveau meilleurScore
         */
        public void setBestScore(int bestScore) {
        this.bestScore.set(bestScore);
    }

    private final Loader loader = new Stub();
    private DeplaceurNormal deplaceur;
    private Collisionneur collisionneur;
    private Monde monde;
    private long lastShotTime;
    private Observer animateurProjectile;
    private Observer observateurPrincipal;
    private IASimple iaSimple;
    private KeyListener keyListener;

    /**
     * Méthode d'initialisation de l'objet.
     *
     * Elle est appelé après l'instanciation de l'objet pour initialiser toutes les variables
     * Récupère les données depuis un loader
     */
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

        animateurProjectile = new AnimateurProjectile(collisionneur, this);
        observateurPrincipal = new ObservateurPrincipal(this);
        iaSimple = new IASimple(this, collisionneur);
    }

    /**
     * Méthode de lancement de la partie
     *
     * Est appellé lors du lancement du jeu
     * Lance la boucle de jeu, et commence la première manche
     */
    public void startGame() {
        setGameRunning(true);
        setNbVie(3);
        setNumManche(0);
        BoucleDeJeu boucle = new Boucle120FPS(new HashSet<>(), this);
        boucle.attacher(animateurProjectile);
        boucle.attacher(observateurPrincipal);
        boucle.attacher(iaSimple);
        Thread mainBoucle = new Thread(boucle);
        mainBoucle.start();

        monde.createRandomPosEnnemi();
    }

    /**
     * Déplace le personnage en fonction des touches appuyées
     * Z : haut
     * S : Bas
     * Q : Gauche
     * D : Droite
     */
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

    /**
     * Tire un projectile devant le personnage lorsque la touche SPACE est appuyée
     * Le tir n'est possible que toutes les 0.75 secondes
     */
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

    /**
     * Passe à la manche suivante, ce qui créer un nouvel ennemi
     */
    public void mancheSuivante() {
        setNumManche(getNumManche()+1);
        monde.createRandomPosEnnemi();
    }

    /**
     * Tue un ennemi dans le monde
     * @param ennemi Ennemi à tuer
     */
    public void tuer(Ennemi ennemi) {
        monde.removeEntite(ennemi);
    }

    /**
     * Retire une vie au nombre de vie
     * Arrête la partie si le nombre de vie passe à 0
     */
    public void retirerVie() {
        setNbVie(getNbVie() - 1);
        if (getNbVie() == 0) {
            changeBestScore();
            setGameRunning(false);
        }
    }

    /**
     * Change le meilleur score si le score de cette partie est plus grand que le meilleur score actuel
     */
    public void changeBestScore() {
        if (getNumManche() > getBestScore()) {
            setBestScore(getNumManche());
        }
    }

    /**
     * Retourne l'instance du monde
     * @return L'instance du monde
     */
    public Monde getMonde() {
        return monde;
    }
}
