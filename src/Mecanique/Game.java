package Mecanique;
import Affichage.Display;
import Plateau.Board;
import Plateau.Caisse;
import personnage.Personnage;




public class Game {

    private final Display display;
    private final Personnage perso;
    private final Board board;
    private final Jetdede lance;

    public Game(Display display, Personnage perso, Board board) {
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

                Caisse caisse = board.getCaisseList().get(perso.getPosition());
                caisse.open(perso);
            }
        }
        if (perso.getPosition() >= board.getSizeBoard().length) {
            throw new PersonnageHorsPlateauException("Félicitations vous êtes sur la case 64 ! Vous avez fini le jeu !");
        }
    }
}

