package Plateau;

import personnage.Personnage;

public class WarriorCaisse implements Caisse{
    private final String name;
    private final int attaque;

    public WarriorCaisse(String name, int attaque) {
        this.name = name;
        this.attaque = attaque;
    }

    @Override
    public void open(Personnage perso){
        perso.setLevelAtk(perso.getLevelAtk() + attaque);
    }
}