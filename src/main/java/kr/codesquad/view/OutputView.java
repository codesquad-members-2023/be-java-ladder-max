package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

public class OutputView {

    public void printLadder(Ladder ladder) {
        for(String[] ladderRow : ladder.getLadder()) {
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
