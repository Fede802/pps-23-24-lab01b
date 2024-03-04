package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {

    private Board board;

    @BeforeEach
    void initBoard(){
        board = new BoardImpl();
    }

    @Test
    void isBoardInitiallyEmpty(){
        assertTrue(board.isEmpty());
    }

    @Test
    void isBoardSizeInitiallyZero(){
        assertEquals(0,this.board.size());
    }
}
