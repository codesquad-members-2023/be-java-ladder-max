package kr.codesquad.domain;

import java.util.Random;
import java.util.function.Supplier;

public class LadderByNames implements Ladder {

    static final String SUCCESS_DELIMITER = "-----";
    static final String FAIL_DELIMITER = "     ";
    static final String PEOPLE_DELIMITER = "|";
    static final String NEXT_LINE = "\n";
    static final String PREFIX = "   ";
    private final Random random = new Random();

    @Override
    public String create(int peopleCount, int ladderHeight) {
        return create(peopleCount, ladderHeight, random::nextBoolean);
    }

    String create(int peopleCount, int ladderHeight, Supplier<Boolean> condition) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ladderHeight; i++) {
            addRow(peopleCount, condition, result);
        }
        return result.toString();
    }

    private static void addRow(int peopleCount, Supplier<Boolean> condition, StringBuilder result) {
        boolean possible = true;
        result.append(PREFIX)
            .append(PEOPLE_DELIMITER);
        for (int j = 0; j < peopleCount - 1; j++) {
            possible = addLadder(condition, result, possible);
        }
        result.append(NEXT_LINE);
    }

    private static boolean addLadder(Supplier<Boolean> condition, StringBuilder result, boolean possible) {
        Boolean randomBoolean = condition.get();
        addLadder(result, possible, randomBoolean);
        return !(randomBoolean && possible);
    }

    static void addLadder(StringBuilder result, boolean beforeIsTrue, boolean currentIsPossible) {
        result.append(currentIsPossible && beforeIsTrue ? SUCCESS_DELIMITER : FAIL_DELIMITER)
            .append(PEOPLE_DELIMITER);
    }
}
