package Mecanique;
import Affichage.Display;
import Affichage.Menu;
import Plateau.Board;
import Plateau.Caisse;
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
        this.perso = display.creatPerso();
        this.board.setSizeBoard(64);
    }


    public void playTurn() throws PersonnageHorsPlateauException {
        perso.setPosition(1);

        while (true) {
            moovePlayer();
            Caisse caisse = board.getCaisseList().get(perso.getPosition());
            caisse.open(perso);
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
            display.notifyStatsPerso(getPerso());
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

    public Personnage getPersonnage() {
        return perso;
    }
    public Personnage getPerso() {
        return perso;
    }
}

