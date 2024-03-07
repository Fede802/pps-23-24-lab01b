package e2;


import e2.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest{

    private final static int GRID_SIZE = 7;
    private Logics logics;

    @BeforeEach
    void initLogics(){
        this.logics = new LogicsImpl(GRID_SIZE,0);
    }

    @Test
    void createLogicWithTooMuchMines(){
        assertThrows(IllegalArgumentException.class, () -> new LogicsImpl(GRID_SIZE,GRID_SIZE*GRID_SIZE+1));
    }
    @Test
    void clickEmptyCell(){
        Set<Pair<Integer,Integer>> presetMinePosition = Set.of(
                new Pair<>(0,1),
                new Pair<>(1,0),
                new Pair<>(1,1)
        );
        this.logics = new LogicsImpl(GRID_SIZE,presetMinePosition);
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        assertAll(
                () -> assertFalse(this.logics.isMineCell(cell)),
                () -> assertEquals(ClickResult.EMPTY,this.logics.clickCell(cell))
        );
    }

    @Test
    void clickMineCell(){
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        this.logics = new LogicsImpl(GRID_SIZE,GRID_SIZE*GRID_SIZE);
        assertAll(
                () -> assertTrue(this.logics.isMineCell(cell)),
                () -> assertEquals(ClickResult.LOSE,this.logics.clickCell(cell))
        );

    }

    @Test
    void clickWrongCell(){
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class,()->this.logics.clickCell(new Pair<>(-1,0))),
                () -> assertThrows(IndexOutOfBoundsException.class,()->this.logics.clickCell(new Pair<>(GRID_SIZE,0))),
                () -> assertThrows(IndexOutOfBoundsException.class,()->this.logics.clickCell(new Pair<>(0,-1))),
                () -> assertThrows(IndexOutOfBoundsException.class,()->this.logics.clickCell(new Pair<>(0,GRID_SIZE)))
        );
    }
    @Test
    void clickAllEmptyCell(){
        Set<Pair<Integer,Integer>> presetMinePosition = Set.of(
                new Pair<>(0,1),
                new Pair<>(1,0),
                new Pair<>(1,1)
        );
        this.logics = new LogicsImpl(GRID_SIZE,presetMinePosition);
        for (int i = 2; i < GRID_SIZE; i++) {
            for (int j = 2; j < GRID_SIZE; j++) {
                    this.logics.clickCell(new Pair<>(i, j));
            }
        }
        assertEquals(ClickResult.WIN,this.logics.clickCell(new Pair<>(0,0)));
    }

    @Test
    void allCellInitiallyNotFlagged(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if(!(i == 0 && j == 0)) {
                    assertFalse(this.logics.isCellFlagged(new Pair<>(i, j)));
                }
            }
        }
    }

    @Test
    void flagCell(){
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        this.logics.toggleFlag(cell);
        assertTrue(this.logics.isCellFlagged(cell));
    }

    @Test
    void resetFlag(){
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        this.logics.toggleFlag(cell);
        this.logics.toggleFlag(cell);
        assertFalse(this.logics.isCellFlagged(cell));
    }

    @Test
    void allCellInitiallyNotClicked(){
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if(!(i == 0 && j == 0)) {
                    assertFalse(this.logics.isCellClicked(new Pair<>(i, j)));
                }
            }
        }
    }

    @Test
    void clickCell(){
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        this.logics.clickCell(cell);
        assertTrue(this.logics.isCellClicked(cell));
    }

    @Test
    void doubleClickCell(){
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        this.logics.clickCell(cell);
        assertDoesNotThrow(() -> this.logics.clickCell(cell));
    }

    @Test
    void minesAroundCheckerWorksCorrectlyInEmptyGrid(){
        this.logics = new LogicsImpl(GRID_SIZE,0);
        assertAll(
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(0,0))),
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-1,0))),
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(0,GRID_SIZE-1))),
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-1,GRID_SIZE-1))),

                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(0,1))),
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(1,0))),
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-1,GRID_SIZE-2))),
                () -> assertEquals(0, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-2,GRID_SIZE-1))),

                () -> assertEquals(0,this.logics.numberOfMinesAround(new Pair<>(1,1)))

        );
    }
    @Test
    void minesAroundCheckerWorksCorrectlyInFullGrid(){
        this.logics = new LogicsImpl(GRID_SIZE,GRID_SIZE*GRID_SIZE);
        assertAll(
                () -> assertEquals(3, this.logics.numberOfMinesAround(new Pair<>(0,0))),
                () -> assertEquals(3, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-1,0))),
                () -> assertEquals(3, this.logics.numberOfMinesAround(new Pair<>(0,GRID_SIZE-1))),
                () -> assertEquals(3, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-1,GRID_SIZE-1))),

                () -> assertEquals(5, this.logics.numberOfMinesAround(new Pair<>(0,1))),
                () -> assertEquals(5, this.logics.numberOfMinesAround(new Pair<>(1,0))),
                () -> assertEquals(5, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-1,GRID_SIZE-2))),
                () -> assertEquals(5, this.logics.numberOfMinesAround(new Pair<>(GRID_SIZE-2,GRID_SIZE-1))),

                () -> assertEquals(8,this.logics.numberOfMinesAround(new Pair<>(1,1)))

        );
    }

    @Test
    void chainEffect(){
        assertEquals(ClickResult.WIN,this.logics.clickCell(new Pair<>(0,0)));
    }

    @Test
    void cannotFlagClickedCell(){
        Pair<Integer, Integer> cell = new Pair<>(0,0);
        this.logics.clickCell(cell);
        this.logics.toggleFlag(cell);
        assertFalse(this.logics.isCellFlagged(cell));

    }

    @Test
    void cannotFlagCellWhenGameIsLost(){
        Pair<Integer, Integer> emptyCell = new Pair<>(0,0);
        Pair<Integer, Integer> mineCell = new Pair<>(0,1);
        this.logics = new LogicsImpl(GRID_SIZE,Set.of(mineCell));
        this.logics.clickCell(mineCell);
        this.logics.toggleFlag(emptyCell);
        assertFalse(this.logics.isCellFlagged(emptyCell));

    }

    @Test
    void cannotClickCellWhenGameIsLost(){
        Pair<Integer, Integer> emptyCell = new Pair<>(0,0);
        Pair<Integer, Integer> mineCell = new Pair<>(0,1);
        this.logics = new LogicsImpl(GRID_SIZE,Set.of(mineCell));
        this.logics.clickCell(mineCell);
        this.logics.clickCell(emptyCell);
        assertFalse(this.logics.isCellClicked(emptyCell));

    }
}
