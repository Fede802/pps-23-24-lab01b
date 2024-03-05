package e1Version2;

import e1Version2.board.CheckedGameBoard;
import e1Version2.board.GameBoard;
import e1Version2.utils.Pair;
import e1Version2.utils.PositionGenerator;
import e1Version2.utils.RandomPositionGenerator;

import java.util.Optional;

public class LogicsImpl implements Logics{

    private final static int BOARD_SIZE = 5;
    private final GameBoard gameBoard;
    private final PositionGenerator positionGenerator;

    public LogicsImpl(){
        this.gameBoard = new CheckedGameBoard(BOARD_SIZE);
        this.positionGenerator = new RandomPositionGenerator();
        Pair<Integer,Integer> knightPosition = this.randomEmptyPosition();
        this.gameBoard.placeKnight(knightPosition.getX(),knightPosition.getY());
        Pair<Integer,Integer> pawnPosition = this.randomEmptyPosition();
        this.gameBoard.placePawn(pawnPosition.getX(),pawnPosition.getY());
    }

    private boolean checkPieceInPosition(boolean isKnight, int row, int col) {
        Optional<Pair<Integer,Integer>> piece = isKnight?this.gameBoard.getKnight():this.gameBoard.getPawn();
        if(piece.isPresent()){
            return piece.get().equals(new Pair<>(row, col));
        }
        return false;
    }

    private final Pair<Integer,Integer> randomEmptyPosition(){
        Pair<Integer,Integer> pos = this.positionGenerator.generatePosition(gameBoard.size());
        // the recursive call below prevents clash with an existing pawn
        return this.gameBoard.getPawn().isPresent() && this.gameBoard.getPawn().get().equals(pos) ? randomEmptyPosition() : pos;
    }

    @Override
    public boolean hit(int row, int col) {
        if (row<0 || col<0 || row >= this.gameBoard.size() || col >= this.gameBoard.size()) {
            throw new IndexOutOfBoundsException();
        }
        if(this.gameBoard.getKnight().isPresent()){ //todo throw error
            // Below a compact way to express allowed moves for the knight
            int x = row-this.gameBoard.getKnight().get().getX();
            int y = col-this.gameBoard.getKnight().get().getY();
            if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
                this.gameBoard.placeKnight(row,col);
                if(this.gameBoard.getKnight().isPresent() && this.gameBoard.getPawn().isPresent()){//todo throw error
                    return this.gameBoard.getPawn().equals(this.gameBoard.getKnight());
                }

            }
        }
        return false;
    }

    @Override
    public boolean hasKnight(int row, int col){
        return checkPieceInPosition(true,row, col);
    }

    @Override
    public boolean hasPawn(int row, int col){
        return checkPieceInPosition(false,row, col);
    }


}
