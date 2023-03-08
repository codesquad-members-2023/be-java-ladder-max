package kr.codesquad.ladder.domain;

import java.util.Random;

public class Ladder {
    // "|" 개수: participantNumber
    // "-", " " 개수: participantNumber - 1, "-" 혹은 " "은 둘 중 하나로 랜덤 출력한다.

    private final int participantNumber;
    private final int ladderHeight;

    private static StringBuilder stringBuilder = new StringBuilder();
    private static final String VERTICAL_BAR = "|";
    private static final String MINUS_SIGN = "-";
    private static final String BLANK = " ";

    public Ladder(int participantNumber, int ladderHeight) {
        this.participantNumber = participantNumber;
        this.ladderHeight = ladderHeight;
    }

    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            printLadderRows();
            System.out.println(stringBuilder);
            stringBuilder = new StringBuilder();
        }
    }

    private void printLadderRows() {
        for (int i = 0; i < (participantNumber) + (participantNumber - 1); i++) {
            chooseLetter(i);
        }
    }

    private void chooseLetter(int i) {
        appendVerticalBar(i);
        appendRandomLadderRows(i);
    }

    private void appendVerticalBar(int i) {
        // i가 짝수일 때, 즉 "|" 출력
        // 즉, 짝수가 아니면 리턴
        if (!isEven(i)) {
            return;
        }

        stringBuilder.append(VERTICAL_BAR);
    }

    private void appendRandomLadderRows(int i) {
        // i가 홀수일 때, 즉 "-" 혹은 " " 랜덤 출력
        // 즉, 홀수가 아니면 리턴
        if (isEven(i)) {
            return;
        }

        chooseRandomLetter();
    }

    private void chooseRandomLetter() {
        if (new Random().nextInt(2) == 0) {
            appendMinusSign();
            return;
        }

        appendBlank();
    }

    private void appendMinusSign() {
        stringBuilder.append(MINUS_SIGN);
    }

    private void appendBlank() {
        stringBuilder.append(BLANK);
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
