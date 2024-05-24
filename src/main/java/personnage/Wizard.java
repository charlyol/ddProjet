package personnage;

import Affichage.Display;
import Plateau.Chest;
import models.Personnages;

import java.util.List;

public class Wizard extends Personnages {

    Display display = new Display();

    public Wizard(String nom) {

        super(nom);
        this.setLife(6);
        this.setLifeMax(12);
        this.setLevelAtk(15);
        this.setLevelAtkMax(30);
        Philtre philtre = new Philtre();
        Sort sort = new Sort();
        this.setEquipementDefensif(philtre);
        this.setEquipementOffensif(sort);

        this.compatibleTypes.add(Chest.StuffType.SPELL);
        this.compatibleTypes.add(Chest.StuffType.POTION);
        this.compatibleTypes.add(Chest.StuffType.MONSTER);

    }

    @Override
    public String hurler() {
        display.notifyWizardHurle();
        return "";
    }
}
