package e1Version2.board;


import e1Version2.board.GameBoard;
import e1Version2.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameBoardTest {

    public final static int BOARD_SIZE = 5;

    protected final static e1.Pair<Integer,Integer> KNIGHT_START_POSITION = new e1.Pair<>(1,1);
    protected final static e1.Pair<Integer,Integer> PAWN_START_POSITION = new e1.Pair<>(0,0);
    protected final static List<Pair<Integer,Integer>> INVALID_POSITIONS = Arrays.asList(
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
    protected GameBoard gameBoard;

    @BeforeEach
    public void init(){
        gameBoard = new GameBoardImpl(BOARD_SIZE);
    }


    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.gameBoard.size());
    }

    @Test
    void isKnightAndPawnInitiallyNotOnBoard(){
        assertAll(
                () -> assertFalse(this.gameBoard.getKnightPosition().isPresent()),
                () -> assertFalse(this.gameBoard.getKnightPosition().isPresent())
        );
    }

    @Test
    void placeKnightOnBoard(){
        int knightX = KNIGHT_START_POSITION.getX();
        int knightY = KNIGHT_START_POSITION.getY();
        this.gameBoard.placeKnight(knightX,knightY);
        assertEquals(new Pair<>(knightX,knightY),this.gameBoard.getKnightPosition().orElse(INVALID_POSITIONS.get(0)));
    }
    @Test
    void wrongPlaceKnightOnBoard(){
        this.checkInvalidPositions((i,j)->this.gameBoard.placeKnight(i,j));
    }

    @Test
    void placePawnOnBoard(){
        int pawnX = PAWN_START_POSITION.getX();
        int pawnY = PAWN_START_POSITION.getY();
        this.gameBoard.placePawn(pawnX,pawnY);
        assertEquals(new Pair<>(pawnX,pawnY),this.gameBoard.getPawnPosition().orElse(INVALID_POSITIONS.get(0)));
    }
    @Test
    void wrongPlacePawnOnBoard(){
        this.checkInvalidPositions((i,j)->this.gameBoard.placePawn(i,j));
    }

    @Test
    void checkBoardPositions(){
        assertAll(
                () -> assertTrue(this.gameBoard.isValidCell(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY())),
                () -> assertFalse(this.gameBoard.isValidCell(INVALID_POSITIONS.get(0).getX(),INVALID_POSITIONS.get(0).getY()))

        );
    }


}
