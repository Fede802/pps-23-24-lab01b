package e2.grid;

import e2.grid.initializer.GameInitializer;

public interface Grid {
    int getSize();

    boolean isCellPressed(int cellX, int cellY);

    void pressCell(int cellX, int cellY);

    void setGameInitializer(GameInitializer gameInitializer);

    GameInitializer getGameInitializer();

    boolean hasMine(int gridX, int gridY);
}
