package kr.codesquad.domain;

import java.util.Random;

public class LadderByPeopleCount implements Ladder{

    static final String PEOPLE_DELIMITER = "|";
    static final String SUCCESS_DELIMITER = "-";
    static final String FAIL_DELIMITER = " ";
    static final String NEXT_LINE = "\n";


    public String draw(int peopleCount, int ladderHeight) {
        boolean[][] ladderState = drawLine(peopleCount, ladderHeight);
        return connectLines(ladderState);
    }

    boolean[][] drawLine(int peopleCount, int ladderHeight) {
        boolean[][] result = new boolean[ladderHeight][peopleCount - 1];
        for (int i = 0; i < ladderHeight; i++) {
            drawLineByRandom(peopleCount, result[i]);
        }
        return result;
    }

    private static void drawLineByRandom(int peopleCount, boolean[] result) {
        Random random = new Random();
        for (int j = 0; j < peopleCount - 1; j++) {
            result[j] = random.nextBoolean();
        }
    }

    String connectLines(boolean[][] ladder) {
        StringBuilder result = new StringBuilder();
        for (boolean[] row : ladder) {
            connectLine(result, row);
        }
        return result.toString();
    }

    private static void connectLine(StringBuilder result, boolean[] row) {
        result.append(PEOPLE_DELIMITER);
        for (boolean column : row) {
            result.append(column ? SUCCESS_DELIMITER : FAIL_DELIMITER)
                .append(PEOPLE_DELIMITER);
        }
        result.append(NEXT_LINE);
    }

}
