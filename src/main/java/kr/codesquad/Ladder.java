package kr.codesquad;

import java.util.Random;

public class Ladder {
    private final char[][] ladder;
    private final Random random;

    Ladder(int people, int length) {
        this.ladder = new char[length][people - 1]; // 출력할 때 | 추가할거임
        this.random = new Random();
    }

    void makeLadder() {

    }
}
