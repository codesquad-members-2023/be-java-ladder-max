package kr.codesquad.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    public final String BAR = "|";
    public final String BLANK = " ".repeat(5);
    public final String LEG = "-".repeat(5);

    private final int n;
    private final int maxHeight;
    private final List<List<Boolean>> legs;

    public Ladder(int n, int maxHeight) {
        this.n = n;
        this.maxHeight = maxHeight;
        legs = new ArrayList<>();
    }

    public void generateLegs() {
        Random random = new Random();
        for (int i = 0; i < maxHeight; i++) {
            legs.add(i, generateRow(random, n - 1));
        }
    }

    private List<Boolean> generateRow(Random random, int length) {
        List<Boolean> row = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            row.add(i, random.nextBoolean() && (i == 0 || !row.get(i - 1)));
        }
        return row;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (List<Boolean> row : legs) {
            result.append(rowToString(row)).append('\n');
        }
        return result.toString();
    }

    private String rowToString(List<Boolean> row) {
        return BAR +
                row.stream().map(this::leg).collect(Collectors.joining(BAR)) +
                BAR;
    }

    private String leg(boolean hasLeg) {
        if (hasLeg) {
            return LEG;
        }
        return BLANK;
    }
}
