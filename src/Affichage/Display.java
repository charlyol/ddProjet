package Affichage;

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
        String nom = dialog.askString("Quel est son nom ?");
        while (true) {
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
        }
    }
}
