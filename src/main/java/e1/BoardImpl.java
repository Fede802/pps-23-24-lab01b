package e1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BoardImpl implements Board {
    private final int boardSize;
    private List<List<Boolean>> board;
    public BoardImpl(int boardSize) {
        this.boardSize = boardSize;
        this.initBoard(boardSize);
    }

    private void initBoard(int boardSize) {
        this.board = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            this.board.add(new ArrayList<>());
            for (int j = 0; j < boardSize; j++) {
                this.board.get(i).add(false);
            }
        }
    }

    private void checkCellCoordinates(int cellX, int cellY) {
        if (cellX<0 || cellY<0 || cellX >= this.boardSize || cellY >= this.boardSize){
            throw new IllegalArgumentException();
        }
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
        this.checkCellCoordinates(cellX,cellY);
        this.board.get(cellX).set(cellY,true);
    }



    @Override
    public int getNumberOfElements() {
        return (int) this.board.stream().flatMap(Collection::stream).filter(i -> i).count();
    }

    @Override
    public void emptyCell(int cellX, int cellY) {
        this.checkCellCoordinates(cellX,cellY);
        this.board.get(cellX).set(cellY,false);
    }

    @Override
    public void resetBoard() {
        this.initBoard(boardSize);
    }

    @Override
    public boolean isCellFilled(int cellX, int cellY) {
        this.checkCellCoordinates(cellX,cellY);
        return this.board.get(cellX).get(cellY);
    }

}
