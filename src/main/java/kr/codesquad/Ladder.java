package kr.codesquad;

import java.util.Random;

public class Ladder implements LadderManager {
    // "|" 개수: participantNumber
    // "-", " " 개수: participantNumber - 1, "-" 혹은 " "은 둘 중 하나로 랜덤 출력한다.

    private final int participantNumber;
    private final int ladderHeight;
    private static StringBuilder stringBuilder = new StringBuilder();

    public Ladder(int participantNumber, int ladderHeight) {
        this.participantNumber = participantNumber;
        this.ladderHeight = ladderHeight;
    }

    @Override
    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            printLadderRows();
            System.out.println(stringBuilder);
            stringBuilder = new StringBuilder();
        }
    }

    @Override
    public void printLadderRows() {
        for (int i = 0; i < (participantNumber) + (participantNumber - 1); i++) {
            chooseLetter(i);
        }
    }

    @Override
    public void chooseLetter(int i) {
        appendVerticalBar(i);
        appendRandomLadderRows(i);
    }

    @Override
    public void appendVerticalBar(int i) {
        // i가 짝수일 때, 즉 "|" 출력
        // 즉, 짝수가 아니면 리턴
        if (i % 2 != 0) {
            return;
        }

        stringBuilder.append("|");
    }

    @Override
    public void appendRandomLadderRows(int i) {
        // i가 홀수일 때, 즉 "-" 혹은 " " 랜덤 출력
        // 즉, 홀수가 아니면 리턴
        if (i % 2 != 1) {
            return;
        }

        chooseRandomLetter();
    }

    @Override
    public void chooseRandomLetter() {
        if (new Random().nextInt(2) == 0) {
            appendMinusSign();
            return;
        }

        appendBlank();
    }

    @Override
    public void appendMinusSign() {
        stringBuilder.append("-");
    }

    @Override
    public void appendBlank() {
        stringBuilder.append(" ");
    }
}
