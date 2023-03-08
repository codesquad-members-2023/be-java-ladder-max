package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LadderShape {
    // participantNumber == participantList.size()
    // 위와 같은 사실을 이용하여 step-1과 비슷하게 로직을 짠다.

    private final List<String> participantList;
    private final int ladderShapeHeight;

    private List<String> points = new ArrayList<>();
    private boolean isMinusSign = false;

    private static final String VERTICAL_BAR = "|";
    private static final String MINUS_SIGN = "-";
    private static final String BLANK = " ";

    public LadderShape(List<String> participantList, int ladderShapeHeight) {
        this.participantList = participantList;
        this.ladderShapeHeight = ladderShapeHeight;
    }

    public void printLadder() {
        printParticipants();
        loopLadder();
    }

    private void printParticipants() {
        participantList.stream()
                .map(participant -> String.format(" %5s", participant))
                .forEach(System.out::print);
        printNewLine();
    }

    private void loopLadder() {
        for (int i = 0; i < ladderShapeHeight; i++) {
            manageLadder();
        }
    }

    private void manageLadder() {
        printLadderRows();
        points.forEach(System.out::print);
        printNewLine();
        points = new ArrayList<>();
        isMinusSign = false;
    }

    private void printLadderRows() {
        printRepeatBlank(3);
        IntStream.range(0, participantList.size() * 2 - 1)
                .forEach(this::chooseLetter);
    }

    private void chooseLetter(int i) {
        // Letter를 총 5번 append
        appendVerticalBar(i);
        appendRandomLadderRows(i);
    }

    private void appendVerticalBar(int i) {
        // i가 짝수일 때, 즉 "|" 출력
        // 즉, 짝수가 아니면 리턴
        if (!isEven(i)) {
            return;
        }

        points.add(VERTICAL_BAR);
    }

    private void appendRandomLadderRows(int i) {
        // i가 홀수일 때, 즉 "-" 혹은 " " 랜덤 출력
        // 즉, 홀수가 아니면 리턴
        if (isEven(i)) {
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
        Stream.generate(() -> MINUS_SIGN)
                .limit(5)
                .forEach(points::add);
    }

    private void appendBlank() {
        isMinusSign = false;
        Stream.generate(() -> BLANK)
                .limit(5)
                .forEach(points::add);
    }

    private void printRepeatBlank(int n) {
        System.out.print(BLANK.repeat(n));
    }

    private void printNewLine() {
        System.out.println();
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }
}
