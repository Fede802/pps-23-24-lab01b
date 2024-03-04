package e1;

import java.util.Optional;

public interface PositionGenerator {
    Pair<Integer,Integer> generatePosition(int minIndex, int maxIndex);

    Pair<Integer,Integer> generatePosition(int maxIndex);
}
