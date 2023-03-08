package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> rungs;

    public Line(int space) {
        rungs = makeRandomRung(space);
    }

    private List<Boolean> makeRandomRung(int space) {
        List<Boolean> hasRungs = new ArrayList<>();
        for (int i = 0; i < space; i++) {
            hasRungs.add(getRandomBoolean());
        }
        return checkContinuousRungs(hasRungs, space);
    }

    private List<Boolean> checkContinuousRungs(List<Boolean> rungs, int space) {
        for (int i = 0; i < space; i++) {
            if (i == 0) continue;
            if (rungs.get(i - 1)) {
                rungs.set(i, false);
            }
        }
        return rungs;
    }

    private boolean getRandomBoolean() {
        boolean[] random = {false, true};
        return random[(int) (Math.random() * random.length)];
    }

    public void drawLine(StringBuilder builder) {
        for (int j = 0; j < rungs.size(); j++) {
            drawLeft(builder, j);
            builder.append(rungs.get(j) ? "-----" : "     ");
            drawRight(builder);
        }
    }

    private void drawLeft(StringBuilder builder, int space) {
        if (space == 0) {
            drawRight(builder);
        }
    }

    private void drawRight(StringBuilder builder) {
        builder.append("|");
    }
}
