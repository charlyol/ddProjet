package Mecanique;
import Affichage.Display;
import Plateau.Caisse;
import personnage.Personnage;

import java.util.List;


public class Game {

    private final Display display;
    private final Personnage perso;
    private final List<Caisse> board;
    private final Jetdede lance;

    public Game(Display display, Personnage perso, List<Caisse> board) {
        this.display = display;
        this.perso = perso;
        this.board = board;
        this.lance = new Jetdede();
    }


    public void playTurn() throws PersonnageHorsPlateauException {
        int result;
        boolean relancer = true;
        perso.setPosition(1);

        while (relancer) {
            display.notifyMoveOnCase(perso.getPosition());
            relancer = display.askThrowDice();

            if (relancer) {
                result = lance.jetDeDe();
                System.out.println("Vous avez fait un score de " + result + " !");
                perso.setPosition(perso.getPosition() + result);

                Caisse caisse = board.get(perso.getPosition());
                caisse.open(perso);
            }
        }
        if (perso.getPosition() > 64) {
            throw new PersonnageHorsPlateauException("Félicitations vous êtes sur la case 64 ! Vous avez fini le jeu !");
        }
    }
}

