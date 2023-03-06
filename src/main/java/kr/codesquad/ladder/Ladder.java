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

}
