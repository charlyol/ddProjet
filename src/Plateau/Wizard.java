package Plateau;

import Affichage.Display;
import models.Personnages;
import personnage.Verstappen;
import personnage.Warrior;

public class Wizard implements Chest {
    private final String name;
    private final int atk;
    Display display = new Display();

    public Wizard(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    @Override
    public void open(Personnages perso) {
        display.notifyOpenEquipement(name, atk);
        if (perso instanceof Warrior || perso instanceof Verstappen) {
            if (perso.getEquipementOffensif().getLevelAtk() < atk) {
                perso.getEquipementOffensif().setLevelAtk(atk);
                perso.getEquipementOffensif().setNom(name);
                display.notifyGetEquipement(name, atk);
            }
        } else {
            display.notifyYouAreWarrior();
        }
    }
}
