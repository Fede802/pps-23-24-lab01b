package e1;
import org.junit.jupiter.api.*;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;
public class LogicTest {

  private final static int BOARD_SIZE = 5;
  private final static Pair<Integer,Integer> KNIGHT_START_POSITION = new Pair<>(1,1);
  private final static Pair<Integer,Integer> PAWN_START_POSITION = new Pair<>(0,0);
  private final static List<Pair<Integer,Integer>> VALID_MOVES = Arrays.asList(
          new Pair<>(-2,-1),
          new Pair<>(-1,-2),
          new Pair<>(-2,1),
          new Pair<>(-1,2),
          new Pair<>(2,-1),
          new Pair<>(1,-1),
          new Pair<>(2,1),
          new Pair<>(1,1));

  private Logics logics;

  private void outOfBoardChecker(BiConsumer<Integer,Integer> actionToCheck) {
    assertAll(
            () -> assertThrows(IllegalArgumentException.class,()->actionToCheck.accept(-1,0)),
            () -> assertThrows(IllegalArgumentException.class,()->actionToCheck.accept(0,-1)),
            () -> assertThrows(IllegalArgumentException.class,()->actionToCheck.accept(BOARD_SIZE,0)),
            () -> assertThrows(IllegalArgumentException.class,()->actionToCheck.accept(0,BOARD_SIZE))
    );
  }
  private void checkValidMoves(int currentKnightX, int currentKnightY) {
    VALID_MOVES.forEach((move)->{
      if(currentKnightX+move.getX()<0 || currentKnightY+move.getY()<0 || currentKnightX+move.getX() >= BOARD_SIZE || currentKnightY+move.getY() >= BOARD_SIZE) {
        assertThrows(IndexOutOfBoundsException.class, () -> logics.hit(currentKnightX+move.getX(),currentKnightY+move.getY()));
      }else{
        logics.hit(currentKnightX+move.getX(), currentKnightY+move.getY());
      }
    });
  }

  private void movePawnAway(int i, int j) {
    int newPawnXCoordinate = i > 0 ? 0 : 2;
    int newPawnYCoordinate = j > 0 ? 0 : 2;
    if(!logics.hasKnight(newPawnXCoordinate,newPawnYCoordinate)) {
      logics.setPawnPosition(newPawnXCoordinate, newPawnYCoordinate);
    }else {
      logics.setPawnPosition(1, 1);
    }
  }

  @BeforeEach
  public void initBoard(){
    logics = new LogicsImpl(BOARD_SIZE);
    logics.setKnightPosition(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY());
    logics.setPawnPosition(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY());
  }
  @Test
  public void knightPlacedOnBoard(){
    assertTrue(logics.hasKnight(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY()));
  }
  @Test
  public void knightPlacedIncorrectlyOnBoard(){
    outOfBoardChecker((i,j)->logics.setKnightPosition(i,j));
  }
  @Test
  public void knightSearchIncorrectlyOnBoard(){
    outOfBoardChecker((i,j)->logics.hasKnight(i,j));
  }
  @Test
  public void pawnPlacedOnBoard(){
    assertTrue(logics.hasPawn(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY()));
  }

  @Test
  public void pawnPlacedIncorrectlyOnBoard(){
    outOfBoardChecker((i,j)->logics.setPawnPosition(i,j));
  }

  @Test
  public void pawnSearchIncorrectlyOnBoard(){
    outOfBoardChecker((i,j)->logics.hasPawn(i,j));
  }
  @Test
  public void spawnKnightOverPawn(){
    assertThrows(IllegalStateException.class,()->logics.setKnightPosition(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY()));
  }
  @Test
  public void spawnPawnOverKnight(){
    assertThrows(IllegalStateException.class,()-> logics.setPawnPosition(KNIGHT_START_POSITION.getX(), KNIGHT_START_POSITION.getY()));
  }

  @Test
  public void moveKnight(){
    for (int i = 0; i < BOARD_SIZE; i++) {
      for (int j = 0; j < BOARD_SIZE; j++) {
        this.setupPawnPosition(i, j);
        this.logics.setKnightPosition(i,j);
        this.checkValidMoves(i,j);
      }
    }
  }

  private void setupPawnPosition(int xCoordinate, int yCoordinate) {
    if(logics.hasPawn(xCoordinate, yCoordinate)){
      this.movePawnAway(xCoordinate,yCoordinate);
    }
  }

  @Test
  public void checkWinningSituation(){
    int knightX = 0;
    int knightY = 0;
    int pawnX = 1;
    int pawnY = 2;
    setupPawnPosition(knightX, knightY);
    logics.setKnightPosition(knightX,knightY);
    logics.setPawnPosition(pawnX,pawnY);
    assertTrue(logics.hit(pawnX,pawnY));
  }




}
