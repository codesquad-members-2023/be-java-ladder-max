package kr.codesquad.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
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

    public List<List<Boolean>> readLadder() {
        return Arrays.stream(this.ladder)
            .map(List::of)
            .collect(Collectors.toUnmodifiableList());
    }
}
