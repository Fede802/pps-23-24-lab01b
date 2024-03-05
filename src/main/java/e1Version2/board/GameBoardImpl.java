package e1Version2.board;

import e1Version2.piece.*;
import e1Version2.utils.Pair;

import java.util.Optional;

public class GameBoardImpl implements GameBoard {
    private final int boardSize;
    private final MovablePiece knight;
    private final MovablePiece pawn;

    public GameBoardImpl(int boardSize) {
        this.boardSize = boardSize;
        PieceFactory pieceFactory = new PieceFactoryImpl();
        this.knight = pieceFactory.createKnight();
        this.pawn = pieceFactory.createPawn();
    }
    private void checkCellCoordinates(int cellX, int cellY) {
        if (!isValidCell(cellX,cellY)){
            //todo maybe outofbound
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int size() {
        return this.boardSize;
    }

    @Override
    public Optional<Pair<Integer,Integer>> getKnightPosition() {
        return this.knight.getPiece();
    }
    @Override
    public Optional<Pair<Integer,Integer>> getPawnPosition() {
        return this.pawn.getPiece();
    }

    @Override
    public void placeKnight(int knightX, int knightY) {
        this.checkCellCoordinates(knightX,knightY);
        this.knight.setPiece(knightX,knightY);
    }

    @Override
    public void placePawn(int pawnX, int pawnY) {
        this.checkCellCoordinates(pawnX,pawnY);
        this.pawn.setPiece(pawnX,pawnY);
    }

    @Override
    public boolean isValidCell(int cellX, int cellY) {
        return cellX>=0 && cellY>=0 && cellX < this.boardSize && cellY < this.boardSize;
    }

    @Override
    public void moveKnightTo(int row, int col) {
        this.checkCellCoordinates(row,col);
        this.knight.moveTo(new Pair<>(row,col));
    }


}
