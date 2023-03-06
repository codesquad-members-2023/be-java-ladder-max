package kr.codesquad;

import java.util.Random;

public class Ladder {
    // "|" 개수: participantNumber
    // "-", " " 개수: participantNumber - 1, "-" 혹은 " "은 둘 중 하나로 랜덤 출력한다.

    private final int participantNumber;
    private final int ladderHeight;

    public Ladder(int participantNumber, int ladderHeight) {
        this.participantNumber = participantNumber;
        this.ladderHeight = ladderHeight;
    }

    private void printVerticalBar() {
        System.out.print("|");
    }

    private void printMinusSign() {
        System.out.print("-");
    }

    private void printBlank() {
        System.out.print(" ");
    }

    private void printLadderRows() {
        for (int i = 0; i < (participantNumber) + (participantNumber - 1); i++) {
            if (i % 2 == 0) { // i가 짝수일 때, 즉 "|" 출력
                printVerticalBar();
            } else { // i가 홀수일 때, 즉 "-" 혹은 " " 랜덤 출력
                printRandomLadderRows();
            }
        }
    }

    private void printRandomLadderRows() {
        Random random = new Random();
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0) {
            printMinusSign();
        } else {
            printBlank();
        }
    }

    public void printLadder() {
        for (int i = 0; i < ladderHeight; i++) {
            printLadderRows();
            printNewline();
        }
    }

    private void printNewline() {
        System.out.println();
    }
}
