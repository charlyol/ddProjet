package Plateau;

import java.util.List;

public class ListCaisse {
    private final List<Caisse> caisses;

    public ListCaisse() {
        caisses = List.of(
                new WizardCaisse("Eclair", 2),//N°1
                new WarriorCaisse("Massue", 3),//N°2
                new MonsterCaisse("Gobelin", 1, 6),//N°3
                new WizardCaisse("Eclair", 2),//N°4
                new WarriorCaisse("Massue", 3),//N°5
                new MonsterCaisse("Gobelin", 1, 6),//N°6
                new PotionCaisse("Potion Standard", 2),//N°7
                new WizardCaisse("Eclair", 2),//N°8
                new MonsterCaisse("Gobelin", 1, 6),//N°9
                new MonsterCaisse("Sorcier", 2, 9),//N°10
                new WarriorCaisse("Massue", 3),//N°11
                new MonsterCaisse("Gobelin", 1, 6),//N°12
                new PotionCaisse("Potion Standard", 2),//N°13
                new MonsterCaisse("Gobelin", 1, 6),//N°14
                new videCaisse("rien"),//N°15
                new MonsterCaisse("Sorcier", 2, 9),//N°16
                new MonsterCaisse("Gobelin", 1, 6),//N°17
                new WarriorCaisse("Epée", 5),//N°18
                new MonsterCaisse("Sorcier", 2, 9),//N°19
                new MonsterCaisse("Gobelin", 1, 6),//N°20
                new WarriorCaisse("Massue", 3),//N°21
                new WizardCaisse("Eclair", 2),//N°22
                new MonsterCaisse("Gobelin", 1, 6),//N°23
                new MonsterCaisse("Sorcier", 2, 9),//N°24
                new WarriorCaisse("Epée", 5),//N°25
                new MonsterCaisse("Gobelin", 1, 6),//N°26
                new PotionCaisse("Grande potion", 5),//N°27
                new videCaisse("rien"),//N°28
                new MonsterCaisse("Gobelin", 1, 6),//N°29
                new PotionCaisse("Potion Standard", 2),//N°30
                new MonsterCaisse("Sorcier", 2, 9),//N°31
                new PotionCaisse("Potion Standard", 2),//N°32
                new WizardCaisse("Eclair", 2),//N°33
                new MonsterCaisse("Sorcier", 2, 9),//N°34
                new MonsterCaisse("Sorcier", 2, 9),//N°35
                new MonsterCaisse("Sorcier", 2, 9),//N°36
                new WarriorCaisse("Massue", 3),//N°37
                new PotionCaisse("Potion Standard", 2),//N°38
                new MonsterCaisse("Sorcier", 2, 9),//N°39
                new PotionCaisse("Grande potion", 5),//N°40
                new WarriorCaisse("Epée", 5),//N°41
                new PotionCaisse("Potion Standard", 2),//N°42
                new MonsterCaisse("Sorcier", 2, 9),//N°43
                new MonsterCaisse("Dragon", 4, 15),//N°44
                new WarriorCaisse("Massue", 3),//N°45
                new MonsterCaisse("Sorcier", 2, 9),//N°46
                new WizardCaisse("Boule de feu", 7),//N°47
                new WizardCaisse("Boule de feu", 7),//N°48
                new videCaisse("rien"),//N°49
                new videCaisse("rien"),//N°50
                new MonsterCaisse("Sorcier", 2, 9),//N°51
                new videCaisse("rien"),//N°52
                new videCaisse("rien"),//N°53
                new videCaisse("rien"),//N°54
                new MonsterCaisse("Sorcier", 2, 9),//N°55
                new videCaisse("rien"),//N°56
                new videCaisse("rien"),//N°57
                new videCaisse("rien"),//N°58
                new videCaisse("rien"),//N°59
                new videCaisse("rien"),//N°60
                new MonsterCaisse("Sorcier", 2, 9),//N°61
                new videCaisse("rien"),//N°62
                new videCaisse("rien"),//N°63
                new videCaisse("rien")//N°64
        );

    }

    public List<Caisse> getCaisses() {
        return caisses;
    }
}
