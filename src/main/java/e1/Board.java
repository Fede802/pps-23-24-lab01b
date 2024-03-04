package e1;

public interface Board {

    boolean isEmpty();

    int size();

    void fillCell(int cellX, int cellY);

    int getNumberOfElements();

    void emptyCell(int cellX, int cellY);
}
