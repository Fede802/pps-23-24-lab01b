package e1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BoardImpl implements Board {
    private int boardSize;
    private List<List<Boolean>> board;
    public BoardImpl(int boardSize) {
        this.boardSize = boardSize;
        this.board = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                this.board.get(i).add(false);
            }
        }
        System.out.println(board);
    }
    @Override
    public boolean isEmpty() {
        return this.getNumberOfElements() == 0;
    }

    @Override
    public int size() {
        return boardSize;
    }

    @Override
    public void fillCell(int cellX, int cellY) {
        this.board.get(cellX).set(cellY,true);
    }

    @Override
    public int getNumberOfElements() {
        return (int) this.board.stream().flatMap(Collection::stream).filter(i -> i).count();
    }

}
