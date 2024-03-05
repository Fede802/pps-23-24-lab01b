package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    private final static int CELL_START_X = 0;
    private final static int CELL_START_Y = 0;

    //todo improve (non)adjacent - generation
    private final static List<Pair<Integer,Integer>> ADJACENT_CELLS = Arrays.asList(
            new Pair<>(-1,-1), new Pair<>(-1, 0), new Pair<>(-1,1),
            new Pair<>(0,-1), /*------startCell------*/ new Pair<>(0,1),
            new Pair<>(1,-1),  new Pair<>(1, 0),  new Pair<>(1,1)
    );

    private final static List<Pair<Integer,Integer>> NOT_ADJACENT_CELLS = Arrays.asList(
            new Pair<>(-2,-2), new Pair<>(-2,-1), new Pair<>(-2,0), new Pair<>(-2,1),new Pair<>(-2,2),
            new Pair<>(-1,-2), /*-------------------------------------------------------------------*/ new Pair<>(-1,2),
            new Pair<>(0,-2),  /*--------------------------adjacentCells----------------------------*/ new Pair<>(0,2),
            new Pair<>(1,-2),  /*-------------------------------------------------------------------*/ new Pair<>(1,2),
            new Pair<>(2,-2),  new Pair<>(2,-1),  new Pair<>(2,0),  new Pair<>(2,1), new Pair<>(2,2)
    );
    private Cell cell;
    @BeforeEach
    void initCell(){
        this.cell = new CellImpl(CELL_START_X,CELL_START_Y);
    }
    @Test
    void isCellPositionInitiallySet(){
        assertEquals(new Pair<>(CELL_START_X,CELL_START_Y), this.cell.getCellPosition());
    }

    @Test
    void moveCellPosition(){
        int newCellX = 3;
        int newCellY = -3;
        this.cell.moveCellTo(newCellX, newCellY);
        assertEquals(new Pair<>(newCellX,newCellY), this.cell.getCellPosition());
    }


    @Test
    void checkCorrectAdjacency(){
        assertAll(
                ADJACENT_CELLS.stream().map(
                        (adjacentCell) ->
                            () -> assertTrue(this.cell.isAdjacentTo(adjacentCell))
                )
        );
    }

    @Test
    void checkWrongAdjacency(){
        assertAll(
                NOT_ADJACENT_CELLS.stream().map(
                        (notAdjacentCell) ->
                                () -> assertFalse(this.cell.isAdjacentTo(notAdjacentCell))
                )
        );
    }
}
