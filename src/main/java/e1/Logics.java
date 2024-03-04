package e1;

public interface Logics{
    
    /**
     * attempt to move Knight on position row,col, if possible
     * 
     * @param row
     * @param col
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int col);
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the knight
     */
    boolean hasKnight(int row, int col) throws IllegalArgumentException;
    
    /**
     * @param row
     * @param col
     * @return whether position row,col has the pawn
     */
    boolean hasPawn(int row, int col) throws IllegalArgumentException;



    void setKnightPosition(int knightXCoordinate, int knightYCoordinate) throws IllegalArgumentException;

    void setPawnPosition(int pawnXCoordinate, int pawnYCoordinate) throws IllegalArgumentException;


}
