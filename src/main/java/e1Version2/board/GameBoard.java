package e1Version2.board;

import e1Version2.piece.MovablePiece;
import e1Version2.utils.Pair;

import java.util.Optional;

public interface GameBoard {
    int size();
    MovablePiece getKnight();

    MovablePiece getPawn();

    void placeKnight(int knightX, int knightY) throws IllegalArgumentException;

    void placePawn(int pawnX, int pawnY) throws IllegalArgumentException;

    boolean isValidCell(int cellX, int cellY);
}
