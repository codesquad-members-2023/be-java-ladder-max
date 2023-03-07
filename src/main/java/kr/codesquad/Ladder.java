package kr.codesquad;

import java.util.Random;

public class Ladder {
    static int m;
    static int n;
    static String[][] ladder;

    public void makeLadder(int people, int height) {
        m = people;
        n = height;
        ladder = new String[n][m * 2 - 1];
        for (int i = 0; i < n; i++) {
            makeVerticalLines(i);
            makeHorizontalLines(i);
        }
    }

    public void makeVerticalLines(int i) {
        int j = 0;
        while (j < m * 2 - 1) {
            ladder[i][j] = "|";
            j += 2;
        }
    }

    public void makeHorizontalLines(int i) {
        Random rd = new Random();
        int j = 1;
        while (j < m * 2 - 1) {
            ladder[i][j] = (rd.nextBoolean()) ? "-" : " ";
            j += 2;
        }
    }
}