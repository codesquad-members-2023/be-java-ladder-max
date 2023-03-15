package kr.codesquad.domain;

import java.util.ArrayList;

public class Ladder {
    private ArrayList<LadderLine> ladder;

    public Ladder(int countOfPlayers, int ladderHeight) {
        ladder = new ArrayList<>();
        createLadder(countOfPlayers,ladderHeight);
    }

    private void createLadder(int countOfPlayers,int ladderHeight) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new LadderLine(countOfPlayers));
        }
    }

    public int rideLadder(int playerLocation) {
        int destination = playerLocation;
        for (LadderLine line : ladder) {
            destination = line.getNextPosition(destination);
        }
        return destination;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (LadderLine line : ladder) {
            sb.append("  |");
            line.drawLine(sb, line);
            sb.append("\n");
        }
        return sb.toString();
    }
}
