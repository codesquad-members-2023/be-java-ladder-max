package kr.codesquad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Ladder {

    private final int MAX_LEN = 5;

    private ArrayList<String> ladder;

    public void makeLadderShape(UserInput userInput) {
        this.ladder = new ArrayList<>();
        List<String> playerList = Arrays.asList(userInput.names.split(","));

        this.ladder.add(fillNameLine(playerList));

        for (int i = 0; i < userInput.height; i++) {
            this.ladder.add(fillLadderLine(playerList.size()));
        }
    }

    private String fillNameLine(List<String> playerList) {
        StringBuilder nameLine = new StringBuilder();

        for (String player : playerList) {
            nameLine.append(" ").append(makeFormalName(player));
        }

        return nameLine.toString();
    }

    private String makeFormalName (String player) {
        StringBuilder formalName = new StringBuilder();
        int diff = MAX_LEN - player.length();

        int left = diff / 2;
        int right = diff - left;

        for (int i = 0; i < left; i++) {
            formalName.append(' ');
        }
        formalName.append(player);
        for (int i = 0; i < right; i++) {
            formalName.append(' ');
        }
        return formalName.toString();
    }

    private String fillLadderLine(int numberOfPlayer) {
        StringBuilder ladderLine = new StringBuilder();
        List<Boolean> stepLayoutList = generateRandomStepList(numberOfPlayer);

        for (Boolean isExistStep : stepLayoutList) {
            ladderLine.append((isExistStep) ? "|-----" : "|     ");
        }
        ladderLine.append("|");

        return ladderLine.toString();
    }

    // TODO: 현재 각 발판이 동일한 확률로 생성되지 않음.
    //  ex) 좌측 2번째 발판의 경우, 첫발판이 생기지 않고, 두번째 발판이 생겨야하는 25%의 확률.
    private List<Boolean> generateRandomStepList(int numberOfPlayer) {
        List<Boolean> booleanStepList = new ArrayList<>();
        for (int i = 0; i < numberOfPlayer - 1; i++) {
            booleanStepList.add(generateBoolean());
        }

        return checkContinuousStep(booleanStepList);
    }

    private List<Boolean> checkContinuousStep(List<Boolean> booleanStepList) {
        for (int i = 1; i < booleanStepList.size(); i++){
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
