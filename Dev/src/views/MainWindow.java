package views;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import modele.collisions.Hitbox;
import modele.deplaceurs.personnages.DeplaceurNormal;
import modele.deplaceurs.personnages.DeplaceurPersonnage;
import modele.personnages.Personnage;
import modele.personnages.PersonnagePrincipal;

public class MainWindow{

    @FXML
    public BorderPane main;
    @FXML
    public Rectangle rectangleTest;

    @FXML
    public void initialize() {
        Personnage p = new PersonnagePrincipal("", 20, 50, 50, new Hitbox(50));
        DeplaceurPersonnage dp = new DeplaceurNormal();

        main.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP :
                    dp.deplacerVers(p, 0, -5);
                case DOWN:
                    dp.deplacerVers(p, 0, 5);
                case LEFT:
                    dp.deplacerVers(p, -5, 0);
                case RIGHT:
                    dp.deplacerVers(p, 5, 0);
            }
        });

        rectangleTest.setWidth(p.getHitbox().getLargeur());
        rectangleTest.setHeight(p.getHitbox().getLongueur());
        p.posXProperty().bind(rectangleTest.xProperty());
        p.posYProperty().bind(rectangleTest.yProperty());
    }
}
