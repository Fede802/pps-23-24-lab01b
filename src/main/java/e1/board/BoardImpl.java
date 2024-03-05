package e1.board;

import e1.piece.PieceFactory;
import e1.piece.PieceFactoryImpl;
import e1.piece.MovablePiece;
import e1.utils.Pair;

import java.util.Optional;

public class BoardImpl implements Board {

    private final int boardSize;

    private final MovablePiece knight;
    private final MovablePiece pawn;
    public BoardImpl(int boardSize) {
        this.boardSize = boardSize;
        PieceFactory pieceFactory = new PieceFactoryImpl();
        this.knight = pieceFactory.createKnight();
        this.pawn = pieceFactory.createPawn();
    }

    private void checkCellCoordinates(Pair<Integer,Integer> coordinate) throws IndexOutOfBoundsException{
        if(!isValidCell(coordinate.getX(),coordinate.getY())){
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isValidCell(int cellX, int cellY) {
        return cellX>=0 && cellY>=0 && cellX < this.boardSize && cellY < this.boardSize;
    }

    @Override
    public int size() {
        return boardSize;
    }

    @Override
    public Optional<Pair<Integer, Integer>> getKnightPosition() {
        return this.knight.getPieceCoordinate();
    }

    @Override
    public Optional<Pair<Integer, Integer>> getPawnPosition() {
        return this.pawn.getPieceCoordinate();
    }

    @Override
    public void placeKnight(Pair<Integer,Integer> knightCoordinates) throws IndexOutOfBoundsException{
        this.checkCellCoordinates(knightCoordinates);
        this.knight.setPieceCoordinate(knightCoordinates);
    }

    @Override
    public void placePawn(Pair<Integer, Integer> pawnCoordinates) throws IndexOutOfBoundsException {
        this.checkCellCoordinates(pawnCoordinates);
        this.pawn.setPieceCoordinate(pawnCoordinates);
    }
    @Override
    public void moveKnightTo(int row, int column) throws IndexOutOfBoundsException{
        this.checkCellCoordinates(new Pair<>(row,column));
        this.knight.moveTo(new Pair<>(row,column));
    }

    @Override
    public boolean hasPawn(Pair<Integer, Integer> pawnPosition) throws IndexOutOfBoundsException {
        this.checkCellCoordinates(pawnPosition);
        return pawnPosition.equals(this.pawn.getPieceCoordinate().orElse(null));
    }

    @Override
    public boolean hasKnight(Pair<Integer, Integer> knightPosition) throws IndexOutOfBoundsException {
        this.checkCellCoordinates(knightPosition);
        return knightPosition.equals(this.knight.getPieceCoordinate().orElse(null));
    }
}
