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
            if (validateLadderLine(column)) ;

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
    현재 verifyLadderLine에서는 LadderLine에서 "-----"가 없으면 makeRandomLadderLine을 호출
    그런데 이 메서드가 과연 맞을까?


     */
    private boolean validateLadderLine(int column) {
        if (!ladderline.contains("-----")) {
//            makeRandomLadderLine(column);
            return true;
        }
        if (column / 2 >= 3) {
            makeRandomLadderLine(column);
            return true;
        }
        return false;
    }


    /*
컬럼이
|---|   |   | (X)
|---|---|   | (O)
구분점은?


위와 같은 경우는 어떻게 방지해줄까?
앞에 컬럼이
 */
//        if (column)
    private void makeRandomLadderLine(int column) {
        Random random = new Random();
        if (column % 2 != 0 && random.nextBoolean()) {
            ladderline.set(column, "-----");
        }

    }

    private void ensureLadderLine(int column) {
        if(validateLadderLine(column))
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
