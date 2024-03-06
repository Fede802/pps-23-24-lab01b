package e2.grid;

public interface Grid {
    int getSize();

    boolean isCellPressed(int cellX, int cellY);

    void pressCell(int cellX, int cellY);
}
