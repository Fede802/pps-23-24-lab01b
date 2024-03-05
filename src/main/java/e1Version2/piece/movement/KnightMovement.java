package e1Version2.piece.movement;

import e1Version2.utils.Pair;

public class KnightMovement extends BasePieceMovement {
    public final static Pair<Integer,Integer> VALID_MOVE = new Pair<>(2,1);
    public final static Pair<Integer,Integer> INVALID_MOVE = new Pair<>(2,2);
    @Override
    public boolean isValidMovement(Pair<Integer, Integer> move) {
        System.out.println("KnightMovement"+move.getX());
        System.out.println("KnightMovement"+move.getY());
        System.out.println("KnightMovement return "+(Math.abs(move.getX())+Math.abs(move.getY()) == 3));
        return Math.abs(move.getX())+Math.abs(move.getY()) == 3;
    }

}
