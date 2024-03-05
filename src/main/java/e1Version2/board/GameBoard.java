package e1Version2.board;

import e1Version2.utils.Pair;

import java.util.Optional;

public interface GameBoard {
    int size();
    Optional<Pair<Integer,Integer>> getKnight();

    Optional<Pair<Integer,Integer>> getPawn();

    void placeKnight(int knightX, int knightY) throws IllegalArgumentException;

    void placePawn(int pawnX, int pawnY) throws IllegalArgumentException;
}
