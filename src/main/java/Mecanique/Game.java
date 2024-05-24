package Mecanique;

import Affichage.Display;
import Plateau.Board;
import Plateau.Chest;
import dao.GameDAO;
import dao.PersonnagesDAO;
import models.Personnages;

import java.sql.SQLException;
import java.util.List;

public class Game {

    private final Display display;
    private Personnages perso;
    private final Board board;
    private final Jetdede lance;
    private final PersonnagesDAO personnagesDAO;
    private final GameDAO gameDAO;
    private int gameId;

    public Game(Display display, List<Chest> caisses, Object o, int sizeBoard) {
        this.display = display;
        this.board = new Board(caisses, sizeBoard);
        this.lance = new Jetdede();
        this.personnagesDAO = new PersonnagesDAO();
        this.gameDAO = new GameDAO();
        this.gameId = -1;
    }

    public void initializeGame() {
        try {
            this.gameId = gameDAO.selectOrCreateGame();
            this.perso = personnagesDAO.selectOrCreatePersonnage(gameId);

            this.board.setSizeBoard(64);
        } catch (SQLException e) {
            System.err.println("Erreur de base de données : " + e.getMessage());
        }
    }

    public void playTurn() throws Exception {
        if (perso == null) {
            throw new IllegalStateException("Le personnage n'a pas été correctement initialisé.");
        }
        perso.setPosition(1);

        while (true) {
            movePlayer();
            Chest chest = board.getCaisseList().get(perso.getPosition());
            chest.open(perso);
            try {
                personnagesDAO.savePersonnage((Personnages) perso);
            } catch (SQLException e) {
                System.err.println("Erreur lors de la sauvegarde du personnage : " + e.getMessage());
            }
            if (perso.getLife() <= 0) {
                display.notifyYourAreDead();
                break;
            }
            display.notifyStatsPerso(perso);
        }
    }

    private void movePlayer() throws PersonnageHorsPlateauException {
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
}