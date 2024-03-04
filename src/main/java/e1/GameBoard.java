package e1;

import java.util.Optional;

public interface GameBoard {
    Optional<Pair<Integer,Integer>> getKnight();
    Optional<Pair<Integer,Integer>> getPawn();

    int size();
}
