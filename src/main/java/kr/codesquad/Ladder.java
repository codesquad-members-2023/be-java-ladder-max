package kr.codesquad;

import java.util.Random;

public class Ladder {
    static int m;
    static int n;
    static String[][] ladder;

    public void setLadder(int people, int height) {
        m = people;
        n = height;
        ladder = new String[n][m * 2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m * 2 + 1; j += 2) {
                ladder[i][j] = "|";
            }
        }
        Random rd = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m * 2 + 1; j += 2) {
                if (rd.nextBoolean()) {
                    ladder[i][j] = "-";
                } else ladder[i][j] = " ";
            }
        }
    }
}
