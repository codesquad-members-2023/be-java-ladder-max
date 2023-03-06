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

        for (int i = 0; i < count; i++) {
            boolean randomBoolean = randomBoolean();
            if (randomBoolean) {
                i++;
            }
            booleans.add(randomBoolean);
        }
        return new Line(booleans);
    }

}
