package kr.codesquad.domain;

import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private final Boolean[][] ladder;

    public Ladder(int numberOfUsers, int ladderHeight) {
        this.ladder = new Boolean[numberOfUsers][ladderHeight];
        generateLadder();
    }

    private void generateLadder() {
        for (int i = 0; i < this.ladder.length - 1; i++) {
            this.ladder[i] = randomBooleans(this.ladder[i].length);
        }
    }

    private Boolean[] randomBooleans(int length) {
        Random random = new Random();
        return IntStream.range(0, length)
            .mapToObj(n -> random.nextBoolean())
            .toArray(Boolean[]::new);
    }
}