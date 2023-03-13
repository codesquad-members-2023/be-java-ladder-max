package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> rungs = new ArrayList<>();

    public Line(int width) {
        makeRungs(width);
    }

    private void makeRungs(int width) {
        rungs.add(makeRungRandomly());
        for (int i = 1; i < width; i++) {
            rungs.add(checkContinuousRungs(i));
        }
    }

    private boolean checkContinuousRungs(int index) {
        final int LEFT = index - 1;
        if (rungs.get(LEFT)) {
            return false;
        }
        return makeRungRandomly();
    }

    private boolean makeRungRandomly() {
        boolean[] random = {false, true};
        return random[(int) (Math.random() * random.length)];
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

    public boolean isRungExist(int index) {
        return rungs.get(index);
    }
}
