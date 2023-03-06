package kr.codesquad;

import java.util.Random;
import java.util.function.Supplier;

public class LadderByNames implements Ladder {

    public static final String SUCCESS_DELIMITER = "-----";
    public static final String FAIL_DELIMITER = "     ";
    public static final String PEOPLE_DELIMITER = "|";
    public static final String NEXT_LINE = "\n";
    private final Random random = new Random();

    @Override
    public String create(int peopleCount, int ladderHeight) {
        return create(peopleCount, ladderHeight, random::nextBoolean);
    }

    String create(int peopleCount, int ladderHeight, Supplier<Boolean> condition) {
        StringBuilder result = new StringBuilder();
        boolean possible = true;
        for (int i = 0 ; i < ladderHeight ; i++) {
            possible = addRow(peopleCount, condition, result, possible);
        }
        return result.toString();
    }

    private static boolean addRow(int peopleCount, Supplier<Boolean> condition, StringBuilder result,
        boolean possible) {
        result.append("   ");
        result.append(PEOPLE_DELIMITER);
        for (int j = 0 ; j < peopleCount -1 ; j++) {
            possible = addSuccess(condition, result, possible);
        }
        possible = true;
        result.append(NEXT_LINE);
        return possible;
    }

    private static boolean addSuccess(Supplier<Boolean> condition, StringBuilder result, boolean possible) {
        Boolean randomBoolean = condition.get();
        result.append(randomBoolean && possible ? SUCCESS_DELIMITER : FAIL_DELIMITER)
            .append(PEOPLE_DELIMITER);
        return !(randomBoolean && possible);
    }
}
