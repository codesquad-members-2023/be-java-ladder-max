package kr.codesquad.view;

public class OutputView {

    public void printLadder(String[][] ladder) {
        for(int row = 0; row < ladder.length; row++) {
            printLadderRow(ladder[row]);
        }
    }

    private void printLadderRow(String[] ladderRow) {
        for (int col = 0; col < ladderRow.length; col++) {
            System.out.print(ladderRow[col] == null? " " : ladderRow[col]);
        }
        System.out.println();
    }
}
