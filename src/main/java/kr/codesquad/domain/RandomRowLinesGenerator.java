package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomRowLinesGenerator {

    private final Random random;
    private final int numberOfUsers;

    public RandomRowLinesGenerator(int numberOfUsers) {
        this.random = new Random();
        this.numberOfUsers = numberOfUsers;
    }

    public RowLines generate() {
        List<Boolean> result = new ArrayList<>();
        result.add(random.nextBoolean());

        IntStream.range(1, this.numberOfUsers - 1)
            .forEach(index -> {
                Boolean previousLine = result.get(index - 1);
                result.add(getLine(previousLine));
            });
        return new RowLines(result);
    }

    private boolean getLine(boolean previousLine) {
        if (!previousLine) {
            return random.nextBoolean();
        }

        return false;
    }
}
