package kr.codesquad.ladder;

import static kr.codesquad.ladder.BooleanGenerator.randomBoolean;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Boolean> line;

    private Line(List<Boolean> line) {
        this.line = line;
    }

    public static Line createLine(int count) {
        List<Boolean> booleans = new ArrayList<>();

        for (int index = 0; index < count; index++) {
            boolean randomBoolean = randomBoolean();
            booleans.add(randomBoolean);
            if (index >= 1 && booleans.get(index - 1)) {
                booleans.set(index, false);
            }
        }
        return new Line(booleans);
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }
}
