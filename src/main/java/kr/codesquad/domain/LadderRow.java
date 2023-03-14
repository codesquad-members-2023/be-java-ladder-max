package kr.codesquad.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderRow {
    private final List<String> ladderRow;
    private final int numberOfPeople;


    LadderRow(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        this.ladderRow = new ArrayList<>(numberOfPeople);
    }

    public List<String> makeLadderColumn() {
        for (int column = 0; column < 2 * numberOfPeople - 1; column++) {
            makeBasicLadderColumn(column);
            /*
            재귀적으로 호출?
            아니면, try-catch문?

             */
            generateRandomLadderLine(column);
            ensureLadderLine(column);

        }

        return ladderRow;
    }

    private void makeBasicLadderColumn(int column) {
        if (column % 2 == 0) {
            ladderRow.add("|");
            return;
        }
        ladderRow.add("     ");
    }


    public void generateRandomLadderLine() {
        for (int column = 0; column < 2 * numberOfPeople - 1; column++) {
            if (validateLadderLine(column)) {
                generateRandomLadderLine(column);

            }
        }
    }

    /*
    ladderLine에서 "-----"가 있는지 확인하고, 없으면 makeRandomLadderLine을 호출한다.
    현재 verifyLadderLine에서는 LadderLine에서 "-----"가 없으면 makeRandomLadderLine을 호출
    그런데 이 메서드가 과연 맞을까?


     */
    private boolean validateLadderLine(int column) {
//        for (int column = 0; column < 2 * numberOfPeople - 1; column++) {
//
//        }
        if (!ladderRow.contains("-----") || column/2>1) {
            return true;
        }
//        if (column / 2 >= 3) {
//            makeRandomLadderLine(column);
//            return true;
//        }
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
    private void generateRandomLadderLine(int column) {
        Random random = new Random();
        if (column % 2 != 0 && random.nextBoolean()) {
            ladderRow.set(column, "-----");
        }

    }

    /*
    해당 column 전까지 "-----"가 없고,
     */
    private void ensureLadderLine(int column) {
        if(!validateLadderLine(column) || column/2>=1){
            generateRandomLadderLine(column);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String s : ladderRow) {
            sb.append(s);
        }
        return sb.toString();
    }
}
