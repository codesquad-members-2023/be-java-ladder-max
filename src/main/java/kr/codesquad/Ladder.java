package kr.codesquad;

public class Ladder {

    private String[][] ladder;

    public void makeLadderShape(int[] userInput) {
        ladder = new String[userInput[1]][userInput[0] * 2 - 1];
        for (String[] strings : ladder) {
            fillLadderLine(strings);
        }
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

    public String[][] getLadder() {
        return this.ladder;
    }
}
