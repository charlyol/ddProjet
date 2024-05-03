package Plateau;

import personnage.Personnage;

import personnage.Wizard;

public class WizardCaisse implements Caisse {
    private final String name;
    private final int attaque;

    public WizardCaisse(String name, int attaque) {
        this.name = name;
        this.attaque = attaque;
    }

    @Override
    public void open(Personnage perso) {
        System.out.println(" Caisse de " + name + " de " + attaque + " Atk ouverte ");
        if (perso instanceof Wizard) {
            if (perso.getEquipementOffensif().getNiveauAttaque() < attaque) {
                perso.getEquipementOffensif().setNiveauAttaque(attaque);
                perso.getEquipementOffensif().setNom(name);
                System.out.println(" Vous venez d'avoir " + name + " de " + attaque + " Atk ");
            }
        } else {
            System.out.println(" Vous êtes un Warrior vous ne pouvez pas l'utilisez ");
        }
    }
}
