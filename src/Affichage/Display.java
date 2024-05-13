package Affichage;

import Mecanique.CreatNewPersonnageException;
import personnage.Personnage;
import Mecanique.Dialog;
import personnage.Warrior;
import personnage.Wizard;


import java.util.Scanner;

public class Display {

    Scanner scanner = new Scanner(System.in);
    Dialog dialog = new Dialog();

    public boolean start() {
        boolean response = dialog.askBoolean("Commencer une nouvelle aventure ?");
        if (response) {
            System.out.println("L'aventure commence !");
        } else {
            System.out.println("Peut-être une autre fois...");
        }
        return response;
    }

    public Personnage creatPerso() {
        System.out.println("Créer un nouveau personnage");
        while (true) {
            try {
                String nom = dialog.askString("Quel est son nom ?");
                if (nom == null) {
                    throw new CreatNewPersonnageException("Création d'un nouveau personnage échouer");
                }
                System.out.println("Choisissez une classe :");
                System.out.println("1. Warrior");
                System.out.println("2. Wizard");
                System.out.print("Votre choix : ");
                int choix = scanner.nextInt();
                scanner.nextLine();
                switch (choix) {
                    case 1:
                        return new Warrior(nom);
                    case 2:
                        return new Wizard(nom);
                    default:
                        System.out.println("Invalid input: ");
                }
            } catch (CreatNewPersonnageException e) {
                System.out.println("Erreur de creation");
            }
        }
    }

    public void notifyMoveOnCase(int position) {
        System.out.println("Vous êtes actuellement sur la case " + position);
    }

    public boolean askThrowDice() {
        return dialog.askBoolean("Voulez-vous lancer le dé ?");
    }

    public boolean askFlee() {
        return dialog.askBoolean("Voulez-vous fuir ?");
    }

    public void notifyStatsPerso(Personnage personnage) {
        System.out.println(" Vie : " + personnage.getLife());
        System.out.println(" Equipement Offensif : " + personnage.getEquipementOffensif().getNom());
        System.out.println(" Points Atk : " + personnage.getEquipementOffensif().getNiveauAttaque());
        System.out.println(" Equipement Défensif : " + personnage.getEquipementDefensif().getNom());
        System.out.println(" Points Def : " + personnage.getEquipementDefensif().getNiveauDefense());
    }

    public void notifyChooseToFlee() {
        System.out.println("Peut être une autre fois...");
    }
}
