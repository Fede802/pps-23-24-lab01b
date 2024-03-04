package e1;

import java.util.*;

public class LogicsImpl implements Logics {
	
	private Pair<Integer,Integer> pawn;
	private Pair<Integer,Integer> knight;
	private final Random random = new Random();
	private final int size;
	 
    public LogicsImpl(int size){
    	this.size = size;
        this.pawn = this.randomEmptyPosition();
        this.knight = this.randomEmptyPosition();	
    }
    
	private final Pair<Integer,Integer> randomEmptyPosition(){
    	Pair<Integer,Integer> pos = new Pair<>(this.random.nextInt(size),this.random.nextInt(size));
    	// the recursive call below prevents clash with an existing pawn
    	return this.pawn!=null && this.pawn.equals(pos) ? randomEmptyPosition() : pos;
    }
    
	@Override
	public boolean hit(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Below a compact way to express allowed moves for the knight
		int x = row-this.knight.getX();
		int y = col-this.knight.getY();
		if (x!=0 && y!=0 && Math.abs(x)+Math.abs(y)==3) {
			this.knight = new Pair<>(row,col);
			return this.pawn.equals(this.knight);
		}
		return false;
	}

	@Override
	public boolean hasKnight(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IllegalArgumentException();
		}
		return this.knight.equals(new Pair<>(row,col));
	}

	@Override
	public boolean hasPawn(int row, int col) {
		if (row<0 || col<0 || row >= this.size || col >= this.size) {
			throw new IllegalArgumentException();
		}
		return this.pawn.equals(new Pair<>(row,col));
	}




	@Override
	public void setKnightPosition(int knightXCoordinate, int knightYCoordinate){
		if (knightXCoordinate<0 || knightYCoordinate<0 || knightXCoordinate >= this.size || knightYCoordinate >= this.size) {
			throw new IllegalArgumentException();
		}
		if (this.pawn.equals(new Pair<>(knightXCoordinate,knightYCoordinate))){
			throw new IllegalStateException();
		}
		this.knight = new Pair<>(knightXCoordinate,knightYCoordinate);
	}

	@Override
	public void setPawnPosition(int pawnXCoordinate, int pawnYCoordinate) throws IllegalArgumentException {
		if (pawnXCoordinate<0 || pawnYCoordinate<0 || pawnXCoordinate >= this.size || pawnYCoordinate >= this.size) {
			throw new IllegalArgumentException();
		}
		if (this.knight.equals(new Pair<>(pawnXCoordinate,pawnYCoordinate))){
			throw new IllegalStateException();
		}
		this.pawn = new Pair<>(pawnXCoordinate,pawnYCoordinate);
	}


}
