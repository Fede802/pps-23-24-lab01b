package e1.board;

import e1.piece.Piece;
import e1.utils.Pair;
import e1.utils.PositionGenerator;


public class BoardInitializerImpl implements BoardInitializer {

    private final PositionGenerator positionGenerator;
    private Board board;

    public BoardInitializerImpl(PositionGenerator positionGenerator) {
        this.positionGenerator = positionGenerator;
    }

    @Override
    public void initialize(Board board) {
        this.board = board;
        Pair<Integer,Integer> knightPosition = this.searchEmptyPositionFor(Piece.Pieces.KNIGHT);
        this.board.placeKnight(knightPosition);
        Pair<Integer,Integer> pawnPosition = this.searchEmptyPositionFor(Piece.Pieces.PAWN);
        this.board.placePawn(pawnPosition);
    }

    private Pair<Integer,Integer> searchEmptyPositionFor(Piece.Pieces type){
        Pair<Integer,Integer> newPosition = this.positionGenerator.generatePosition(this.board.size());
        if(type == Piece.Pieces.KNIGHT) {
            return this.board.getPawnPosition().isPresent() && this.board.getPawnPosition().get().equals(newPosition) ? searchEmptyPositionFor(Piece.Pieces.KNIGHT) : newPosition;
        }else{
            return this.board.getKnightPosition().isPresent() && this.board.getKnightPosition().get().equals(newPosition) ? searchEmptyPositionFor(Piece.Pieces.KNIGHT) : newPosition;
        }
    }
}
