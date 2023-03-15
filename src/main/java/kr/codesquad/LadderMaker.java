package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    RandomBooleanGenerator rbg = new RandomBooleanGenerator();

    public Ladder make(int width, int height) {
        List<Line> rows = new ArrayList<>();

        for (int cnt = 0; cnt < height; cnt++) {
            List<Boolean> randomBoolean = rbg.generate(width);
            rows.add(new Line(randomBoolean));
        }
        return new Ladder(rows);
    }
}
