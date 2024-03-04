package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {

    private final static int BOARD_SIZE = 5;
    private GameBoard board;

    @BeforeEach
    void initBoard(){
        this.board = new GameBoardImpl(BOARD_SIZE);
    }

    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.board.size());
    }
    @Test
    void isKnightAndPawnInitiallyOnBoard(){
        assertAll(
                () -> assertNotNull(this.board.getKnight()),
                () -> assertNotNull(this.board.getPawn())

        );
    }
}
