package Mecanique;

import Affichage.Display;
import Affichage.Menu;
import Plateau.Board;
import Plateau.Chest;
import dao.PersonnagesDAO;
import models.Personnages;

import java.util.List;

public class Game {

    private final Display display;
    private Personnages perso;
    private final Board board;
    private final Jetdede lance;
    private final PersonnagesDAO personnagesDAO;

    public Game(Display display, Personnages perso, List<Chest> caisses, int sizeBoard) {
        this.display = display;
        this.perso = perso;
        this.board = new Board(caisses, sizeBoard);
        this.lance = new Jetdede();
        this.personnagesDAO = new PersonnagesDAO();
    }

    public void initializeGame() {
        this.perso = display.creatPerso();
        this.board.setSizeBoard(64);
    }

    public void playTurn() throws PersonnageHorsPlateauException {
        perso.setPosition(1);

        while (true) {
            moovePlayer();
            Chest chest = board.getCaisseList().get(perso.getPosition());
            chest.open(perso);
            personnagesDAO.savePersonnage(perso);
            if (perso.getLife() <= 0) {
                boolean response = display.notifyYourAreDead();
                if (response) {
                    display.notifyStartAventure();
                    Menu menu = new Menu();
                    menu.affichage();
                } else {
                    display.notifyByeBye();
                    System.exit(0);
                }
            }
            display.notifyStatsPerso(perso);
        }
    }

    private void moovePlayer() throws PersonnageHorsPlateauException {
        int result;
        while (true) {
            if (display.askThrowDice()) {
                display.notifyMoveOnCase(perso.getPosition());
                result = lance.jetDeDe();
                display.notifyResultDice(result);
                perso.setPosition(perso.getPosition() + result);
                display.notifyNewCaseNow(perso.getPosition());
                if (perso.getPosition() >= board.getSizeBoard().length) {
                    throw new PersonnageHorsPlateauException();
                }
                return;
            }

            if (display.askFlee()) {
                display.notifyByeBye();
                System.exit(0);
            }
        }
    }

    public Personnages getPersonnage() {
        return perso;
    }

    public Personnages getPerso() {
        return perso;
    }
}
