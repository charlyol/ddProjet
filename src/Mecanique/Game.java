package Mecanique;

import Affichage.Display;
import Plateau.Board;
import Plateau.Caisse;
import Plateau.ListCaisse;
import personnage.Personnage;

import java.util.List;


public class Game {

    private final Display display;
    private Personnage perso;
    private final Board board;
    private final Jetdede lance;

    public Game(Display display, Personnage perso, List<Caisse> caisses, int sizeBoard) {
        this.display = display;
        this.perso = perso;
        this.board = new Board(caisses, sizeBoard);
        this.lance = new Jetdede();
    }


    public void initializeGame() {
        Display display = this.display;
        ListCaisse listCaisse = new ListCaisse();
        List<Caisse> caisses = listCaisse.getCaisses();
        this.perso = display.creatPerso();
        this.board.setSizeBoard(64);
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
                if (perso.getPosition() >= board.getSizeBoard().length) {
                    throw new PersonnageHorsPlateauException("Félicitations vous êtes sur la case 64 ! Vous avez fini le jeu !");
                }
                Caisse caisse = board.getCaisseList().get(perso.getPosition());
                caisse.open(perso);
                display.notifyStatsPerso(getPerso());
            }
        }
    }

    public Personnage getPersonnage() {
        return perso;
    }

    public Board getBoard() {
        return board;
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

}

