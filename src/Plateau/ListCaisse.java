package Plateau;

import java.util.List;

public class ListCaisse {
    private final List<Caisse> caisses;

    public ListCaisse() {
        caisses = List.of(
                new PotionCaisse("Potion Standard", 3),
                new MonsterCaisse("gobelin", 13)
        );
    }

    public List<Caisse> getCaisses() {
        return caisses;
    }
}
