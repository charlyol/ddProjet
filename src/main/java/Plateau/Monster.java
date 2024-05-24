package Plateau;

import Affichage.Display;
import Mecanique.Jetdede;
import models.Personnages;


public class Monster implements Chest {
    private final String name;
    private final int atk;
    private final int life;
    private final Jetdede lance;
    StuffType stuffType = StuffType.MONSTER;
    Display display = new Display();

    public Monster(String name, int atk, int life) {
        this.name = name;
        this.atk = atk;
        this.life = life;
        this.lance = new Jetdede();
    }

    @Override
    public void open(Personnages perso) {
        if (perso.isCompatibleWith(stuffType)) {
            display.notifyMeetMonster(name, atk, life);
            boolean response = display.notifyFigthOrFlee();
            if (response) {
                int monsterLife = life;
                while (perso.getLife() > 0 && monsterLife > 0) {
                    if (perso.getEquipementDefensif().getLevelDef() - atk < 0) {
                        perso.setLife(perso.getLife() + perso.getEquipementDefensif().getLevelDef() - atk);
                        int toto = perso.getEquipementDefensif().getLevelDef() - atk;
                        if (toto < 0) {
                            display.notifyDefMonster(name, toto);
                            if (perso.getLife() <= 0) {
                                return;
                            }
                        }
                    } else {
                        display.notifyDontTouch(name);
                    }
                    monsterLife = monsterLife - perso.getEquipementOffensif().getLevelAtk();
                    if (monsterLife < 0) {
                        monsterLife = 0;
                        display.notifyAtkMonster(name, perso.getEquipementOffensif().getLevelAtk(), monsterLife);
                    } else {
                        display.notifyAtkMonster(name, perso.getEquipementOffensif().getLevelAtk(), monsterLife);
                    }
                    if (monsterLife == 0) {
                        display.notifyMonsterDead(name);
                    }
                }
            } else {
                int result = lance.jetDeDe();
                perso.setPosition(perso.getPosition() - result);
                display.notifyLoosePosition(result);
                display.notifyMoveOnCase(perso.getPosition());

            }
        } else {
            display.notifyNothinghere();
        }
    }

    @Override
    public StuffType getType() {
        return stuffType;
    }
}