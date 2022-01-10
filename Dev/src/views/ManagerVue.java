package views;

import controllers.Manager;
import javafx.collections.ListChangeListener;
import launch.Launcher;
import modele.projectiles.Projectile;

public class ManagerVue {

    public void addListenerToProjectileCollection() {
        Manager mgr = Launcher.getManager();
        mgr.getMonde().lesProjectilesProperty().addListener((ListChangeListener<? super Projectile>)  c -> {
            while(c.next()) {
                if (c.wasAdded()) {
                    Launcher.getMainWindow().ajouterProjectile(c.getAddedSubList().get(0));
                }
            }
        });
    }
}
