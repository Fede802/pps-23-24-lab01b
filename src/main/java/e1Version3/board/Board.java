package e1Version3.board;

import e1Version3.utils.Pair;

import java.util.Optional;

public interface Board {
    int size();

    Optional<Pair<Integer,Integer>> getKnightPosition();

    Optional<Pair<Integer,Integer>> getPawnPosition();

    void placeKnight(Pair<Integer,Integer> knightCoordinates) throws IndexOutOfBoundsException;

    void placePawn(Pair<Integer, Integer> pawnCoordinates) throws IndexOutOfBoundsException;
}
