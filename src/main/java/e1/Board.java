package e1;

public interface Board {

    boolean isEmpty();

    int size();

    Pair<Integer, Integer> fillCell(int cellX, int cellY) throws IllegalArgumentException;

    int getNumberOfElements();

    void emptyCell(int cellX, int cellY) throws IllegalArgumentException;

    void resetBoard();

    boolean isCellFilled(int cellX, int cellY) throws IllegalArgumentException;
}
