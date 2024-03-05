package e1Version3.utils;


public interface PositionGenerator {
    Pair<Integer,Integer> generatePosition(int minIndex, int maxIndex);
    Pair<Integer,Integer> generatePosition(int maxIndex);

}
