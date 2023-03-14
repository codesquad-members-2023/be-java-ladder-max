package kr.codesquad.domain;


import java.util.ArrayList;
import java.util.List;

public class LadderLine {
    private List<String> ladderline;


    LadderLine() {
        this.ladderline = new ArrayList<>();
    }

    public List<String> makeLadderLine(int numberOfPeople) {
        for (int column = 0; column < 2 * numberOfPeople - 1; column++) {
            makeBasicLadderRow(column);
        }
        return ladderline;
    }

    private void makeBasicLadderRow(int column) {
        if (column % 2 == 0) {
            ladderline.add("|");
            return;
        }
        ladderline.add("     ");
    }
}
