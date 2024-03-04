package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private final static int BOARD_SIZE = 5;
    private Board board;

    private final static List<Pair<Integer,Integer>> INVALID_POSITIONS = Arrays.asList(
            new Pair<>(-1,0),
            new Pair<>(0,-1),
            new Pair<>(BOARD_SIZE,0),
            new Pair<>(0,BOARD_SIZE));

    private void checkInvalidPositions(BiConsumer<Integer,Integer> actionToCheck) {
        assertAll(
                INVALID_POSITIONS.stream().map(
                        (position)-> () -> assertThrows(IllegalArgumentException.class,()->actionToCheck.accept(position.getX(),position.getY()))
                )
        );
    }

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
        int cellX = 0;
        int cellY = 0;
        Pair<Integer,Integer> cellPosition = this.board.fillCell(cellX,cellY);
        assertAll(
                ()->assertFalse(this.board.isEmpty()),
                ()->assertEquals(new Pair<>(0,0),cellPosition)
        );
    }
    @Test
    void wrongFillBoardCell(){
        this.checkInvalidPositions((i,j)->this.board.fillCell(i,j));
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
    void wrongEmptyBoardCell(){
        this.checkInvalidPositions((i,j)->this.board.emptyCell(i,j));
    }

    @Test
    void resetBoard(){
        this.board.fillCell(0,0);
        this.board.resetBoard();
        assertTrue(this.board.isEmpty());
    }

    @Test
    void checkCell(){
        int cellX = 0;
        int cellY = 0;
        this.board.fillCell(cellX,cellY);
        assertTrue(this.board.isCellFilled(cellX,cellY));
    }

    @Test
    void wrongCheckCell(){
        this.checkInvalidPositions((i,j)->this.board.isCellFilled(i,j));
    }



}
