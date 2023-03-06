package kr.codesquad;

import java.util.Random;

public class Ladder {
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
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < n - 1; j++) {
                char leg = ' ';
                if (legs[i][j]) leg = '-';
                result.append('|').append(leg);
            }
            result.append('|').append('\n');
        }
        return result.toString();
    }
}
