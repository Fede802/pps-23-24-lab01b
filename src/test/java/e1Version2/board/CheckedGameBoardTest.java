package e1Version2.board;

import e1Version2.board.CheckedGameBoard;
import e1Version2.board.GameBoard;
import e1Version2.board.GameBoardTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CheckedGameBoardTest extends GameBoardTest {
    @Override
    protected GameBoard createGameBoard() { //todo check template
        return new CheckedGameBoard(BOARD_SIZE);
    }

    @Test
    public void placeKnightOverPawn(){
        this.gameBoard.placePawn(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY());
        assertThrows(IllegalStateException.class,()->this.gameBoard.placeKnight(PAWN_START_POSITION.getX(),PAWN_START_POSITION.getY()));
    }

    @Test
    public void placePawnOverKnight(){
        this.gameBoard.placeKnight(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY());
        assertThrows(IllegalStateException.class,()->this.gameBoard.placePawn(KNIGHT_START_POSITION.getX(),KNIGHT_START_POSITION.getY()));
    }

}
