package Plateau;

import Affichage.Display;
import models.Personnages;
import personnage.Verstappen;
import personnage.Warrior;

public class Spell implements Chest {
    private final String name;
    private final int atk;
    StuffType stuffType = StuffType.SPELL;
    Display display = new Display();

    public Spell(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    @Override
    public void open(Personnages perso) {
        if (perso.isCompatibleWith(stuffType)) {
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
        } else {
            display.notifyYouAreWarrior();
        }
    }

    @Override
    public StuffType getType() {
        return stuffType;
    }
}
