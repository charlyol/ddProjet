package Plateau;
import Affichage.Display;
import models.Personnages;
import personnage.Verstappen;

public class Warrior implements Chest {
    private final String name;
    private final int atk;
    Display display = new Display();

    public Warrior(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    @Override
    public void open(Personnages perso) {
        display.notifyOpenEquipement(name, atk);

        if (perso instanceof personnage.Warrior || perso instanceof Verstappen) {
            if (perso.getEquipementOffensif().getLevelAtk() < atk) {
                perso.getEquipementOffensif().setLevelAtk(atk);
                perso.getEquipementOffensif().setNom(name);
                display.notifyGetEquipement(name, atk);
            }
        } else {
            display.notifyYouAreWizzard();
        }
    }
}