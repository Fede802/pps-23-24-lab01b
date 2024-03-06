package e2;

import e2.cell.ClickableCell;

import java.util.List;

public interface GridInitializer {
    void initializeGrid(List<List<ClickableCell>> grid, int gridSize);
}
