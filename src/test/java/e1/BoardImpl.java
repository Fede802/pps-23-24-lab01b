package e1;

public class BoardImpl implements Board {
    private int boardSize;
    public BoardImpl(int boardSize) {
        this.boardSize = boardSize;
    }
    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public int size() {
        return boardSize;
    }
}
