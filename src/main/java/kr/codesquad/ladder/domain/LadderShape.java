package kr.codesquad.ladder.domain;

import java.util.List;
import java.util.Random;

public class LadderShape {
    // participantNumber == participantList.size()
    // 위와 같은 사실을 이용하여 step-1과 비슷하게 로직을 짠다.

    private final List<String> participantList;
    private final int ladderShapeHeight;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static boolean isMinusSign = false;


    public LadderShape(List<String> participantList, int ladderShapeHeight) {
        this.participantList = participantList;
        this.ladderShapeHeight = ladderShapeHeight;
    }

    public void printLadder() {
        printParticipants();

        for (int i = 0; i < ladderShapeHeight; i++) {
            printLadderRows();
            System.out.println(stringBuilder);
            stringBuilder = new StringBuilder();
            isMinusSign = false;
        }
    }

    private void printParticipants() {
        for (int i = 0; i < participantList.size(); i++) {
            System.out.print(participantList.get(i));

            // 리팩토링 필요
            if (i % 2 == 0) {
                repeatBlank(2);
                continue;
            }
            repeatBlank(1);
        }
        System.out.println();
    }

    private void printLadderRows() {
        repeatBlank(2);
        for (int i = 0; i < participantList.size() + participantList.size() - 1; i++) {
            chooseLetter(i);
        }
    }

    private void chooseLetter(int i) {
        // Letter를 총 5번 append
        appendVerticalBar(i);
        appendRandomLadderRows(i);
    }

    private void appendVerticalBar(int i) {
        // i가 짝수일 때, 즉 "|" 출력
        // 즉, 짝수가 아니면 리턴
        if (i % 2 != 0) {
            return;
        }

        stringBuilder.append("|");
    }

    private void appendRandomLadderRows(int i) {
        // i가 홀수일 때, 즉 "-" 혹은 " " 랜덤 출력
        // 즉, 홀수가 아니면 리턴
        if (i % 2 != 1) {
            return;
        }

        if (isMinusSign) {
            appendBlank();
            return;
        }

        chooseRandomLetter();
    }

    private void chooseRandomLetter() {
        if (new Random().nextInt(2) == 0) {
            appendMinusSign(); // 5번 append
            return;
        }

        appendBlank(); // 5번 append
    }

    private void appendMinusSign() {
        isMinusSign = true;
        stringBuilder.append("-".repeat(5));
    }

    private void appendBlank() {
        isMinusSign = false;
        stringBuilder.append(" ".repeat(5));
    }

    private void repeatBlank(int n) {
        System.out.print(" ".repeat(n));
    }
}
