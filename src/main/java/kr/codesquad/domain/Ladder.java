package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {


    private final List<LadderLine> ladderLines;


    public Ladder() {
        this.ladderLines = new ArrayList<>();

    }

    public List<LadderLine> makeLadder(int numberOfPeople, int ladderHeight) {
        for (int row = 0; row < ladderHeight; row++) {
            LadderLine ladderLine = new LadderLine();
            ladderLine.makeLadderLine(numberOfPeople);
            ladderLines.add(ladderLine);
        }
        return this.ladderLines;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderLine ladderLine : ladderLines) {
            sb.append(ladderLine.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        ladder.makeLadder(4,5);
        System.out.println(ladder);

    }


}
