package Affichage;

import Mecanique.*;
import Plateau.*;
import personnage.Personnage;

import java.util.List;

public class Menu {

    public void affichage() {
        Display display = new Display();
        boolean shouldStart = display.start();

        if (!shouldStart) {
            System.exit(0);
        }

        Game game = new Game(display, null, null,0);

        try {
            game.initializeGame();
            System.out.println(game.getPerso().hurler());
            while (true) {
                game.playTurn();
            }
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(e.getMessage());
        }
    }
}

