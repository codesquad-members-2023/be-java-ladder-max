package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.stream.IntStream;


public class LadderLine {

    private final int lineWidth;
    private ArrayList<Boolean> points;

    public LadderLine(int countOfPeople) {
        this.lineWidth = countOfPeople - 1;
        this.points = new ArrayList<>();
        new RandomLineGenerator().buildLadderLine(lineWidth,points);
    }

    void drawLine(StringBuilder sb, LadderLine line) {
        for (boolean boolInLine : line.points) {
            sb.append(boolInLine ? "-----|" : "     |");
        }
    }

     void markConnectedPoints(Boolean[] checkHung, LadderLine line) {
        IntStream.range(0, line.points.size())
                .filter(i -> line.points.get(i))
                .forEach(i -> checkHung[i] = true);
    }

    int getNextPosition(int currentPosition) {
        if (currentPosition > 0 && points.get(currentPosition - 1)) {
            return currentPosition - 1;
        }
        if (currentPosition < lineWidth && points.get(currentPosition)) {
            return currentPosition + 1;
        }
        return currentPosition;
    }
}
