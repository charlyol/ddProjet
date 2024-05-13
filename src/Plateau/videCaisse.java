package Plateau;

import Affichage.Display;
import personnage.Personnage;

public class videCaisse implements Caisse {
    public String nom;
    Display display = new Display();

    public videCaisse(String nom) {
        this.nom = nom;
    }
    @Override
    public void open(Personnage perso){
        display.notifyNothinghere();
    }
}
