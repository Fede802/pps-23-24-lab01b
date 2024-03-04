package e1Version2;

import e1.Pair;

public interface PositionGenerator {
    Pair<Integer,Integer> generatePosition(int minIndex, int maxIndex);

    Pair<Integer,Integer> generatePosition(int maxIndex);
}
