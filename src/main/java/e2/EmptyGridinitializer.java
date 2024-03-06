package e2;

import e2.cell.ClickableCell;

import java.util.ArrayList;
import java.util.List;

public class EmptyGridinitializer implements GridInitializer {
    @Override
    public void initializeGrid(List<List<ClickableCell>> grid, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < gridSize; j++) {
                grid.get(i).add(new ClickableCell(i,j));
            }
        }
    }
}
