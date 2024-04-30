package Plateau;

import java.util.List;

public class ListCaisse {
ListCaisse(){
    List<Caisse> caisses = List.of(
            new PotionCaisse("Potion Standard",3),
            new MonsterCaisse("gobelin", 13)
    );
}
}
