package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Ladder {
    private final ArrayList<LadderLine> ladder;

    public Ladder() {
        ladder = new ArrayList<>();
    }

    public void createValidLadder(int countOfPlayers, int ladderHeight){
        while(!validateLadderConnectivity(countOfPlayers)){
            ladder.clear();
            createLadder(countOfPlayers,ladderHeight);
        }
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

    private boolean validateLadderConnectivity(int countOfPlayers) {
        Boolean[] checkHung = new Boolean[countOfPlayers - 1];
        Arrays.fill(checkHung,false);
        for (LadderLine line : ladder) {
            line.markConnectedPoints(checkHung, line);
        }
        return Arrays.stream(checkHung).allMatch(b -> b);
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
