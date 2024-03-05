package e1;

import e1.board.Board;
import e1.board.BoardImpl;
import e1.board.BoardInitializer;
import e1.piece.Piece;
import e1.utils.Pair;
import e1.utils.PositionGenerator;

import java.util.Optional;

public class LogicsImpl implements Logics{

    private final Board gameBoard;
    public LogicsImpl(int boardSize, BoardInitializer boardInitializer) {
        this.gameBoard = new BoardImpl(boardSize);
        boardInitializer.initialize(this.gameBoard);
    }

    @Override
    public boolean hit(int row, int column) {
        this.gameBoard.moveKnightTo(row,column);
        return this.hasPawn(row, column);
    }

    @Override
    public boolean hasKnight(int row, int column) throws IndexOutOfBoundsException {
        return gameBoard.hasKnight(new Pair<>(row,column));
    }

    @Override
    public boolean hasPawn(int row, int column) throws IndexOutOfBoundsException {
        return gameBoard.hasPawn(new Pair<>(row,column));
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
