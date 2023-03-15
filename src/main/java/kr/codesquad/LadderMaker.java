package kr.codesquad;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {
    RandomBooleanGenerator rbg = new RandomBooleanGenerator();

    public Ladder makeRandomLadder(int width, int height) {
        Ladder ladder = new Ladder();

        for (int cnt = 0; cnt < height; cnt++) {
            List<Boolean> randomBoolean = rbg.generate(width);
            ladder.addLine(randomBoolean);
        }
        return ladder;
    }
}
