package e2.grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GridTest {

    private final static int BOARD_SIZE = 7;
    private Grid grid;

    @BeforeEach
    void initGrid(){
        this.grid = new GridImpl(BOARD_SIZE);
    }

    @Test
    void isGridCreateCorrectly(){
        assertEquals(BOARD_SIZE, this.grid.getSize());
    }

    @Test
    void isAllCellsInitiallyUnpressed(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                assertFalse(this.grid.isCellPressed(i,j));
            }
        }
    }

    @Test
    void pressCell(){
        int cellX = 0;
        int cellY = 0;
        this.grid.pressCell(cellX,cellY);
        assertTrue(this.grid.isCellPressed(cellX,cellY));
    }

    @Test
    void deselectCell(){
        int cellX = 0;
        int cellY = 0;
        this.grid.pressCell(cellX,cellY);
        this.grid.pressCell(cellX,cellY);
        assertFalse(this.grid.isCellPressed(cellX,cellY));
    }

    //todo test for multiple select/deselect cycles

}
