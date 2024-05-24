package Plateau;

import Affichage.Display;
import models.Personnages;

public class Empty implements Chest {
    public String name;
    Display display = new Display();

    public Empty(String name) {
        this.name = name;
    }
    @Override
    public void open(Personnages perso){
        display.notifyNothinghere();
    }

    @Override
    public StuffType getType() {
        return null;
    }
}
