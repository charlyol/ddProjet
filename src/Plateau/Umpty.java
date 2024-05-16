package Plateau;

import Affichage.Display;
import models.Personnages;

public class Umpty implements Chest {
    public String name;
    Display display = new Display();

    public Umpty(String name) {
        this.name = name;
    }
    @Override
    public void open(Personnages perso){
        display.notifyNothinghere();
    }
}
