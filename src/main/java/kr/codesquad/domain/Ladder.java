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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int numberOfUsers = 0; numberOfUsers < this.ladder[0].length; numberOfUsers++) {
            putRowLadder(stringBuilder, numberOfUsers);
        }

        return stringBuilder.toString();
    }

    private void putRowLadder(StringBuilder stringBuilder, int numberOfUsers) {
        for (int ladderHeight = 0; ladderHeight < this.ladder.length - 1; ladderHeight++) {
            stringBuilder.append(String.format("|%s", this.ladder[ladderHeight][numberOfUsers] ? "-" : " "));
        }

        stringBuilder.append("|\n");
    }
}