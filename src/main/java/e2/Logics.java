package e2;


import e2.utils.Pair;

public interface Logics {

    ClickResult clickCell(Pair<Integer, Integer> cellPosition);

    void toggleFlag(Pair<Integer, Integer> cellPosition);

    boolean isMineCell(Pair<Integer, Integer> cellPosition);

    boolean isCellClicked(Pair<Integer, Integer> cellPosition);

    int numberOfMinesAround(Pair<Integer, Integer> cellPosition);

    boolean isCellFlagged(Pair<Integer, Integer> cellPosition);

}
