package e2.grid;

import e2.cell.GameCell;

import java.util.List;

public class GameInitializerImpl implements GameInitializer{
    private final GridInitializer gridInitializer = new EmptyGridInitializer();

    @Override
    public void initializeGrid(List<List<GameCell>> grid, int gridSize) {
        gridInitializer.initializeGrid(grid, gridSize);
    }
}
