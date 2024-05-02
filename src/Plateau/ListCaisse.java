package Plateau;

import java.util.List;

public class ListCaisse {
    private final List<Caisse> caisses;

    public ListCaisse() {
        caisses = List.of(
                new MonsterCaisse("Sorcier", 2,9),
                new MonsterCaisse("Gobelin", 1,6),
                new MonsterCaisse("Dragon", 4,6),
                new PotionCaisse("Potion Standard", 3),
                new PotionCaisse("Grande potion", 5),
                new WarriorCaisse("Epée",5),
                new WarriorCaisse("Massue",3),
                new WizardCaisse("Boule de feu",7),
                new WizardCaisse("Eclair",7)
        );
    }

    public List<Caisse> getCaisses() {
        return caisses;
    }
}
