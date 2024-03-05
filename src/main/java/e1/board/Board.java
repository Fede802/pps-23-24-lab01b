package e1.board;

import e1.utils.Pair;

import java.util.Optional;

public interface Board {
    int size();

    Optional<Pair<Integer,Integer>> getKnightPosition();

    Optional<Pair<Integer,Integer>> getPawnPosition();

    void placeKnight(Pair<Integer,Integer> knightCoordinates) throws IndexOutOfBoundsException;

    void placePawn(Pair<Integer, Integer> pawnCoordinates) throws IndexOutOfBoundsException;
    void moveKnightTo(int row, int column) throws IndexOutOfBoundsException;

    boolean hasPawn(Pair<Integer, Integer> pawnPosition) throws IndexOutOfBoundsException;

    boolean hasKnight(Pair<Integer, Integer> knightPosition) throws IndexOutOfBoundsException;
}
