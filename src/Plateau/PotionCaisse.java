package Plateau;

import personnage.Personnage;

public class PotionCaisse implements Caisse {
    private final int health;

    public PotionCaisse(int health) {
        this.health = health;
    }

    @Override
    public void open(Personnage perso) {
        perso.setLife(perso.getLife() + health);
    }
}
