package Plateau;

import personnage.Personnage;

public class PotionCaisse implements Caisse {
    private final String nom;
    private final int health;

    public PotionCaisse(String name, int health) {
        this.nom = name;
        this.health = health;
    }

    @Override
    public void open(Personnage perso) {
        perso.setLife(perso.getLife() + health);
    }
}
