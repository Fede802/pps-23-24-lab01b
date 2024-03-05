package e1Version2;

import e1Version2.board.CheckedGameBoard;
import e1Version2.board.GameBoard;
import e1Version2.piece.Piece;
import e1Version2.utils.Pair;
import e1Version2.utils.PositionGenerator;

import java.util.Optional;

public class LogicsImpl implements Logics{


    private final GameBoard gameBoard;
    private final PositionGenerator positionGenerator;

    public LogicsImpl(int boardSize, PositionGenerator positionGenerator){
        this.gameBoard = new CheckedGameBoard(boardSize);
        this.positionGenerator = positionGenerator;
        this.initBoard();

    }

    private void initBoard(){
        Pair<Integer,Integer> knightPosition = this.searchEmptyPositionFor(Piece.Pieces.KNIGHT);
        this.gameBoard.placeKnight(knightPosition.getX(),knightPosition.getY());
        Pair<Integer,Integer> pawnPosition = this.searchEmptyPositionFor(Piece.Pieces.PAWN);
        this.gameBoard.placePawn(pawnPosition.getX(),pawnPosition.getY());
    }

    private Pair<Integer,Integer> searchEmptyPositionFor(Piece.Pieces type){
        Pair<Integer,Integer> newPosition = this.positionGenerator.generatePosition(gameBoard.size());
        if(type == Piece.Pieces.KNIGHT) {
            return this.gameBoard.getPawn().getPiece().isPresent() && this.gameBoard.getPawn().getPiece().get().equals(newPosition) ? searchEmptyPositionFor(Piece.Pieces.KNIGHT) : newPosition;
        }else{
            return this.gameBoard.getKnight().getPiece().isPresent() && this.gameBoard.getKnight().getPiece().get().equals(newPosition) ? searchEmptyPositionFor(Piece.Pieces.KNIGHT) : newPosition;
        }
    }
    private boolean checkPieceInPosition(Piece.Pieces pieceType, int row, int col) {
        Optional<Pair<Integer,Integer>> piece = pieceType == Piece.Pieces.KNIGHT?this.gameBoard.getKnight().getPiece():this.gameBoard.getPawn().getPiece();
        return piece.isPresent() && piece.get().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasKnight(int row, int col){
        return checkPieceInPosition(Piece.Pieces.KNIGHT,row, col);
    }

    @Override
    public boolean hasPawn(int row, int col){
        return checkPieceInPosition(Piece.Pieces.PAWN,row, col);
    }

    @Override
    public void setKnightPosition(int i, int j) {
        this.gameBoard.getKnight().setPiece(i,j);
    }

    @Override
    public void setPawnPosition(int i, int j) {
        this.gameBoard.getPawn().setPiece(i,j);
    }


    @Override
    public boolean hit(int row, int col) {

        System.out.println("LogicImpl destX"+row);
        System.out.println("LogicImpl destY"+col);
        if(this.gameBoard.getKnight().canMoveTo(new Pair<>(row,col))) {

            this.gameBoard.placeKnight(row, col);
            return this.hasPawn(row, col);
        }
        return false;

//        if (!gameBoard.isValidCell(row,col)) {
//            throw new IndexOutOfBoundsException();
//        }

//        if(this.gameBoard.getKnight().isEmpty() || this.gameBoard.getPawn().isEmpty()){
//            throw new IllegalStateException();
//        }
//
//
//        //todo throw error
//            // Below a compact way to express allowed moves for the knight
//        int x = row-this.gameBoard.getKnight().get().getX();
//        int y = col-this.gameBoard.getKnight().get().getY();
//        if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
//            this.gameBoard.placeKnight(row,col);
//            if(this.gameBoard.getKnight().isPresent() && this.gameBoard.getPawn().isPresent()){//todo throw error
//                return this.gameBoard.getPawn().equals(this.gameBoard.getKnight());
//            }
//        }
//        return false;
    }




}
