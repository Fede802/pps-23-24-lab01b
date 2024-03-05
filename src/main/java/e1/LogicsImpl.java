package e1;

import e1.board.Board;
import e1.board.BoardImpl;
import e1.piece.Piece;
import e1.utils.Pair;
import e1.utils.PositionGenerator;

import java.util.Optional;

public class LogicsImpl implements Logics{

    private final Board gameBoard;
    private final PositionGenerator positionGenerator;
    public LogicsImpl(int boardSize, PositionGenerator positionGenerator) {
        this.gameBoard = new BoardImpl(boardSize);
        this.positionGenerator = positionGenerator;
        this.initBoard();

    }

    private void initBoard(){
        Pair<Integer,Integer> knightPosition = this.searchEmptyPositionFor(Piece.Pieces.KNIGHT);
        this.gameBoard.placeKnight(knightPosition);
        Pair<Integer,Integer> pawnPosition = this.searchEmptyPositionFor(Piece.Pieces.PAWN);
        this.gameBoard.placePawn(pawnPosition);
    }

    private Pair<Integer,Integer> searchEmptyPositionFor(Piece.Pieces type){
        Pair<Integer,Integer> newPosition = this.positionGenerator.generatePosition(gameBoard.size());
        if(type == Piece.Pieces.KNIGHT) {
            return this.gameBoard.getPawnPosition().isPresent() && this.gameBoard.getPawnPosition().get().equals(newPosition) ? searchEmptyPositionFor(Piece.Pieces.KNIGHT) : newPosition;
        }else{
            return this.gameBoard.getKnightPosition().isPresent() && this.gameBoard.getKnightPosition().get().equals(newPosition) ? searchEmptyPositionFor(Piece.Pieces.KNIGHT) : newPosition;
        }
    }

    private boolean checkPieceInPosition(Piece.Pieces pieceType, int row, int col) {
        Optional<Pair<Integer,Integer>> piece = pieceType == Piece.Pieces.KNIGHT?this.gameBoard.getKnightPosition():this.gameBoard.getPawnPosition();
        return piece.isPresent() && piece.get().equals(new Pair<>(row, col));
    }


    @Override
    public boolean hit(int row, int column) {
        this.gameBoard.moveKnightTo(row,column);
        return this.hasPawn(row, column);
    }

    @Override
    public boolean hasKnight(int row, int column) throws IndexOutOfBoundsException {
        if(!this.gameBoard.isValidCell(row,column)){
            throw new IndexOutOfBoundsException();
        }
        return checkPieceInPosition(Piece.Pieces.KNIGHT,row, column);
    }

    @Override
    public boolean hasPawn(int row, int column) throws IndexOutOfBoundsException {
        if(!this.gameBoard.isValidCell(row,column)){
            throw new IndexOutOfBoundsException();
        }
        return checkPieceInPosition(Piece.Pieces.PAWN,row, column);
    }

    @Override
    public void setKnightPosition(int row, int column) throws IndexOutOfBoundsException{
        this.gameBoard.placeKnight(new Pair<>(row,column));
    }

    @Override
    public void setPawnPosition(int row, int column) throws IndexOutOfBoundsException{
        this.gameBoard.placePawn(new Pair<>(row,column));
    }
}
