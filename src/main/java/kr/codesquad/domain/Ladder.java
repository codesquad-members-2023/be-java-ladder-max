package kr.codesquad.domain;

import java.util.ArrayList;

import static kr.codesquad.domain.LadderLine.drawLine;

public class Ladder {
    private ArrayList<LadderLine> ladder;

    public Ladder(int countOfPlayers, int ladderHeight) {
        createLadder(countOfPlayers,ladderHeight);
    }

    private void createLadder(int countOfPlayers,int ladderHeight) {
        ladder = new ArrayList<>();
        for (int i = 0; i < ladderHeight; i++) {
            LadderLine ladderLine = new LadderLine(countOfPlayers);
            ladderLine.createLine();
            ladder.add(ladderLine);
        }
    }

    public int rideLadder(int playerNumber) {
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
