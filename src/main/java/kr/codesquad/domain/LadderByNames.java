package kr.codesquad.domain;

import java.util.Random;

public class LadderByNames implements Ladder {

    static final String SUCCESS_DELIMITER = "-----";
    static final String FAIL_DELIMITER = "     ";
    static final String PEOPLE_DELIMITER = "|";
    static final String NEXT_LINE = "\n";
    static final String PREFIX = "   ";

    @Override
    public String draw(int peopleCount, int ladderHeight) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ladderHeight; i++) {
            connectLines(peopleCount, result);
        }
        return result.toString();
    }

    private static void connectLines(int peopleCount, StringBuilder result) {
        boolean possible = true;
        result.append(PREFIX)
            .append(PEOPLE_DELIMITER);
        for (int j = 0; j < peopleCount - 1; j++) {
            possible = connectLine(result, possible);
        }
        result.append(NEXT_LINE);
    }

    static boolean connectLine(StringBuilder result, boolean possible) {
        Random random = new Random();
        boolean randomBoolean = random.nextBoolean();
        result.append(randomBoolean && possible ? SUCCESS_DELIMITER : FAIL_DELIMITER)
            .append(PEOPLE_DELIMITER);
        return !(randomBoolean && possible);
    }
}
