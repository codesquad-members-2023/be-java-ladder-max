package kr.codesquad.ladder;

import java.util.Arrays;

public class Ladder {

    private final char LADDER_LINE = '|';
    private char[][] ladder;

    private Ladder(char[][] ladder) {
        this.ladder = ladder;
    }

    public static Ladder createLadder(int height, int participantCount) {
        return new Ladder(new char[height][participantCount * 2 - 1]);
    }

    public void fillLine() {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[0].length; j += 2) {
                ladder[i][j] = LADDER_LINE;
            }
        }
    }

}
