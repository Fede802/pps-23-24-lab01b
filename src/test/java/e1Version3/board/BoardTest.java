package e1Version3.board;


import e1Version3.utils.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BoardTest {
    private final static int BOARD_SIZE = 5;
    private final static Pair<Integer,Integer> KNIGHT_START_POSITION = new Pair<>(1,1);
    private final static Pair<Integer,Integer> PAWN_START_POSITION = new Pair<>(0,0);
    private final static List<Pair<Integer,Integer>> INVALID_POSITIONS = Arrays.asList(
            new Pair<>(-1,0),
            new Pair<>(0,-1),
            new Pair<>(BOARD_SIZE,0),
            new Pair<>(0,BOARD_SIZE));
    private Board board;

    private void checkInvalidPositions(BiConsumer<Integer,Integer> actionToCheck) {
        assertAll(
                INVALID_POSITIONS.stream().map(
                        (position)-> () -> assertThrows(IndexOutOfBoundsException.class,()->actionToCheck.accept(position.getX(),position.getY()))
                )
        );
    }
    @BeforeEach
    public void init(){
        this.board = new BoardImpl(BOARD_SIZE);
    }

    @Test
    void isBoardSizeSetCorrectly(){
        assertEquals(BOARD_SIZE,this.board.size());
    }

    @Test
    void isKnightAndPawnInitiallyNotOnBoard(){
        assertAll(
                () -> assertTrue(this.board.getKnightPosition().isEmpty()),
                () -> assertTrue(this.board.getPawnPosition().isEmpty())
        );
    }

    @Test
    void placeKnightOnBoard(){
        this.board.placeKnight(KNIGHT_START_POSITION);
        assertEquals(KNIGHT_START_POSITION,this.board.getKnightPosition().orElseThrow());
    }

    @Test
    void wrongPlaceKnightOnBoard(){
        this.checkInvalidPositions((i,j)->this.board.placeKnight(new Pair<>(i,j)));
    }

    @Test
    void placePawnOnBoard(){
        int pawnX = PAWN_START_POSITION.getX();
        int pawnY = PAWN_START_POSITION.getY();
        this.board.placePawn(PAWN_START_POSITION);
        assertEquals(new Pair<>(pawnX,pawnY),this.board.getPawnPosition().orElseThrow());
    }
    @Test
    void wrongPlacePawnOnBoard(){
        this.checkInvalidPositions((i,j)->this.board.placePawn(new Pair<>(i,j)));
    }
}
