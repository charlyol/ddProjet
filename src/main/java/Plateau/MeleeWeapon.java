package Plateau;
import Affichage.Display;
import models.Personnages;

public class MeleeWeapon implements Chest {
    private final String name;
    private final int atk;
    StuffType stuffType = StuffType.MELEE_WEAPON;
    Display display = new Display();

    public MeleeWeapon(String name, int atk) {
        this.name = name;
        this.atk = atk;
    }

    @Override
    public void open(Personnages perso) {
        if (perso.isCompatibleWith(stuffType))  {
            display.notifyOpenEquipement(name, atk);
            if (perso.getEquipementOffensif().getLevelAtk() < atk) {
                perso.getEquipementOffensif().setLevelAtk(atk);
                perso.getEquipementOffensif().setNom(name);
                display.notifyGetEquipement(name, atk);
            }
        } else {
            display.notifyYouAreWizzard();
        }
    }

    @Override
    public StuffType getType() {
        return stuffType;
    }
}