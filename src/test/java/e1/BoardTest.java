package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private final static int BOARD_SIZE = 5;
    private Board board;

    @BeforeEach
    void initBoard(){
        this.board = new BoardImpl(BOARD_SIZE);
    }

    @Test
    void isBoardInitiallyEmpty(){
        assertTrue(this.board.isEmpty());
    }

    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.board.size());
    }

    @Test
    void fillBoardCell(){
        this.board.fillCell(0,0);
        assertFalse(this.board.isEmpty());
    }

    @Test
    void fillAllBoard(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.board.fillCell(i,j);
            }
        }
        assertEquals(BOARD_SIZE*BOARD_SIZE, this.board.getNumberOfElements());
    }

    @Test
    void emptyBoardCell(){
        int cellX = 0;
        int cellY = 0;
        this.board.fillCell(cellX,cellY);
        this.board.emptyCell(cellX,cellY);
        assertTrue(this.board.isEmpty());
    }

    @Test
    void resetBoard(){
        this.board.fillCell(0,0);
        this.board.resetBoard();
        assertTrue(this.board.isEmpty());
    }



}
