package kr.codesquad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Boolean> line = new ArrayList<>();
    private int width;

    public Line(int width) {
        this.width = width;
        generateLine();
    }

    public Line(List<Boolean> input) {
        this.line.addAll(input);
        this.width = input.size();
    }

    private void generateLine() {
        Random r = new Random();

        for (int count = 0; count < width; count++) {
            addWithoutContinuity(line, r.nextBoolean());
        }
    }

    private void addWithoutContinuity(List<Boolean> line, boolean leg) {
        if (isLegContinuous(line, leg)) {
            line.add(false);
            return;
        }
        line.add(leg);
    }

    private boolean isLegContinuous(List<Boolean> line, boolean leg) {
        if (line.isEmpty()) {
            return false;
        }
        if (line.get(line.size() - 1) && leg) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return line.toString();
    }
}
