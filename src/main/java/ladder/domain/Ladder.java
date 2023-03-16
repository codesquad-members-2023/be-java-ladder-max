package ladder.domain;

import ladder.random.RandomManager;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int players, int height) {
        checkMinHeight(height);
        int width = players - 1;
        makeLadder(width, height);
    }

    private void checkMinHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 최소 높이는 1개입니다.");
        }
    }

    private void makeLadder(int width, int height) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(width, new RandomManager());
            lines.add(line);
        }
    }

    public String drawLadder() {
        StringBuilder builder = new StringBuilder();
        final int SPACE = 2;
        for (Line line : lines) {
            builder.append(" ".repeat(SPACE));
            builder.append(line.drawLine());
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }

    public int rideLadder(int index) {
        for (Line line : lines) {
            index = line.rideLine(index);
        }
        return index;
    }
}
