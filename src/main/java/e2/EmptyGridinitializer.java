package e2;

import java.util.ArrayList;
import java.util.List;

public class EmptyGridinitializer implements GridInitializer {
    @Override
    public void initializeGrid(List<List<GameCell>> grid, int gridSize) {
        for (int i = 0; i < gridSize; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < gridSize; j++) {
                grid.get(i).add(new GameCell(i,j));
            }
        }
    }
}
