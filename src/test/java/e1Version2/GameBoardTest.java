package e1Version2;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameBoardTest {

    private final static int BOARD_SIZE = 5;
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

    @Test
    void placeKnightOnBoard(){
        int knightX = 0;
        int knightY = 0;
        this.gameBoard.placeKnight(knightX,knightY);
        assertEquals(new Pair<>(knightX,knightY),this.gameBoard.getKnight().orElse(INVALID_POSITIONS.get(0)));
    }
    @Test
    void wrongPlaceKnightOnBoard(){
        this.checkInvalidPositions((i,j)->this.gameBoard.placeKnight(i,j));
    }

    @Test
    void placePawnOnBoard(){
        int pawnX = 0;
        int pawnY = 0;
        this.gameBoard.placePawn(pawnX,pawnY);
        assertEquals(new Pair<>(pawnX,pawnY),this.gameBoard.getPawn().orElse(INVALID_POSITIONS.get(0)));
    }
    @Test
    void wrongPlacePawnOnBoard(){
        this.checkInvalidPositions((i,j)->this.gameBoard.placePawn(i,j));
    }


}
