package model.controls;

import javafx.beans.property.SetProperty;
import javafx.beans.property.SimpleSetProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableSet;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import launcher.Launch;

import java.beans.EventHandler;
import java.util.Set;

/**
 * KeyListener permet de garder les touches appuyées dans une liste
 */
public class KeyListener {

    private final SetProperty<KeyCode> activeKeys = new SimpleSetProperty<>();

    /**
     * récupère la lise des touches appuyées
     * @return retourne la liste des touches appuyées (SetProperty)
     */
    public SetProperty<KeyCode> activeKeysProperty() {
        return activeKeys;
    }

    /**
     * récupère la liste des touches appuyées
     * @return retourne la liste des touches appuyées (Set)
     */
    public Set<KeyCode> getActiveKeys() {
        return activeKeys.get();
    }

    /**
     * change la liste des touches appuyées
     * @param activeKeys change la liste des touches appuyées par activeKeys (ObservableSet)
     */
    public void setActiveKeys(ObservableSet<KeyCode> activeKeys) {
        this.activeKeys.set(activeKeys);
    }

    /**
     * constructeur de la classe KeyListener qui récupère les touches et ajoute/retire dans la liste les touches préssées
     * @param activeKeys prend en parametre activeKeys qui est la liste des touches préssées (Set)
     */
    public KeyListener(Set<KeyCode> activeKeys) {
        setActiveKeys(FXCollections.observableSet(activeKeys));
        Launch.getPrimaryStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> this.activeKeys.add(event.getCode()));
        Launch.getPrimaryStage().addEventHandler(KeyEvent.KEY_RELEASED, event -> this.activeKeys.remove(event.getCode()));
    }
}
