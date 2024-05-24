package personnage;

import Affichage.Display;
import Plateau.Chest;
import models.Personnages;

public class Warrior extends Personnages {

    Display display = new Display();

    public Warrior(String nom) {

        super(nom);
        this.setLife(10);
        this.setLevelAtk(10);
        this.setLifeMax(20);
        this.setLevelAtkMax(20);
        Arme arme = new Arme();
        Bouclier bouclier = new Bouclier();
        this.setEquipementOffensif(arme);
        this.setEquipementDefensif(bouclier);

        this.compatibleTypes.add(Chest.StuffType.MELEE_WEAPON);
        this.compatibleTypes.add(Chest.StuffType.POTION);
        this.compatibleTypes.add(Chest.StuffType.MONSTER);
    }

    @Override
    public String hurler() {
        display.notifyWarriorHurle();
        return "";
    }
}
