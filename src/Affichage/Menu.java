package Affichage;

import Mecanique.*;
import Plateau.Board;
import Plateau.Caisse;
import Plateau.MonsterCaisse;
import Plateau.PotionCaisse;
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
        List<Caisse> caisses = List.of(
                new PotionCaisse("Potion Standard",3),
                new MonsterCaisse("gobelin", 13)
        );


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
