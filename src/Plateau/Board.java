package Plateau;

import java.util.List;

public class Board {
    
    final List<Caisse> caisseList;

    public Board(List<Caisse> caisses) {
        ListCaisse listCaisse = new ListCaisse();
        this.caisseList = listCaisse.getCaisses();
    }

    public List<Caisse> getCaisseList() {
        return caisseList;
    }
}
