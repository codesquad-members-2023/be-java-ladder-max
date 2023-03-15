package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        return (generateBoolean()) ? "|-----" : "|     ";
    }

    private List<Boolean> generateRandomStepList(int numberOfPlayer) {
        List<Boolean> booleanStepList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer - 1; i++) {
            booleanStepList.add(generateBoolean());
        }

        for (int i = 1; i < numberOfPlayer - 1; i++) {
            if (booleanStepList.get(i) && booleanStepList.get(i - 1)) {
                booleanStepList.set(i, false);
            }
        }
        return booleanStepList;
    }

    private Boolean generateBoolean() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public ArrayList<String> getLadder() {
        return this.ladder;
    }
}
