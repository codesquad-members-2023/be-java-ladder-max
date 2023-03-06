package kr.codesquad.model;

import java.util.Random;

public class Ladder {
    public final char BAR = '|';
    public final char BLANK = ' ';
    public final char LEG = '-';

    private final int n;
    private final int maxHeight;
    private final boolean[][] legs;

    public Ladder(int n, int maxHeight) {
        this.n = n;
        this.maxHeight = maxHeight;
        legs = new boolean[maxHeight][n - 1];
    }

    public void generateLegs() {
        Random random = new Random();
        for (int i = 0; i < maxHeight; i++) {
            legs[i] = generateRow(random, n - 1);
        }
    }

    private boolean[] generateRow(Random random, int length) {
        boolean[] row = new boolean[length];
        for (int i = 0; i < length; i++) {
            row[i] = random.nextBoolean();
        }
        return row;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (boolean[] row : legs) {
            result.append(rowToString(row)).append('\n');
        }
        return result.toString();
    }

    private String rowToString(boolean[] row) {
        StringBuilder rowToString = new StringBuilder();
        for (boolean leg : row) {
            rowToString.append(BAR).append(leg(leg));
        }
        rowToString.append(BAR);
        return rowToString.toString();
    }

    private char leg(boolean leg) {
        if (leg) {
            return LEG;
        }
        return BLANK;
    }
}
