package e1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardTest {
    @Test
    void isBoardInitiallyEmpty(){
        Board board = new BoardImpl();
        assertTrue(board.isEmpty());
    }
}
