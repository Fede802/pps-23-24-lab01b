package e1Version2.board;

public class BaseGameBoardTest extends GameBoardTest {

    @Override
    protected GameBoard createGameBoard() {
        return new BaseGameBoard(BOARD_SIZE);
    }
}
