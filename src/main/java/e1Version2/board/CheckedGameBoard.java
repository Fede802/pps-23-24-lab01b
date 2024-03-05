package e1Version2.board;

import e1Version2.piece.MovablePiece;
import e1Version2.utils.Pair;

import java.util.Optional;

public class CheckedGameBoard implements GameBoard{

    private final GameBoard gameBoard;

    @Override
    public boolean isValidCell(int cellX, int cellY) {
        return gameBoard.isValidCell(cellX, cellY);
    }

    public CheckedGameBoard(int boardSize) {
        gameBoard = new BaseGameBoard(boardSize);
    }

    private void checkPiecesOverlap(Pair<Integer, Integer> boardPiece, Pair<Integer, Integer> newPiecePosition) {
        if (boardPiece.equals(newPiecePosition)) {
            throw new IllegalStateException();
        }
    }
    @Override
    public int size() {
        return gameBoard.size();
    }

    @Override
    public MovablePiece getKnight() {
        return gameBoard.getKnight();
    }

    @Override
    public MovablePiece getPawn() {
        return gameBoard.getPawn();
    }

    @Override
    public void placeKnight(int knightX, int knightY) {
        if(gameBoard.getPawn().getPiece().isPresent()) {
            checkPiecesOverlap(gameBoard.getPawn().getPiece().get(), new Pair<>(knightX, knightY));
        }
        gameBoard.placeKnight(knightX, knightY);
    }



    @Override
    public void placePawn(int pawnX, int pawnY) {
        if(gameBoard.getKnight().getPiece().isPresent()) {
            checkPiecesOverlap(gameBoard.getKnight().getPiece().get(), new Pair<>(pawnX, pawnY));
        }
        gameBoard.placePawn(pawnX, pawnY);
    }




}
