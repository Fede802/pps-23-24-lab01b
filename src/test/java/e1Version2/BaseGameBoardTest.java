package e1Version2;

public class BaseGameBoardTest extends GameBoardTest{

    @Override
    protected GameBoard createGameBoard() {
        return new BaseGameBoard(BOARD_SIZE);
    }
}
