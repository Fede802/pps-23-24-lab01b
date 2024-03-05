package e1Version3.piece;

import e1Version3.utils.Pair;

import java.util.Optional;

public interface Piece {
    enum Pieces{
        KNIGHT,
        PAWN
    }
    Optional<Pair<Integer,Integer>> getPieceCoordinate();
    void setPieceCoordinate(Pair<Integer,Integer> coordinate);
}
