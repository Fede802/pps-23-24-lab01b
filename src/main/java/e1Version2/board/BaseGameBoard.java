package e1Version2.board;

import e1Version2.utils.Pair;

import java.util.Optional;

public class BaseGameBoard implements GameBoard {
    private final int boardSize;

    private Pair<Integer,Integer> knight;
    private Pair<Integer,Integer> pawn;

    public BaseGameBoard(int boardSize) {
        this.boardSize = boardSize;
    }
    private void checkCellCoordinates(int cellX, int cellY) {
        if (cellX<0 || cellY<0 || cellX >= this.boardSize || cellY >= this.boardSize){
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int size() {
        return this.boardSize;
    }

    @Override
    public Optional<Pair<Integer, Integer>> getKnight() {
        return this.knight != null? Optional.of(this.knight):Optional.empty();
    }
    @Override
    public Optional<Pair<Integer, Integer>> getPawn() {
        return this.pawn != null ? Optional.of(this.pawn) : Optional.empty();
    }

    @Override
    public void placeKnight(int knightX, int knightY) {
        this.checkCellCoordinates(knightX,knightY);
        this.knight = new Pair<>(knightX,knightY);
    }

    @Override
    public void placePawn(int pawnX, int pawnY) {
        this.checkCellCoordinates(pawnX,pawnY);
        this.pawn = new Pair<>(pawnX,pawnY);
    }


}
