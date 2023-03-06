package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class LadderShape {
    // participantNumber == participantList.size()
    // 위와 같은 사실을 이용하여 step-1과 비슷하게 로직을 짠다.

    private final List<String> participantList;
    private final int ladderShapeHeight;

    private List<String> points = new ArrayList<>();

    private boolean isMinusSign = false;

    public LadderShape(List<String> participantList, int ladderShapeHeight) {
        this.participantList = participantList;
        this.ladderShapeHeight = ladderShapeHeight;
    }

    public void printLadder() {
        printParticipants();

        for (int i = 0; i < ladderShapeHeight; i++) {
            printLadderRows();
            points.forEach(System.out::print);
            printNewLine();
            points = new ArrayList<>();
            isMinusSign = false;
        }
    }

    private void printParticipants() {
        for (String participant : participantList) {
            System.out.printf("%5s ", participant);
        }

        printNewLine();
    }

    private void printLadderRows() {
        printRepeatBlank(3);
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

        points.add("|");
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

    // @Test
    public void appendMinusSign() {
        isMinusSign = true;
        Stream.generate(() -> "-")
                .limit(5)
                .forEach(points::add);
    }

    // @Test
    public void appendBlank() {
        isMinusSign = false;
        Stream.generate(() -> " ")
                .limit(5)
                .forEach(points::add);
    }

    // @Test
    public List<String> getPoints() {
        return points;
    }

    private void printRepeatBlank(int n) {
        System.out.print(" ".repeat(n));
    }

    private void printNewLine() {
        System.out.println();
    }
}
