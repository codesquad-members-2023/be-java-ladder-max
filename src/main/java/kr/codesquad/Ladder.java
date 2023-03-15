package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ladder {

    private ArrayList<String> ladder;

    public void makeLadderShape(UserInput userInput) {
        List<String> playerList = Arrays.asList(userInput.names.split(","));
        System.out.println(playerList);
//        for (String[] strings : ladder) {
//            fillLadderLine(strings);
//        }
    }

    private void fillLadderLine(String[] customLadderLine) {
        for (int i = 0; i < customLadderLine.length; i++){
            fillRandomLadderStep(i, customLadderLine);
        }
    }
    
    private void fillRandomLadderStep(int index, String[] customLadderLine) {
        String randomStep = (Math.random() > 0.5) ? " " : "-";

        customLadderLine[index] = (index % 2 == 0) ? "|" : randomStep;
    }

    public ArrayList<String> getLadder() {
        return this.ladder;
    }
}
