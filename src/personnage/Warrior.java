package personnage;

import Affichage.Display;

public class Warrior extends Personnage {

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

    }

    @Override
    public String hurler() {
        display.notifyWarriorHurle();
        return "";
    }
}
