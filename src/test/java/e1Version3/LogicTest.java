package e1Version3;


import e1Version3.utils.RandomPositionGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static e1Version2.board.GameBoardTest.BOARD_SIZE;
import static e1Version3.piece.movement.KnightMovement.VALID_MOVES;
import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

    private Logics logics;
    private boolean findPieceOnBoard(BiPredicate<Integer,Integer> pieceFinder){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if(pieceFinder.test(i,j)){
                    return true;
                }
            }
        }
        return false;
    }
    @BeforeEach
    public void initBoard(){
        this.logics = new LogicsImpl(BOARD_SIZE, new RandomPositionGenerator());
    }
    @Test
    public void knightAndPawnInitiallyPlacedOnBoard(){
        assertAll(
                () -> assertTrue(this.findPieceOnBoard((row,col)->this.logics.hasKnight(row,col))),
                () -> assertTrue(this.findPieceOnBoard((row,col)->this.logics.hasPawn(row,col)))
        );
    }

    @Test
    public void knightAndPawnOutOfBoardSearch(){
        int wrongRow = -1;
        int wrongColumn = -1;
        assertAll(
                () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logics.hasKnight(wrongRow,wrongColumn)),
                () -> assertThrows(IndexOutOfBoundsException.class, () ->this.logics.hasPawn(wrongRow,wrongColumn))
        );
    }

    @Test
    public void moveKnight(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.checkPossibleMoves(i,j);
            }
        }
    }

    private void checkPossibleMoves(int currentKnightX, int currentKnightY) {
        this.executeValidMoves(currentKnightX,currentKnightY);
        this.checkInvalidMoves(currentKnightX,currentKnightY);
    }

    private void executeValidMoves(int currentKnightX, int currentKnightY) {

        VALID_MOVES.stream().filter(
                (move) -> !this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
        ).forEach(
                (move)-> {
                    this.logics.setKnightPosition(currentKnightX,currentKnightY);
                    this.logics.hit(currentKnightX + move.getX(), currentKnightY + move.getY());
                }
        );
    }

    private void checkInvalidMoves(int currentKnightX, int currentKnightY) {
        assertAll(
                VALID_MOVES.stream().filter(
                        (move) -> this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
                ).map(
                        (move) ->
                                () -> {
                                    assertThrows(IndexOutOfBoundsException.class,()->this.logics.hit(currentKnightX+move.getX(), currentKnightY+move.getY()));
                                }
                )
        );
    }
    private boolean isNotValidBoardPosition(int boardX, int boardY){
        return boardX < 0 || boardY < 0 || boardX >= BOARD_SIZE || boardY >= BOARD_SIZE;
    }

    @Test
    public void checkWinningSituation(){
        int knightX = 0;
        int knightY = 0;
        int pawnX = 1;
        int pawnY = 2;
        this.logics.setKnightPosition(knightX,knightY);
        this.logics.setPawnPosition(pawnX,pawnY);
        assertTrue(this.logics.hit(pawnX,pawnY));
    }

}
