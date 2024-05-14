package Plateau;
import Affichage.Display;
import personnage.Personnage;
import personnage.Warrior;
import personnage.Verstappen;

public class WarriorCaisse implements Caisse {
    private final String name;
    private final int attaque;
    Display display = new Display();

    public WarriorCaisse(String name, int attaque) {
        this.name = name;
        this.attaque = attaque;
    }

    @Override
    public void open(Personnage perso) {
        display.notifyOpenEquipement(name,attaque);

        if (perso instanceof Warrior || perso instanceof Verstappen) {
            if (perso.getEquipementOffensif().getNiveauAttaque() < attaque) {
                perso.getEquipementOffensif().setNiveauAttaque(attaque);
                perso.getEquipementOffensif().setNom(name);
                display.notifyGetEquipement(name,attaque);
            }
        } else {
            display.notifyYouAreWizzard();
        }
    }
}