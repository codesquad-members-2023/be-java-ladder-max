package kr.codesquad;

import java.util.Random;

public class Ladder {
    private String[][] laddder;

    Ladder(int n, int m) {
        this.laddder = new String[m][2 * n - 1];

    }

    void makeBasicLadder() {
        for (int i = 0; i < laddder.length; i++) {
            for (int j = 0; j < laddder[i].length; j++) {
                extracted(i, j);
            }
        }
    }

    private void extracted(int i, int j) {
        if (j % 2 == 0) {
            this.laddder[i][j] = "|";
        } else this.laddder[i][j] = " ";
    }


    void makeRandomLadderLine() {

        for (int i = 0; i < laddder.length; i++) {
            for (int j = 0; j < laddder[i].length; j++) {
                Random random = new Random();
                boolean randomBoolean = random.nextBoolean();
                if (randomBoolean && j % 2 == 1) {
                    laddder[i][j] = "-";
                }
            }
        }
    }


}
