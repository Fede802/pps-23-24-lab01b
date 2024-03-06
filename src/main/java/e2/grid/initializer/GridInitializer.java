package e2.grid.initializer;

import e2.cell.Cell;
import e2.cell.ClickableCell;
import e2.cell.GameCell;

import java.util.List;

public interface GridInitializer {
    void initializeGrid(List<List<GameCell>> grid, int gridSize);
}
