package keyListeners;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyPressedHandler implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case UP :
                System.out.println("up");
            case DOWN:
                System.out.println("down");
            case LEFT:
                System.out.println("left");
            case RIGHT:
                System.out.println("right");
        }
    }
}
