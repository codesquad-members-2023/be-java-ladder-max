package kr.codesquad;

import java.util.Random;
import java.util.function.Supplier;

public class LadderByPeopleCount implements Ladder{

    public static final String PEOPLE_DELIMITER = "|";
    public static final String SUCCESS_DELIMITER = "-";
    public static final String FAIL_DELIMITER = " ";
    public static final String NEXT_LINE = "\n";
    private final Random random = new Random();

    private final Supplier<Boolean> randomBoolean = random::nextBoolean;

    public String create(int peopleCount, int ladderHeight) {
        boolean[][] ladderState = create(peopleCount, ladderHeight, randomBoolean);
        return draw(ladderState);
    }

    boolean[][] create(int peopleCount, int ladderHeight, Supplier<Boolean> condition) {
        boolean[][] result = new boolean[ladderHeight][peopleCount - 1];
        for (int i = 0; i < ladderHeight; i++) {
            addRandomLadder(peopleCount, condition, result[i]);
        }
        return result;
    }

    private static void addRandomLadder(int peopleCount, Supplier<Boolean> condition, boolean[] result) {
        for (int j = 0; j < peopleCount - 1; j++) {
            result[j] = condition.get();
        }
    }

    String draw(boolean[][] ladder) {
        StringBuilder result = new StringBuilder();
        for (boolean[] row : ladder) {
            addLadder(result, row);
        }
        return result.toString();
    }

    private static void addLadder(StringBuilder result, boolean[] row) {
        result.append(PEOPLE_DELIMITER);
        for (boolean column : row) {
            result.append(column ? SUCCESS_DELIMITER : FAIL_DELIMITER)
                .append(PEOPLE_DELIMITER);
        }
        result.append(NEXT_LINE);
    }

}
