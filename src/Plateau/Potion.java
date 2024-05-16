package Plateau;

import Affichage.Display;
import models.Personnages;

public class Potion implements Chest {
    private final String name;
    private final int life;
    Display display = new Display();

    public Potion(String name, int life) {
        this.name = name;
        this.life = life;
    }

    @Override
    public void open(Personnages perso) {

        int newLife = perso.getLife() + life;
        int lifeMax = perso.getLifeMax();
        display.notifyOpenCaisseLife(name, life);
        perso.setLife(Math.min(newLife, lifeMax));

        if (lifeMax <= newLife) {
            display.notifyLifeMax();
        } else {
            display.notifyGetLife(name, life);
        }
    }
}
