package views;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MainWindow implements KeyListener {

    @FXML
    public TextArea textTest;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();
        textTest.appendText("^");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @FXML
    public void initialize() {

    }
}
