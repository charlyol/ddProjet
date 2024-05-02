package Plateau;

import personnage.Personnage;

public class MonsterCaisse implements Caisse {
    private final String name;
    private final int atk;
    private final int life;

    public MonsterCaisse(String name, int atk,int life) {
        this.name = name;
        this.atk = atk;
        this.life = life;
    }

    @Override
    public void open(Personnage perso) {
        perso.setLife(perso.getLife() - atk);
    }
}
