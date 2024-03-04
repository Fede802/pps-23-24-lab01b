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
  public void knightAndPawnPlacedCorrectlyOnBoard(){
    int knightXCoordinate = 2;
    int knightYCoordinate = 2;
    logics.setKnightPosition(knightXCoordinate,knightYCoordinate);
    int pawnXCoordinate = 3;
    int pawnYCoordinate = 3;
    logics.setPawnPosition(pawnXCoordinate,pawnYCoordinate);
    assertAll(
            () -> assertTrue(logics.hasKnight(knightXCoordinate,knightYCoordinate)),
            () -> assertTrue(logics.hasPawn(pawnXCoordinate,pawnYCoordinate))
    );
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

  @Test
  public void spawnKnightOverPawn(){
    int xCoordinate = 3;
    int yCoordinate = 3;
    logics.setPawnPosition(xCoordinate,yCoordinate);
    assertThrows(IllegalStateException.class,()->logics.setKnightPosition(xCoordinate,yCoordinate));
  }

  @Test
  public void spawnPawnOverKnight(){
    int xCoordinate = 3;
    int yCoordinate = 3;
    logics.setKnightPosition(xCoordinate,yCoordinate);
    assertThrows(IllegalStateException.class,()-> logics.setPawnPosition(xCoordinate,yCoordinate));
  }

  @Test
  public void moveKnight(){
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {

      }
    }
  }




}
