package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GridInitializerTest {

    private final static int GRID_SIZE = 7;
    private GridInitializer gridInitializer;
    private List<List<GameCell>> grid;
    @BeforeEach
    void initGridInitializer(){
        this.grid = new ArrayList<>();
        this.gridInitializer = new EmptyGridinitializer();
    }
    
    @Test
    void initializeGrid(){
        this.gridInitializer.initializeGrid(this.grid,GRID_SIZE);
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                assertFalse(this.grid.get(i).get(j).isSelected());
            }
        }
    }
}
