package e1Version3.piece;

import e1Version3.utils.Pair;

import java.util.Optional;

public class PieceImpl implements Piece{

    private Pair<Integer,Integer> pieceCoordinate;
    @Override
    public Optional<Pair<Integer, Integer>> getPieceCoordinate() {
        return this.pieceCoordinate != null ? Optional.of(this.pieceCoordinate) : Optional.empty();
    }

    @Override
    public void setPieceCoordinate(Pair<Integer, Integer> coordinate) {
        this.pieceCoordinate = new Pair<>(coordinate.getX(),coordinate.getY());
    }
}
