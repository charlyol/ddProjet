package Affichage;

import Mecanique.Game;
import Mecanique.PersonnageHorsPlateauException;

public class Menu {

    public void affichage() {
        Display display = new Display();
        boolean shouldStart = display.start();

        if (!shouldStart) {
            System.exit(0);
        }

        Game game = new Game(display, null, null, 0);

        try {
            game.initializeGame();
            while (true) {
                game.playTurn();
            }
        } catch (PersonnageHorsPlateauException e) {
            display.notifyWin();
            boolean response = display.notifyFinishGameAndRestart();
            if (response) {
                Menu menu = new Menu();
                menu.affichage();
            } else {
                System.exit(0);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}