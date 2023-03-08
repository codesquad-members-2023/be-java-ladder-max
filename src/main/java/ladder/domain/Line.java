package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> rungs = new ArrayList<>();

    public Line() { }

    public Line makeRungsRandomly(int space) {
        for (int i = 0; i < space; i++) {
            rungs.add(getRandomBoolean());
        }
        checkContinuousRungs(rungs);
        return this;
    }

    private void checkContinuousRungs(List<Boolean> rungs) {
        for (int i = 0; i < rungs.size(); i++) {
            if (i == 0) continue;
            if (rungs.get(i - 1)) {
                rungs.set(i, false);
            }
        }
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
