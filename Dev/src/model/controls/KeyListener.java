package model.controls;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import launcher.Launch;
import java.util.Set;

public class KeyListener {

    private final Set<KeyCode> activeKeys;

    public KeyListener(Set<KeyCode> activeKeys) {
        this.activeKeys = activeKeys;
        Launch.getPrimaryStage().addEventHandler(KeyEvent.KEY_PRESSED, event -> this.activeKeys.add(event.getCode()));
        Launch.getPrimaryStage().addEventHandler(KeyEvent.KEY_RELEASED, event -> this.activeKeys.remove(event.getCode()));
    }

    public Set<KeyCode> getActiveKeys() {
        return activeKeys;
    }
}
