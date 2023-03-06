package kr.codesquad.view;

public class OutputView {

    public void printLadder(String[][] ladder) {
        for(String[] ladderRow : ladder) {
            printLadderRow(ladderRow);
        }
    }

    private void printLadderRow(String[] ladderRow) {
        for(String cell : ladderRow) {
            System.out.print(cell == null? " " : cell);
        }
        System.out.println();
    }
}
