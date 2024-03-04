package e1Version2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameBoardTest {

    private final static int BOARD_SIZE = 5;
    private GameBoard gameBoard;

    @BeforeEach
    public void init(){
        gameBoard = new BaseGameBoard(BOARD_SIZE);
    }

    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.gameBoard.size());
    }

    @Test
    void isKnightAndPawnInitiallyNotOnBoard(){
        assertAll(
                () -> assertFalse(this.gameBoard.getKnight().isPresent()),
                () -> assertFalse(this.gameBoard.getPawn().isPresent())
        );
    }


}
