package e1Version2;

public interface Movement {
    boolean isValidMovement(Pair<Integer, Integer> move);
    void makeMovement(Piece piece, Pair<Integer, Integer> move) throws IllegalArgumentException;
}
