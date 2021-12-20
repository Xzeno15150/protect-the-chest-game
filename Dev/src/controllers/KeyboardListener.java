package controllers;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import launch.Launcher;

import java.util.HashSet;
import java.util.Set;

public class KeyboardListener {
    private final Set<KeyCode> activeKeys;

    // Contructor
    public KeyboardListener(){
        activeKeys = new HashSet<>();
        createListener();
    }

    // Getter
    public Set<KeyCode> getActiveKeys() {
        return activeKeys;
    }

    // Methods
    public void createListener() {
        Launcher.getStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> activeKeys.add(event.getCode()));
        Launcher.getStage().addEventHandler(KeyEvent.KEY_RELEASED, event -> activeKeys.remove(event.getCode()));
    }

}
