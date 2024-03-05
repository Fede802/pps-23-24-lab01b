package e1Version2.board;

import e1Version2.utils.Pair;

import java.util.Optional;

public class CheckedGameBoard implements GameBoard{

    private final GameBoard gameBoard;

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
    public Optional<Pair<Integer, Integer>> getKnight() {
        return gameBoard.getKnight();
    }

    @Override
    public Optional<Pair<Integer, Integer>> getPawn() {
        return gameBoard.getPawn();
    }

    @Override
    public void placeKnight(int knightX, int knightY) {
        if(gameBoard.getPawn().isPresent()) {
            checkPiecesOverlap(gameBoard.getPawn().get(), new Pair<>(knightX, knightY));
        }
        gameBoard.placeKnight(knightX, knightY);
    }



    @Override
    public void placePawn(int pawnX, int pawnY) {
        if(gameBoard.getKnight().isPresent()) {
            checkPiecesOverlap(gameBoard.getKnight().get(), new Pair<>(pawnX, pawnY));
        }
        gameBoard.placePawn(pawnX, pawnY);
    }




}
