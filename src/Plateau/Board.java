package Plateau;

import java.util.List;

public class Board {
    
    final List<Caisse> caisseList;
    private int[] sizeBoard;

    public Board(List<Caisse> caisses, int sizeBoard) {
        ListCaisse listCaisse = new ListCaisse();
        this.caisseList = listCaisse.getCaisses();
        this.sizeBoard = new int [sizeBoard];
    }

    public List<Caisse> getCaisseList() {
        return caisseList;
    }

    public int[] getSizeBoard() {
        return sizeBoard;
    }

    public void setSizeBoard(int sizeBoard) {
        this.sizeBoard = new int[sizeBoard];
    }

//dificulter
}
