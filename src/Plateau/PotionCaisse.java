package Plateau;

import Affichage.Display;
import personnage.Personnage;

public class PotionCaisse implements Caisse {
    private final String nom;
    private final int health;
    Display display = new Display();

    public PotionCaisse(String name, int health) {
        this.nom = name;
        this.health = health;
    }

    @Override
    public void open(Personnage perso) {
        int newLife = perso.getLife() + health;
        int lifeMax = perso.getLifeMax();
        display.notifyOpenCaisseLife(nom, health);

        perso.setLife(Math.min(newLife, lifeMax));

        if (lifeMax <= newLife) {
            display.notifyLifeMax();
        } else {
            display.notifyGetLife(nom, health);
        }
    }
}
