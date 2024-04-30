package Affichage;

import personnage.Personnage;

public class Menu {

    public void affichage() {
        Display start = new Display();
        boolean shouldStart = start.start();

        if (!shouldStart) {
            System.exit(0);
        }

        Personnage perso = start.creatPerso();

        start.launcherGame(perso);

//        System.out.println(perso.getNom());
//        System.out.println(perso.getLife());
//        perso.setLife(perso.getLife()+10);
//        System.out.println(perso.getLife());
//        System.out.println(perso.getEquipementOffensif().getNom());
//        System.out.println(perso.getEquipementOffensif().getNiveauAttaque());


    }
}
