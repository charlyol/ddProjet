package Plateau;

import java.util.List;

public class Board {
    
    final List<Chest> chestList;
    private int[] sizeBoard;

    public Board(List<Chest> chest, int sizeBoard) {
        ListChest listChest = new ListChest();
        this.chestList = listChest.getCaisses();
        this.sizeBoard = new int [sizeBoard];
    }

    public List<Chest> getCaisseList() {
        return chestList;
    }

    public int[] getSizeBoard() {
        return sizeBoard;
    }

    public void setSizeBoard(int sizeBoard) {
        this.sizeBoard = new int[sizeBoard];
    }

//dificulter
}
