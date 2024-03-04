package e1Version2;

import java.util.Optional;

public class CheckedGameBoard implements GameBoard{

    private final GameBoard gameBoard;

    public CheckedGameBoard(int boardSize) {
        gameBoard = new BaseGameBoard(boardSize);
    }

    @Override
    public int size() {
        return gameBoard.size();
    }

    @Override
    public Optional<Pair<Integer, Integer>> getKnight() {
        return gameBoard.getKnight();
    }

    @Override
    public Optional<Pair<Integer, Integer>> getPawn() {
        return gameBoard.getPawn();
    }

    @Override
    public void placeKnight(int knightX, int knightY) {
        gameBoard.placeKnight(knightX, knightY);
    }

    @Override
    public void placePawn(int pawnX, int pawnY) {
        gameBoard.placePawn(pawnX, pawnY);
    }


}
