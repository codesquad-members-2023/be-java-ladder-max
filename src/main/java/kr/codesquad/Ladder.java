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
            for (int j = 0; j < n - 1; j++) {
                legs[i][j] = random.nextBoolean();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxHeight; i++) {
            for (int j = 0; j < n - 1; j++) {
                result.append('|');
                if (legs[i][j]) {
                    result.append('-');
                } else {
                    result.append(' ');
                }
            }
            result.append("|\n");
        }
        return result.toString();
    }
}
