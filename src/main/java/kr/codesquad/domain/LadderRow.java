package kr.codesquad.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class LadderRow {
    private final List<String> ladderRow;
    private final int numberOfPeople;


    LadderRow(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
        this.ladderRow = new ArrayList<>(numberOfPeople);
    }

    public List<String> makeLadderColumn() {
        IntStream.range(0, 2 * numberOfPeople - 1).forEach(this::makeBasicLadderColumn);
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
        IntStream.range(0, 2 * numberOfPeople - 1).forEach(this::hasLadderLine);
    }


    private boolean hasLadderLine(int column) {
        if (!ladderRow.contains("-----")) { // 사다리의 행에서 "-----"가 하나도 없을경우 Ramdom하게 생성
            generateLadderLineRandomly(column);
            return true;
        }
        if (column % 2 != 0 && column >= 3) { // 사다리의 행에 "-----"가 하나 이상은 존재하고 현재 컬럼이 홀수 번호이고, column이 3이상일 경우
            generateLadderLineEnsure(column);       // ladderLine을 확실해 생성한다.
        }
        return false;
    }


    private void generateLadderLineEnsure(int column) {
        int prevColumn = column - 2;
        if (prevColumn >= 0 && !(ladderRow.get(prevColumn).contains("-----"))) { // prevColumn이 공백일경우, 현재 column에 "----" 추가
            ladderRow.set(column, "-----");
        }
    }


    private void generateLadderLineRandomly(int column) {
        Random random = new Random();
        if (column % 2 != 0 && random.nextBoolean()) {
            ladderRow.set(column, "-----");
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

