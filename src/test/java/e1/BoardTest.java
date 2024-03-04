package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private final static int BOARD_SIZE = 5;
    private Board board;

    @BeforeEach
    void initBoard(){
        board = new BoardImpl(BOARD_SIZE);
    }

    @Test
    void isBoardInitiallyEmpty(){
        assertTrue(board.isEmpty());
    }

    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.board.size());
    }

}
