package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;

public class GameBoardTest {
    private final static int BOARD_SIZE = 5;
    private GameBoard board;

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
        this.board = new GameBoardImpl(BOARD_SIZE);
    }

    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.board.size());
    }

    @Test
    void isKnightAndPawnInitiallyOnBoard(){
        assertAll(
                () -> assertFalse(this.board.getKnight().isPresent()),
                () -> assertFalse(this.board.getPawn().isPresent())
        );
    }
    @Test
    void placeKnightOnBoard(){
        int knightX = 0;
        int knightY = 0;
        this.board.placeKnight(knightX,knightY);
        assertEquals(new Pair<>(knightX,knightY),this.board.getKnight().orElse(INVALID_POSITIONS.get(0)));
    }
    @Test
    void wrongPlaceKnightOnBoard(){
        this.checkInvalidPositions((i,j)->this.board.placeKnight(i,j));
    }

    @Test
    void placePawnOnBoard(){
        int pawnX = 0;
        int pawnY = 0;
        this.board.placePawn(pawnX,pawnY);
        assertEquals(new Pair<>(pawnX,pawnY),this.board.getPawn().orElse(INVALID_POSITIONS.get(0)));
    }
    @Test
    void wrongPlacePawnOnBoard(){
        this.checkInvalidPositions((i,j)->this.board.placePawn(i,j));
    }
}
