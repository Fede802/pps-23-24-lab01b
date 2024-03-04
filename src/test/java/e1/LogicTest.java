package e1;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  @Test
  public void test() {
    assert(true);
    // TODO: Add your test logic here
    // You can generate random inputs and assert the expected output
    // For example:
    // int result = Logic.someMethod(5, 10);
    // assertEquals(expectedResult, result);
  }

  @Test
  public void knightPlacedOnBoard(){
    int boardSize = 5;
    Logics logics = new LogicsImpl(boardSize);
    boolean knightOnBoard = false;
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
          if(!knightOnBoard)
              knightOnBoard = logics.hasKnight(i,j);
      }
    }
    assertTrue(knightOnBoard);
  }

  @Test
  public void knightPlacedCorrectlyOnBoard(){
    int boardSize = 5;
    Logics logics = new LogicsImpl(boardSize);
    int knightXCoordinate = 3;
    int knightYCoordinate = 3;
    logics.setKnightPosition(knightXCoordinate,knightYCoordinate);
    assertTrue(logics.hasKnight(knightXCoordinate,knightYCoordinate));
  }

  @Test
  public void knightPlacedIncorrectlyOnBoard(){
    int boardSize = 5;
    Logics logics = new LogicsImpl(boardSize);
    int knightNegativeXCoordinate = -1;
    int knightNegativeYCoordinate = -1;
    logics.setKnightPosition(knightNegativeXCoordinate,knightNegativeYCoordinate);
    int knightExcessiveXCoordinate = 6;
    int knightExcessiveYCoordinate = 6;
    logics.setKnightPosition(knightExcessiveXCoordinate,knightExcessiveYCoordinate);
    logics.setKnightPosition(knightNegativeXCoordinate,knightNegativeYCoordinate);
    assertAll(
            () -> assertThrows(IllegalArgumentException.class, () -> logics.hasKnight(knightNegativeXCoordinate,knightNegativeYCoordinate)),
            () -> assertThrows(IllegalArgumentException.class, () -> logics.hasKnight(knightExcessiveXCoordinate,knightExcessiveYCoordinate))
    );

  }



}
