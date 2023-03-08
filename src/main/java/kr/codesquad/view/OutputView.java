package kr.codesquad.view;

import kr.codesquad.domain.Ladder;

public class OutputView {

    public void printLadder(Ladder ladder) {
        StringBuilder sb = new StringBuilder();
        for(char[] ladderRow : ladder.getLadder()) {
            appendLadderRowToStringBuilder(ladderRow, sb);
        }

        System.out.println(sb.toString());
    }

    private void appendLadderRowToStringBuilder(char[] ladderRow, StringBuilder sb) {
        for(char cell : ladderRow) {
            sb.append(cell);
        }
        sb.append(System.lineSeparator());
    }
}
