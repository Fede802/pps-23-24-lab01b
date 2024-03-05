package e1Version2;


import e1.Pair;
import e1Version2.utils.RandomPositionGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

import static e1Version2.board.GameBoardTest.BOARD_SIZE;
import static org.junit.jupiter.api.Assertions.*;

public class LogicsTest {
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

    //todo add exception for wrong search? or at least do a test to assert false

    @Test
    public void moveKnight(){
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                this.setupPawnPosition(i, j);
                this.logics.setKnightPosition(i,j);
                this.checkPossibleMoves(i,j);
            }
        }
    }

    private void setupPawnPosition(int boardX, int boardY) {
        if(this.logics.hasPawn(boardX, boardY)){
            this.movePawnAway(boardX,boardY);
        }
    }

    private void movePawnAway(int boardX, int boardY) {
        int newPawnXCoordinate = boardX > 0 ? 0 : 2;
        int newPawnYCoordinate = boardY > 0 ? 0 : 2;
        if(!this.logics.hasKnight(newPawnXCoordinate,newPawnYCoordinate)) {
            this.logics.setPawnPosition(newPawnXCoordinate, newPawnYCoordinate);
        }else {
            this.logics.setPawnPosition(1, 1);
        }
    }

    private void checkPossibleMoves(int currentKnightX, int currentKnightY) {
        this.executeValidMoves(currentKnightX,currentKnightY);
//        this.checkInvalidMoves(currentKnightX,currentKnightY);
    }


    private void executeValidMoves(int currentKnightX, int currentKnightY) {
        System.out.println("LogicTest move to test"+VALID_MOVES.stream().filter(
                (move) -> !this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
        ).count());
        VALID_MOVES.stream().filter(
                (move) -> !this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
        ).forEach(
                (move)-> {
                    System.out.println("LogicTest currKniX"+currentKnightX);
                    System.out.println("LogicTest currKniY"+currentKnightY);
                    System.out.println("LogicTest moveX"+move.getX());
                    System.out.println("LogicTest moveY"+move.getY());
                    this.logics.hit(currentKnightX + move.getX(), currentKnightY + move.getY());
//                    this.setupPawnPosition(currentKnightX,currentKnightY);
//                    this.logics.setKnightPosition(currentKnightX,currentKnightY);
                    System.out.println("---------------------");
                }
        );
    }
    private void checkInvalidMoves(int currentKnightX, int currentKnightY) {
        System.out.println("LogicTest move to test"+VALID_MOVES.stream().filter(
                (move) -> this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
        ).count());
        assertAll(
                VALID_MOVES.stream().filter(
                        (move) -> this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
                ).map(
                        (move) ->
                                () -> {
                                    System.out.println("LogicTest currKniX"+currentKnightX);
                                    System.out.println("LogicTest currKniY"+currentKnightY);
                                    System.out.println("LogicTest moveX"+move.getX());
                                    System.out.println("LogicTest moveY"+move.getY());
                                    assertThrows(IllegalArgumentException.class,()->this.logics.hit(currentKnightX+move.getX(), currentKnightY+move.getY()));
                                    System.out.println("---------------------");
                                }
                )
        );
    }

    private final static List<Pair<Integer,Integer>> VALID_MOVES = Arrays.asList(
            new Pair<>(-2,-1),
            new Pair<>(-1,-2),
            new Pair<>(-2,1),
            new Pair<>(-1,2),
            new Pair<>(2,-1),
            new Pair<>(1,-2),
            new Pair<>(2,1),
            new Pair<>(1,2));

    private boolean isNotValidBoardPosition(int boardX, int boardY){
        return boardX < 0 || boardY < 0 || boardX >= BOARD_SIZE || boardY >= BOARD_SIZE;
    }
}
