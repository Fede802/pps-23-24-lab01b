package e1Version2;

public class CheckedGameBoardTest extends GameBoardTest{
    @Override
    protected GameBoard createGameBoard() {
        return new CheckedGameBoard(BOARD_SIZE);
    }
}
