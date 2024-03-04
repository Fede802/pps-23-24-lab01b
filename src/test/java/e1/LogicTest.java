package e1;
import org.junit.jupiter.api.*;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private final static int BOARD_SIZE = 5;
  private Logics logics;

  private boolean isPieceOnBoard(BiPredicate<Integer,Integer> pieceFinder) {
    boolean pieceOnBoard = false;
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        if(!pieceOnBoard)
          pieceOnBoard = pieceFinder.test(i,j);
      }
    }
    return pieceOnBoard;
  }
  @BeforeEach
  public void initBoard(){
    logics = new LogicsImpl(BOARD_SIZE);
  }

  @Test
  public void knightPlacedOnBoard(){
    assertTrue(isPieceOnBoard((i,j) -> logics.hasKnight(i,j)));
  }

  @Test
  public void knightPlacedCorrectlyOnBoard(){

    int knightXCoordinate = 3;
    int knightYCoordinate = 3;
    logics.setKnightPosition(knightXCoordinate,knightYCoordinate);
    assertTrue(logics.hasKnight(knightXCoordinate,knightYCoordinate));
  }

  @Test
  public void knightPlacedIncorrectlyOnBoard(){
    assertAll(
            () -> assertThrows(IllegalArgumentException.class,()->logics.setKnightPosition(-1,-1)),
            () -> assertThrows(IllegalArgumentException.class,()->logics.setKnightPosition(BOARD_SIZE,BOARD_SIZE))
    );

  }

  @Test
  public void knightSearchIncorrectlyOnBoard(){
    assertAll(
            () -> assertThrows(IllegalArgumentException.class,()->logics.hasKnight(-1,-1)),
            () -> assertThrows(IllegalArgumentException.class,()->logics.hasKnight(BOARD_SIZE,BOARD_SIZE))
    );
  }

  @Test
  public void pawnPlacedOnBoard(){
      assertTrue(isPieceOnBoard((i,j) -> logics.hasPawn(i,j)));
  }

  @Test
  public void pawnPlacedCorrectlyOnBoard(){
    int pawnXCoordinate = 3;
    int pawnYCoordinate = 3;
    logics.setPawnPosition(pawnXCoordinate,pawnYCoordinate);
    assertTrue(logics.hasPawn(pawnXCoordinate,pawnYCoordinate));
  }

  @Test
  public void pawnPlacedIncorrectlyOnBoard(){
    assertAll(
            () -> assertThrows(IllegalArgumentException.class,()->logics.setPawnPosition(-1,-1)),
            () -> assertThrows(IllegalArgumentException.class,()->logics.setPawnPosition(BOARD_SIZE,BOARD_SIZE))
    );

  }

  @Test
  public void pawnSearchIncorrectlyOnBoard(){
    assertAll(
            () -> assertThrows(IllegalArgumentException.class,()->logics.hasPawn(-1,-1)),
            () -> assertThrows(IllegalArgumentException.class,()->logics.hasPawn(BOARD_SIZE,BOARD_SIZE))
    );
  }








}
