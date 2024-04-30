package Plateau;

import java.util.List;

public class Board {
    
    final List<Caisse> caisseList;
    
    

    public Board(List<Caisse> caisseList) {
        this.caisseList = caisseList;
        
    }

    public List<Caisse> getCaisseList() {
        return caisseList;
    }
}
