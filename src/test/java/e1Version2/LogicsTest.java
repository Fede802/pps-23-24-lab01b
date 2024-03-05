package e1Version2;


import e1Version2.utils.RandomPositionGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiPredicate;

import static e1Version2.board.GameBoardTest.BOARD_SIZE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

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




}
