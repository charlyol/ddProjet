package Plateau;

import personnage.Personnage;

public class MonsterCaisse implements Caisse {
    private String name;
    private int atk;
    private int life;

    public MonsterCaisse(String name, int atk, int life) {
        this.name = name;
        this.atk = atk;
        this.life = life;
    }

    @Override
    public void open(Personnage perso) {
        System.out.println("Rencontre avec un " + name + " d'une puissance de " + atk + " Atk " + " avec " + life + " PV ");
        int monsterLife = life;
        while (perso.getLife() > 0 && monsterLife > 0) {
            if (perso.getEquipementDefensif().getNiveauDefense() - atk < 0) {
                perso.setLife(perso.getLife() + perso.getEquipementDefensif().getNiveauDefense() - atk);
                int toto = perso.getEquipementDefensif().getNiveauDefense() - atk;
                if (life < 0){
                    life=0;
                }
                System.out.println(" Le " + name + " vous enlève " + toto + " de PV ");
            } else {
                System.out.println(" Le " + name + " ne vous touche pas ");
            }
            monsterLife = monsterLife - perso.getEquipementOffensif().getNiveauAttaque();
            System.out.println(" vous avez touchez le " + name + " il est perd " + perso.getEquipementOffensif().getNiveauAttaque() + " PV de vie, il lui reste maintenant " + life + " de vie");

            if (monsterLife == 0){
                System.out.println(" Le " + name + " est mort bravo ! ");
            }
        }
    }
}
