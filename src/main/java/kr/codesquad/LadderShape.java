package kr.codesquad;

import java.util.List;
import java.util.Random;

public class LadderShape {
    // participantNumber == participantList.size()
    // 위와 같은 사실을 이용하여 step-1과 비슷하게 로직을 짠다.

    private final List<String> participantList;
    private final int ladderShapeHeight;
    private static StringBuilder stringBuilder = new StringBuilder();


    public LadderShape(List<String> participantList, int ladderShapeHeight) {
        this.participantList = participantList;
        this.ladderShapeHeight = ladderShapeHeight;
    }

    @Override
    public void printLadder() {
        for (int i = 0; i < ladderShapeHeight; i++) {
            printLadderRows();
            System.out.println(stringBuilder);
            stringBuilder = new StringBuilder();
        }
    }

    @Override
    public void printLadderRows() {
        for (int i = 0; i < participantList.size(); i++) {
            chooseLetter(i);
        }
    }

    @Override
    public void chooseLetter(int i) {
        // Letter를 총 5번 append
        appendVerticalBar(i);
        appendRandomLadderRows(i);
    }

    @Override
    public void appendVerticalBar(int i) {
        // 6번마다 "|" 반복
        if (i % 6 != 0) {
            return;
        }

        stringBuilder.append("|");
    }

    @Override
    public void appendRandomLadderRows(int i) {
        // "|"와 안 겹치게
        if (i % 6 == 0) {
            return;
        }

        chooseRandomLetter();
    }

    @Override
    public void chooseRandomLetter() {
        if (new Random().nextInt(2) == 0) {
            appendMinusSign(); // 5번 append
            return;
        }

        appendBlank(); // 5번 append
    }

    @Override
    public void appendMinusSign() {
        stringBuilder.append("-".repeat(5));
    }

    @Override
    public void appendBlank() {
        stringBuilder.append(" ".repeat(5));
    }
}
