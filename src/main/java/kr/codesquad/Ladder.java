package kr.codesquad;

import java.util.Random;
import java.util.function.Supplier;

public class Ladder {

    private final Random random = new Random();

    private final Supplier<Boolean> randomBoolean = random::nextBoolean;

    String create(int peopleCount, int ladderHeight) {
        boolean[][] ladderState = create(peopleCount, ladderHeight, randomBoolean);
        return draw(ladderState);
    }

    boolean[][] create(int peopleCount, int ladderHeight, Supplier<Boolean> condition) {
        boolean[][] result = new boolean[ladderHeight][peopleCount - 1];
        for (int i = 0; i < ladderHeight; i++) {
            for (int j = 0; j < peopleCount - 1; j++) {
                result[i][j] = condition.get();
            }
        }
        return result;
    }

    String draw(boolean[][] ladder) {
        StringBuilder result = new StringBuilder();
        for (boolean[] row : ladder) {
            result.append("|");
            for (boolean column : row) {
                result.append(column ? "-" : " ")
                    .append("|");
            }
            result.append("\n");
        }
        return result.toString();
    }

}
