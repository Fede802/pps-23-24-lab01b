package e2;

public interface Logics {
    ClickResult clickCell(Pair<Integer, Integer> cellPosition);
    void toggleFlag(Pair<Integer, Integer> cellPosition);
    boolean isMineCell(Pair<Integer, Integer> cellPosition);
    boolean isCellClicked(Pair<Integer, Integer> cellPosition);
    char[] minesAround(Pair<Integer, Integer> cellPosition);
    boolean isCellFlagged(Pair<Integer, Integer> cellPosition);
    boolean hasMine(Pair<Integer, Integer> cellPosition);

}
