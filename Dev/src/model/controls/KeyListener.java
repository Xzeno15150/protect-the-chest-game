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

public class KeyListener {

    private final SetProperty<KeyCode> activeKeys = new SimpleSetProperty<>();
    public SetProperty<KeyCode> activeKeysProperty() {
        return activeKeys;
    }

    public Set<KeyCode> getActiveKeys() {
        return activeKeys.get();
    }
    public void setActiveKeys(ObservableSet<KeyCode> activeKeys) {
        this.activeKeys.set(activeKeys);
    }

    public KeyListener(Set<KeyCode> activeKeys) {
        setActiveKeys(FXCollections.observableSet(activeKeys));
        Launch.getPrimaryStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> this.activeKeys.add(event.getCode()));
        Launch.getPrimaryStage().addEventHandler(KeyEvent.KEY_RELEASED, event -> this.activeKeys.remove(event.getCode()));
    }
}
