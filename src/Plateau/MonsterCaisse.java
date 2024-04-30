package Plateau;

import personnage.Personnage;

public class MonsterCaisse implements Caisse {
    private final String name;
    private final int force;

    public MonsterCaisse(String name, int force) {
        this.name = name;
        this.force = force;
    }

    @Override
    public void open(Personnage perso) {
        perso.setLife(perso.getLife() - force);
    }
}
