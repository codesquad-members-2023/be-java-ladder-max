package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private List<Boolean> ladderRow;

    public LadderRow(int columnSize) {
        ladderRow = makeLadderRow(columnSize);
    }

    private List<Boolean> makeLadderRow(int columnSize) {
        List<Boolean> ladderRow = new ArrayList<>();
        for(int col = 0; col < columnSize; col++) {
            ladderRow.add(false);
        }
        return ladderRow;
    }

    public void setPlayerLine(int column) {
        if(column % 2 == 0) {
            ladderRow.set(column, true);
        }
    }

    public void setBridge(int column) {
        if(column % 2 == 1) {
            ladderRow.set(column, true);
        }
    }

    public boolean isPlayerLine(int column) {
        return column % 2 == 0 && ladderRow.get(column);
    }

    public boolean isBridge(int column) {
        return ladderRow.get(column) == true;
    }

}
