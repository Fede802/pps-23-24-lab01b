package e1;
import org.junit.jupiter.api.*;
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
          knightOnBoard = logics.hasKnight(i,j);
      }
    }
    assertTrue(knightOnBoard);
  }

  @Test
  public void knightPlacedCorrectlyOnBoard(){
    int boardSize = 5;
    Logics logics = new LogicsImpl(boardSize);
    boolean knightOnBoard = false;
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        knightOnBoard = logics.hasKnight(i,j);
      }
    }
    assertTrue(knightOnBoard);
  }

}
