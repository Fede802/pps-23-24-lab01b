package e2.cell;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameCellStatusTest {
    private GameCellStatus gameCellStatus;
    @BeforeEach
    void initCellStatus(){
        this.gameCellStatus = new GameCellStatusImpl();
    }

    @Test
    void isInitiallyUnselectedAndNotFlagged(){
        assertAll(
                () -> assertFalse(this.gameCellStatus.isSelected()),
                () -> assertFalse(this.gameCellStatus.isFlagged())
        );
    }

    @Test
    void isSelectable(){
        this.gameCellStatus.select();
        assertTrue(this.gameCellStatus.isSelected());
    }

    @Test
    void isNotUnselectable(){
        this.gameCellStatus.select();
        assertThrows(IllegalStateException.class,() -> this.gameCellStatus.select());
    }

    @Test
    void canBeFlagged(){
        this.gameCellStatus.toggleFlag();
        assertTrue(this.gameCellStatus.isFlagged());
    }

    @Test
    void canReverseFlagged(){
        this.gameCellStatus.toggleFlag();
        this.gameCellStatus.toggleFlag();
        assertFalse(this.gameCellStatus.isFlagged());
    }





}
