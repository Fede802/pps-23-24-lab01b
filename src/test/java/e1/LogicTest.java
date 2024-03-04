package e1;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private final static int BOARD_SIZE = 5;
  private Logics logics;

  @BeforeEach
  public void initBoard(){
    logics = new LogicsImpl(BOARD_SIZE);
  }
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

    boolean knightOnBoard = false;
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
          if(!knightOnBoard)
              knightOnBoard = logics.hasKnight(i,j);
      }
    }
    assertTrue(knightOnBoard);
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





}
