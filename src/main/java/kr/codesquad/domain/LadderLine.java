package kr.codesquad.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderLine {
    private final List<String> ladderline;


    LadderLine() {
        this.ladderline = new ArrayList<>();
    }

    public List<String> makeLadderLine(int numberOfPeople) {
        for (int column = 0; column < 2 * numberOfPeople - 1; column++) {
            makeBasicLadderRow(column);
            /*
            재귀적으로 호출?
            아니면, try-catch문?

             */
            if(verifyLadderLine(column));

        }
        return ladderline;
    }

    private void makeBasicLadderRow(int column) {
        if (column % 2 == 0) {
            ladderline.add("|");
            return;
        }
        ladderline.add("     ");
    }

    /*
    ladderLine에서 "-----"가 있는지 확인하고, 없으면 makeRandomLadderLine을 호출한다.
     */
    private boolean verifyLadderLine(int column) {
        if (!ladderline.contains("-----")) {
            makeRandomLadderLine(column);
            return true;
        }
        return false;
    }

    private void makeRandomLadderLine(int column) {
        Random random = new Random();
        if (column % 2 != 0 && random.nextBoolean()) {
            ladderline.set(column, "-----");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : ladderline) {
            sb.append(s);
        }
        return sb.toString();
    }
}
