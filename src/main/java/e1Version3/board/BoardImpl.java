package e1Version3.board;

import e1Version3.piece.PieceFactory;
import e1Version3.piece.PieceFactoryImpl;
import e1Version3.piece.MovablePiece;
import e1Version3.utils.Pair;

import java.util.Arrays;
import java.util.List;
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
}
