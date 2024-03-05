package e1Version3;

public interface Logics {
    
    /**
     * attempt to move Knight on position row,column, if possible
     * 
     * @param row
     * @param column
     * @return whether the pawn has been hit 
     */
    boolean hit(int row, int column);
    
    /**
     * @param row
     * @param column
     * @return whether position row,column has the knight
     */
    boolean hasKnight(int row, int column);
    
    /**
     * @param row
     * @param column
     * @return whether position row,column has the pawn
     */
    boolean hasPawn(int row, int column);

    /**
     * Attempt to force knight positioning
     *
     * @param row
     * @param column
     */
    void setKnightPosition(int row, int column);

    /**
     * Attempt to force pawn positioning
     *
     * @param row
     * @param column
     */
    void setPawnPosition(int row, int column);
}
