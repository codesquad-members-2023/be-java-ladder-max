package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private ArrayList<String> ladder;

    public void makeLadderShape(UserInput userInput) {
        this.ladder = new ArrayList<>();
        List<String> playerList = Arrays.asList(userInput.names.split(","));
        for (int i = 0; i < userInput.height; i++) {
            this.ladder.add(fillLadderLine(playerList.size()));
        }
    }

    private String fillLadderLine(int numberOfPlayer) {
        StringBuilder ladderLine = new StringBuilder();
        for (int i = 0; i < numberOfPlayer; i++){
           ladderLine.append(fillRandomLadderStep(i, numberOfPlayer));
        }
        return ladderLine.toString();
    }
    
    private String fillRandomLadderStep(int index, int numberOfPlayer) {
        if (index == numberOfPlayer - 1) {
            return "|";
        }
        return (Math.random() > 0.5) ? "|-----" : "|     ";
    }

    public ArrayList<String> getLadder() {
        return this.ladder;
    }
}
