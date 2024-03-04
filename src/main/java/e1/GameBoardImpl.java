package e1;

import java.util.Optional;

public class GameBoardImpl implements GameBoard {

    private final Board board;
    private Pair<Integer,Integer> knight;
    public GameBoardImpl(int boardSize) {
        this.board = new BoardImpl(boardSize);
    }

    @Override
    public Optional<Pair<Integer, Integer>> getKnight() {
        return this.knight != null? Optional.of(this.knight):Optional.empty();
    }
    @Override
    public Optional<Pair<Integer, Integer>> getPawn() {
        return Optional.empty();
    }
    @Override
    public int size() {
        return this.board.size();
    }
    @Override
    public void placeKnight(int knightX, int knightY) {
        this.knight = this.board.fillCell(knightX,knightY);
    }
}
