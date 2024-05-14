package Plateau;

import Affichage.Display;
import Mecanique.Jetdede;
import personnage.Personnage;


public class MonsterCaisse implements Caisse {
    private final String name;
    private final int atk;
    private final int life;
    private final Jetdede lance;
    Display display = new Display();

    public MonsterCaisse(String name, int atk, int life) {
        this.name = name;
        this.atk = atk;
        this.life = life;
        this.lance = new Jetdede();
    }

    @Override
    public void open(Personnage perso) {
        display.notifyMeetMonster(name, atk, life);

        boolean response = display.notifyFigthOrFlee();
        if (response) {
            int monsterLife = life;
            while (perso.getLife() > 0 && monsterLife > 0) {
                if (perso.getEquipementDefensif().getNiveauDefense() - atk < 0) {
                    perso.setLife(perso.getLife() + perso.getEquipementDefensif().getNiveauDefense() - atk);
                    int toto = perso.getEquipementDefensif().getNiveauDefense() - atk;
                    if (toto < 0) {
                        display.notifyDefMonster(name, toto);
                        if (perso.getLife() <= 0) {
                            return;
                        }
                    }
                } else {
                    display.notifyDontTouch(name);
                }
                monsterLife = monsterLife - perso.getEquipementOffensif().getNiveauAttaque();
                if (monsterLife < 0) {
                    monsterLife = 0;
                    display.notifyAtkMonster(name, perso.getEquipementOffensif().getNiveauAttaque(), monsterLife);
                } else {
                    display.notifyAtkMonster(name, perso.getEquipementOffensif().getNiveauAttaque(), monsterLife);
                }
                if (monsterLife == 0) {
                    display.notifyMonsterDead(name);
                }
            }
        } else {
            int result = lance.jetDeDe();
            perso.setPosition(perso.getPosition()-result);
            display.notifyLoosePosition(result);
            display.notifyMoveOnCase(perso.getPosition());

        }
    }
}