package ladder.domain;

import ladder.random.RandomManager;

import java.util.List;

public class Line {
    private final List<Boolean> rungs;

    public Line(int width, RandomManager randomManager) {

        this.rungs = randomManager.makeBooleansRandomly(width);
        checkContinuousRungs();
    }

    private void checkContinuousRungs() {
        for (int index = 1; index < rungs.size(); index++) {
            removeContinuousRung(index);
        }
    }

    private void removeContinuousRung(int index) {
        int left = index - 1;
        if (rungs.get(left) && rungs.get(index)) {
            rungs.set(index, false);
        }
    }

    public String drawLine() {
        StringBuilder builder = new StringBuilder();
        final String RUNG = "-----";
        final String BLANK = "     ";
        final String HANDLE = "|";
        builder.append(HANDLE);
        for (Boolean rung : rungs) {
            builder.append(rung ? RUNG : BLANK);
            builder.append(HANDLE);
        }
        return builder.toString();
    }

    public int rideLine(int index) {
        final int FIRST = 0;
        final int LAST = rungs.size();
        final int LEFT = index - 1;
        final int RIGHT = index + 1;
        if (index == FIRST && rungs.get(FIRST)) {
            return RIGHT;
        }
        if (index != FIRST && index != LAST && rungs.get(index)) {
            return RIGHT;
        }
        if (index != FIRST && index != LAST && rungs.get(LEFT)) {
            return LEFT;
        }
        if (index == LAST && rungs.get(LEFT)) {
            return LEFT;
        }
        return index;
    }
}
