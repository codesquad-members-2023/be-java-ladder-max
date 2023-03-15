package kr.codesquad.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import kr.codesquad.ladder.exception.InvalidNumberOfMinimumLadderHeightException;

public class LadderGenerator {

    private static final int MINIMUM_HEIGHT = 1;
    private final int maximumHeight;

    public LadderGenerator(int maximumHeight) {
        validateMinimumHeight(maximumHeight);
        this.maximumHeight = maximumHeight;
    }

    private void validateMinimumHeight(int maximumHeight) {
        if (maximumHeight < MINIMUM_HEIGHT) {
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
