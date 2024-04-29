package Affichage;

import Mecanique.Yn;

public class Display {
    public static void start() {
        Yn yn = new Yn();
        String response = yn.ask("Commencer une nouvelle aventure ?");

        if (response.equals("y")) {
            System.out.println("L'aventure commence !");
        } else if (response.equals("n")) {
            System.out.println("Peut-être une autre fois...");
        }
    }
}
