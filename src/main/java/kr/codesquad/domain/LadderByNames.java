package kr.codesquad.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.stream.Collectors;

public class LadderByNames implements Ladder {

    static final String SUCCESS_DELIMITER = "-----";
    static final String FAIL_DELIMITER = "     ";
    static final String PEOPLE_DELIMITER = "|";
    static final String NEXT_LINE = "\n";
    static final String PREFIX = "   ";
    private final Map<Integer, Integer> usersOfResult = new HashMap<>();

    @Override
    public String draw(int peopleCount, int ladderHeight) {
        StringBuilder result = new StringBuilder();
        boolean[][] ladderExistStateArray = new boolean[ladderHeight][peopleCount - 1];
        for (int i = 0; i < ladderHeight; i++) {
            connectLines(peopleCount, result, ladderExistStateArray[i]);
        }
        moveAndSaveUsers(ladderExistStateArray);
        return result.toString();
    }

    public Map<Integer, Integer> getUsersOfResult() {
        return usersOfResult.entrySet().stream()
            .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
    }

    private void moveAndSaveUsers(boolean[][] ladderExistStateArray) {
        int columnLength = ladderExistStateArray[0].length;
        for (int j = 0; j < columnLength + 1; j++) {
            moveAndSaveUser(ladderExistStateArray, columnLength, j);
        }
    }

    private void moveAndSaveUser(boolean[][] ladderExistStateArray, int columnLength, int position) {
        int resultNum = position;
        for (boolean[] aBoolean : ladderExistStateArray) {
            if (canMoveLeft(resultNum, aBoolean)) {
                resultNum = resultNum - 1;
            } else if (canMoveRight(columnLength, resultNum, aBoolean)) {
                resultNum = resultNum + 1;
            }
        }
        usersOfResult.put(position, resultNum);
    }

    private static boolean canMoveRight(int columnLength, int resultNum, boolean[] aBoolean) {
        return resultNum < columnLength && aBoolean[resultNum];
    }

    private static boolean canMoveLeft(int resultNum, boolean[] aBoolean) {
        return resultNum > 0 && aBoolean[resultNum - 1];
    }

    private static void connectLines(int peopleCount, StringBuilder result, boolean[] aBoolean) {
        boolean possible = true;
        result.append(PREFIX)
            .append(PEOPLE_DELIMITER);
        for (int j = 0; j < peopleCount - 1; j++) {
            possible = connectLine(result, possible);
            aBoolean[j] = !possible;
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
