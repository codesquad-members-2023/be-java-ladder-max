package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final int width;
    private final int height;
    private final List<Line> lines;

    public Ladder(int width, int height) {
        this.width = width;
        this.height = height;
        this.lines = new ArrayList<>();
    }

    public void makeLadder() {
        for (int i = 0; i < height; i++) {
            Line line = new Line();
            line.makeRungs(width);
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
}
