package e2.grid.initializer;

import e2.cell.GameCell;
import e2.grid.minePlacer.MinePlacer;

import java.util.List;

public interface GameInitializer extends GridInitializer{
    void initializeGridWithMines(List<List<GameCell>> grid, int minesToPlace, int gridSize) throws IllegalArgumentException;

    void setMinePlacer(MinePlacer minePlacer);

    MinePlacer getMinePlacer();
}
