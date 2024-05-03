package Plateau;

import personnage.Personnage;

public class videCaisse implements Caisse {
    private String nom;

    public videCaisse(String nom) {
        this.nom = nom;
    }
    @Override
    public void open(Personnage perso){
        System.out.println("il n'y a rien ici");
    }
}
