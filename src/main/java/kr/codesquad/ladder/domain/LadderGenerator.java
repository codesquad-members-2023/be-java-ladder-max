package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {

    private final int maximumHeight;

    public LadderGenerator(int maximumHeight, int minimumHeight) {
        validateMinimumHeight(maximumHeight, minimumHeight);
        this.maximumHeight = maximumHeight;
    }

    private void validateMinimumHeight(int maximumHeight, int minLadderHeight) {
        if (maximumHeight < minLadderHeight) {
            throw new InvalidNumberOfMinimumLadderHeightException();
        }
    }

    public Ladder createLines(int countOfPerson, Random random) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < maximumHeight; i++) {
            lines.add(createLine(countOfPerson, random));
        }
        return new Ladder(lines);
    }

    private Line createLine(int countOfPerson, Random random) {
        Line line = new Line(new Points());
        for (int i = 0; i < countOfPerson * 2 - 1; i++) {
            line.addPoint(i, random);
        }
        return line;
    }
}
