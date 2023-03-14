package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.HashMap;

import static kr.codesquad.domain.LadderLine.drawLine;

public class Ladder {
    private final int countOfPeople;
    private final int ladderHeight;
    private ArrayList<LadderLine> ladder;

    public Ladder(ArrayList nameList, int ladderHeight) {
        this.ladderHeight = ladderHeight;
        this.countOfPeople = nameList.size();
        createLadder();
    }

    private void createLadder() {
        ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            LadderLine ladderLine = new LadderLine(countOfPeople);
            ladderLine.createLine();
            ladder.add(ladderLine);
        }
    }

    public int ladderRide(int playerNumber) {
        for (LadderLine line : ladder) {
            playerNumber = line.canMove(playerNumber);
        }
        return playerNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        drawLine(ladder, sb);
        return sb.toString();
    }
}
