package Mecanique;

import Affichage.Display;
import Affichage.Menu;
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
    Dialog dialog = new Dialog();


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
            relancer = display.askThrowDice();

            if (relancer) {
                display.notifyMoveOnCase(perso.getPosition());
                result = lance.jetDeDe();
                System.out.println("Vous avez fait un score de " + result + " !");
                perso.setPosition(perso.getPosition() + result);
                if (perso.getPosition() >= board.getSizeBoard().length) {
                    throw new PersonnageHorsPlateauException("Félicitations vous êtes sur la case 64 ! Vous avez fini le jeu !");
            }
        }
        Caisse caisse = board.getCaisseList().get(perso.getPosition());
        caisse.open(perso);
        if (perso.getLife() <= 0) {
            boolean response = dialog.askDeadOrNot("Bravo ! vous êtes mort ! Nouvelle partie ?");
            if (response) {
                System.out.println("L'aventure recommence ?");
                Menu menu = new Menu();
                menu.affichage();
            } else {
                System.out.println("Peut-être une autre fois...");
                System.exit(0);
            }
        }
        display.notifyStatsPerso(getPerso());
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

