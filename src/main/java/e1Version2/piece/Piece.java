package e1Version2.piece;

import e1Version2.utils.Pair;

import java.util.Optional;

public interface Piece {
    Optional<Pair<Integer,Integer>> getPiece();
    void setPiece(int pieceX, int pieceY);

}
