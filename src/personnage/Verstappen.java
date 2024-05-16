package personnage;

import Affichage.Display;
import models.Personnages;

public class Verstappen extends Personnages {

    Display display = new Display();

    public Verstappen(String nom){
        super(nom);
        this.setLife(333);
        this.setLifeMax(1000);
        this.setLevelAtk(1);
        this.setLevelAtkMax(30);
        Philtre philtre = new Philtre();
        Sort sort = new Sort();
        this.setEquipementDefensif(philtre);
        this.setEquipementOffensif(sort);
    }
    @Override
    public String hurler() {
        display.notifyVerstappenHurle();
        return "";
    }
}
