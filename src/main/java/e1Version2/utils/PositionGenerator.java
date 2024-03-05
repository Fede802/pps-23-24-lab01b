package e1Version2.utils;


import e1Version2.utils.Pair;

public interface PositionGenerator {
    Pair<Integer,Integer> generatePosition(int minIndex, int maxIndex);
    Pair<Integer,Integer> generatePosition(int maxIndex);

}
