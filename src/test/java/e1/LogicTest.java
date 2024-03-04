package e1;
import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
          new Pair<>(1,2));
  private final static List<Pair<Integer,Integer>> INVALID_POSITIONS = Arrays.asList(
          new Pair<>(-1,0),
          new Pair<>(0,-1),
          new Pair<>(BOARD_SIZE,0),
          new Pair<>(0,BOARD_SIZE));
  private Logics logics;
  private void checkInvalidPositions(BiConsumer<Integer,Integer> actionToCheck) {
    assertAll(
            INVALID_POSITIONS.stream().map(
                    (position)-> () -> assertThrows(IllegalArgumentException.class,()->actionToCheck.accept(position.getX(),position.getY()))
            )
    );
  }
  private void checkPossibleMoves(int currentKnightX, int currentKnightY) {
    this.executeValidMoves(currentKnightX,currentKnightY);
    this.checkInvalidMoves(currentKnightX,currentKnightY);
  }
  private void executeValidMoves(int currentKnightX, int currentKnightY) {
    VALID_MOVES.stream().filter(
            (move) -> !this.isNotValidBoardPosition(currentKnightX+move.getX(), currentKnightY+move.getY())
    ).forEach(
            (move)-> this.logics.hit(currentKnightX+move.getX(), currentKnightY+move.getY())
    );
  }
  private void checkInvalidMoves(int currentKnightX, int currentKnightY) {
    assertAll(
            VALID_MOVES.stream().filter(
                    (move) -> this.isNotValidBoardPosition(currentKnightX + move.getX(), currentKnightY + move.getY())
            ).map(
                    (move) ->
                            () -> assertThrows(IndexOutOfBoundsException.class,()->this.logics.hit(currentKnightX+move.getX(), currentKnightY+move.getY()))
            )
    );
  }
  private boolean isNotValidBoardPosition(int boardX, int boardY){
    return boardX < 0 || boardY < 0 || boardX >= BOARD_SIZE || boardY >= BOARD_SIZE;
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
  @BeforeEach
  public void initBoard(){
    this.logics = new LogicsImpl(BOARD_SIZE);
    this.setupPawnPosition(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY());
    this.logics.setKnightPosition(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY());
    this.logics.setPawnPosition(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY());
  }
  @Test
  public void knightPlacedOnBoard(){
    assertTrue(this.logics.hasKnight(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY()));
  }
  @Test
  public void knightPlacedIncorrectlyOnBoard(){
    checkInvalidPositions((i, j)->this.logics.setKnightPosition(i,j));
  }
  @Test
  public void knightSearchIncorrectlyOnBoard(){
    checkInvalidPositions((i, j)->this.logics.hasKnight(i,j));
  }
  @Test
  public void pawnPlacedOnBoard(){
    assertTrue(this.logics.hasPawn(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY()));
  }

  @Test
  public void pawnPlacedIncorrectlyOnBoard(){
    checkInvalidPositions((i, j)->this.logics.setPawnPosition(i,j));
  }

  @Test
  public void pawnSearchIncorrectlyOnBoard(){
    checkInvalidPositions((i, j)->this.logics.hasPawn(i,j));
  }
  @Test
  public void spawnKnightOverPawn(){
    assertThrows(IllegalStateException.class,()->this.logics.setKnightPosition(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY()));
  }
  @Test
  public void spawnPawnOverKnight(){
    assertThrows(IllegalStateException.class,()->this.logics.setPawnPosition(KNIGHT_START_POSITION.getX(), KNIGHT_START_POSITION.getY()));
  }

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
  @Test
  public void checkWinningSituation(){
    int knightX = 0;
    int knightY = 0;
    int pawnX = 1;
    int pawnY = 2;
    this.setupPawnPosition(knightX, knightY);
    this.logics.setKnightPosition(knightX,knightY);
    this.logics.setPawnPosition(pawnX,pawnY);
    assertTrue(this.logics.hit(pawnX,pawnY));
  }




}
