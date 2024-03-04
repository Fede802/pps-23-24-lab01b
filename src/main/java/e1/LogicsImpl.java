package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	

	private final Random random = new Random();
	private final GameBoard gameBoard;
	 
    public LogicsImpl(int size){
    	this.gameBoard = new GameBoardImpl(size);
		Pair<Integer,Integer> knightPosition = this.randomEmptyPosition();
        this.gameBoard.placeKnight(knightPosition.getX(),knightPosition.getY());
		Pair<Integer,Integer> pawnPosition = this.randomEmptyPosition();
		this.gameBoard.placePawn(pawnPosition.getX(),pawnPosition.getY());

    }
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(gameBoard.size()),this.random.nextInt(gameBoard.size()));
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
	public boolean hasKnight(int row, int col) {
		System.out.println(this.gameBoard.getKnight().get());
		if (row<0 || col<0 || row >= this.gameBoard.size() || col >= this.gameBoard.size()) {
			throw new IllegalArgumentException();
		}
		System.out.println(this.gameBoard.getKnight().get());
		return this.gameBoard.getKnight().get().equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		if (row<0 || col<0 || row >= this.gameBoard.size() || col >= this.gameBoard.size()) {
			throw new IllegalArgumentException();
		}

		return this.gameBoard.getPawn().get().equals(new Pair<>(row,col));
	}




	@Override
	public void setKnightPosition(int knightXCoordinate, int knightYCoordinate){
		if (knightXCoordinate<0 || knightYCoordinate<0 || knightXCoordinate >= this.gameBoard.size() || knightYCoordinate >= this.gameBoard.size()) {
			throw new IllegalArgumentException();
		}
		if (this.gameBoard.getPawn().get().equals(new Pair<>(knightXCoordinate,knightYCoordinate))){
			throw new IllegalStateException();
		}
		this.gameBoard.placeKnight(knightXCoordinate,knightYCoordinate);
		System.out.println(this.gameBoard.getKnight().get());
	}

	@Override
	public void setPawnPosition(int pawnXCoordinate, int pawnYCoordinate) throws IllegalArgumentException {
		if (pawnXCoordinate<0 || pawnYCoordinate<0 || pawnXCoordinate >= this.gameBoard.size() || pawnYCoordinate >= this.gameBoard.size()) {
			throw new IllegalArgumentException();
		}
		if (this.gameBoard.getKnight().get().equals(new Pair<>(pawnXCoordinate,pawnYCoordinate))){
			throw new IllegalStateException();
		}
		this.gameBoard.placePawn(pawnXCoordinate,pawnYCoordinate);
	}


}
