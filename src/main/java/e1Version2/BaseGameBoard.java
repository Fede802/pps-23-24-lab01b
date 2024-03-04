package e1Version2;

import java.util.Optional;

public class BaseGameBoard implements GameBoard {
    private final int boardSize;

    public BaseGameBoard(int boardSize) {
        this.boardSize = boardSize;
    }

    @Override
    public int size() {
        return this.boardSize;
    }

    @Override
    public Optional<Pair<Integer, Integer>> getKnight() {
        return Optional.empty();
    }

    @Override
    public Optional<Pair<Integer, Integer>> getPawn() {
        return Optional.empty();
    }
}
