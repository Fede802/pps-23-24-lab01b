package e2.grid;

import e2.cell.GameCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class GridInitializerTest {

    private final static int GRID_SIZE = 7;
    private GridInitializer gridInitializer;
    private List<List<GameCell>> grid;
    @BeforeEach
    void initGridInitializer(){
        this.grid = new ArrayList<>();
        this.gridInitializer = createGridInitializer();
        this.gridInitializer.initializeGrid(this.grid,GRID_SIZE);
    }
    
    @Test
    void gridCorrectlyInitialized(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                assertFalse(this.grid.get(i).get(j).isSelected());
            }
        }
    }

    protected abstract GridInitializer createGridInitializer();
}
