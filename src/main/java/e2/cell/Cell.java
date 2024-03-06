package e2.cell;

import e2.Pair;

public interface Cell {
    Pair<Integer,Integer> getCellPosition();

    void moveCellTo(int newCellX, int newCellY);

    boolean isAdjacentTo(Pair<Integer, Integer> adjacentCellPosition);
}
