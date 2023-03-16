package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {


    private final List<LadderRow> ladderLines;


    public Ladder() {
        this.ladderLines = new ArrayList<>();

    }

    public List<LadderRow> makeLadder(int numberOfPeople, int ladderHeight) {
        for (int row = 0; row < ladderHeight; row++) {
            LadderRow ladderRow = new LadderRow(numberOfPeople);
            ladderRow.makeLadderColumn();
            ladderRow.generateRandomLadderLine();
            ladderLines.add(ladderRow);
        }
        return this.ladderLines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderRow ladderLine : ladderLines) {
            sb.append(ladderLine.toString());
            sb.append("\n");
        }
        return sb.toString();
    }




}
