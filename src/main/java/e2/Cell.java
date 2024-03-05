package e2;

public interface Cell {
    Pair<Integer,Integer> getCellPosition();

    void moveCellTo(int newCellX, int newCellY);

    boolean isAdjacentTo(Pair<Integer, Integer> adjacentCellPosition);
}
