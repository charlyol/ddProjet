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

        Personnage perso = display.creatPerso();

        ListCaisse listCaisse = new ListCaisse();
        List<Caisse> caisses = listCaisse.getCaisses();


        Game game = new Game(display, perso, new Board(caisses));

        try {
            System.out.println(perso.hurler());
            while (true) {
                game.playTurn();
            }
        } catch (PersonnageHorsPlateauException e) {
            System.out.println(e.getMessage());
        }

//        System.out.println(perso.getNom());
//        System.out.println(perso.getLife());
//        perso.setLife(perso.getLife()+10);
//        System.out.println(perso.getLife());
//        System.out.println(perso.getEquipementOffensif().getNom());
//        System.out.println(perso.getEquipementOffensif().getNiveauAttaque());


    }
}
