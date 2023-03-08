package kr.codesquad;

public class Ladder {

    private String[][] ladder;

    public void makeLadderShape(int[] userInput) {
        ladder = new String[userInput[1]][userInput[0] * 2 - 1];
        for (int i = 0; i < ladder.length; i++){
            fillLadderLine(ladder[i]);
        }
    }

    private void fillLadderLine(String[] customLadder) {
        for (int i = 0; i < customLadder.length; i++){
            if (i % 2 == 0)
                customLadder[i] = "|";
            else
                customLadder[i] = randomLadderStep();
        }
    }

    private String randomLadderStep() {
        double rand = Math.random();
        String result = (rand <= 0.5) ? " " : "-";
        return result;
    }

    public String[][] getLadder() {
        return this.ladder;
    }
}
