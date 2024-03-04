package e1Version2;

import java.util.Optional;

public interface GameBoard {
    int size();
    Optional<Pair<Integer,Integer>> getKnight();

    Optional<Pair<Integer,Integer>> getPawn();
}
