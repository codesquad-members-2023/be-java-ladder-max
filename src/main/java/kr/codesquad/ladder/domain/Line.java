package kr.codesquad.ladder.domain;

import static kr.codesquad.ladder.domain.BooleanGenerator.randomBoolean;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Boolean> line;

    private Line(List<Boolean> line) {
        this.line = line;
    }

    public static Line createLine(int count) {
        List<Boolean> booleans = new ArrayList<>();

        for (int index = 0; index < count; index++) {
            checkDoubleTrue(booleans, index);
        }
        return new Line(booleans);
    }

    private static void checkDoubleTrue(List<Boolean> booleans, int index) {
        boolean randomBoolean = randomBoolean();
        booleans.add(randomBoolean);
        if (index >= 1 && booleans.get(index - 1)) {
            booleans.set(index, false);
        }
    }

    @Override
    public String toString() {
        return "|" + line.stream()
                .map(bool -> bool ? "-----|" : "     |")
                .collect(Collectors.joining());
    }
}
