package e1Version2;



public interface PositionGenerator {
    Pair<Integer,Integer> generatePosition(int minIndex, int maxIndex);

    Pair<Integer,Integer> generatePosition(int maxIndex);
}
