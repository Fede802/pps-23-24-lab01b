package e1;

import java.util.Optional;

public class GameBoardImpl implements GameBoard {

    private int size;
    public GameBoardImpl(int boardSize) {
        this.size = boardSize;
    }


    @Override
    public Optional<Pair<Integer, Integer>> getKnight() {
        return Optional.empty();
    }

    @Override
    public Optional<Pair<Integer, Integer>> getPawn() {
        return Optional.empty();
    }

    @Override
    public int size() {
        return this.size;
    }
}
