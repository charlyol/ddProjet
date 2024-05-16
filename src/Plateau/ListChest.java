package Plateau;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListChest {
    private final List<Chest> caisses;

    public ListChest() {
        caisses = new ArrayList<>(List.of(
                new Wizard("Eclair", 2),//N°1
                new Warrior("Massue", 3),//N°2
                new Monster("Gobelin", 1, 6),//N°3
                new Wizard("Eclair", 2),//N°4
                new Warrior("Massue", 3),//N°5
                new Monster("Gobelin", 1, 6),//N°6
                new Potion("Potion Standard", 2),//N°7
                new Wizard("Eclair", 2),//N°8
                new Monster("Gobelin", 1, 6),//N°9
                new Monster("Sorcier", 2, 9),//N°10
                new Warrior("Massue", 3),//N°11
                new Monster("Gobelin", 1, 6),//N°12
                new Potion("Potion Standard", 2),//N°13
                new Monster("Gobelin", 1, 6),//N°14
                new Umpty("rien"),//N°15
                new Monster("Sorcier", 2, 9),//N°16
                new Monster("Gobelin", 1, 6),//N°17
                new Warrior("Epée", 5),//N°18
                new Monster("Sorcier", 2, 9),//N°19
                new Monster("Gobelin", 1, 6),//N°20
                new Warrior("Massue", 3),//N°21
                new Wizard("Eclair", 2),//N°22
                new Monster("Gobelin", 1, 6),//N°23
                new Monster("Sorcier", 2, 9),//N°24
                new Warrior("Epée", 5),//N°25
                new Monster("Gobelin", 1, 6),//N°26
                new Potion("Grande potion", 5),//N°27
                new Umpty("rien"),//N°28
                new Monster("Gobelin", 1, 6),//N°29
                new Potion("Potion Standard", 2),//N°30
                new Monster("Sorcier", 2, 9),//N°31
                new Potion("Potion Standard", 2),//N°32
                new Wizard("Eclair", 2),//N°33
                new Monster("Sorcier", 2, 9),//N°34
                new Monster("Sorcier", 2, 9),//N°35
                new Monster("Sorcier", 2, 9),//N°36
                new Warrior("Massue", 3),//N°37
                new Potion("Potion Standard", 2),//N°38
                new Monster("Sorcier", 2, 9),//N°39
                new Potion("Grande potion", 5),//N°40
                new Warrior("Epée", 5),//N°41
                new Potion("Potion Standard", 2),//N°42
                new Monster("Sorcier", 2, 9),//N°43
                new Monster("Dragon", 4, 15),//N°44
                new Warrior("Massue", 3),//N°45
                new Monster("Sorcier", 2, 9),//N°46
                new Wizard("Boule de feu", 7),//N°47
                new Wizard("Boule de feu", 7),//N°48
                new Umpty("rien"),//N°49
                new Umpty("rien"),//N°50
                new Monster("Sorcier", 2, 9),//N°51
                new Umpty("rien"),//N°52
                new Umpty("rien"),//N°53
                new Umpty("rien"),//N°54
                new Monster("Sorcier", 2, 9),//N°55
                new Umpty("rien"),//N°56
                new Umpty("rien"),//N°57
                new Umpty("rien"),//N°58
                new Umpty("rien"),//N°59
                new Umpty("rien"),//N°60
                new Monster("Sorcier", 2, 9),//N°61
                new Umpty("rien"),//N°62
                new Umpty("rien"),//N°63
                new Umpty("rien")//N°64
        ));

        shuffle(caisses);
    }
    private void shuffle(List<Chest> caisses) {
        Random random = new Random();
        for (int i = caisses.size() - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Chest temp = caisses.get(i);
            caisses.set(i, caisses.get(index));
            caisses.set(index, temp);
        }
    }


    public List<Chest> getCaisses() {
        return caisses;
    }
}
