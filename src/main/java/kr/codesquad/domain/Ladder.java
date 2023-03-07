package kr.codesquad.domain;

import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {

    private final Boolean[][] ladder;

    public Ladder(int numberOfUsers, int ladderHeight) {
        this.ladder = generateLadder(numberOfUsers, ladderHeight);
    }

    private Boolean[][] generateLadder(int numberOfUsers, int ladderHeight) {
        Random random = new Random();
        return IntStream.range(0, ladderHeight)
            .mapToObj(n -> getRandomBooleans(random, numberOfUsers - 1))
            .toArray(Boolean[][]::new);
    }

    private Boolean[] getRandomBooleans(Random random, int length) {
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
