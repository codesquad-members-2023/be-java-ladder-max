package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineInfo {

    static final String SUCCESS_DELIMITER = "-----";
    static final String FAIL_DELIMITER = "     ";
    static final String PEOPLE_DELIMITER = "|";

    private final List<Boolean> lineInfo;

    public LineInfo(List<Boolean> lineInfo) {
        this.lineInfo = lineInfo;
    }

    public static LineInfo createRandomLineStateInfo(int namesSize) {
        Random random = new Random();
        List<Boolean> store = new ArrayList<>();
        boolean hasLine = false;
        for (int j = 0; j < namesSize - 1; j++) {
            hasLine = random.nextBoolean() && !hasLine;
            store.add(hasLine);
        }
        return new LineInfo(store);
    }

    private static boolean canMoveLeft(int resultNum, List<Boolean> oneRowStateInfo) {
        return resultNum > 0 && oneRowStateInfo.get(resultNum - 1);
    }

    private static boolean canMoveRight(int resultNum, List<Boolean> oneRowStateInfo) {
        return resultNum < oneRowStateInfo.size() && oneRowStateInfo.get(resultNum);
    }
    

    public String connectLine() {
        StringBuilder result = new StringBuilder();
        for (Boolean isExist : lineInfo) {
            result.append(isExist ? SUCCESS_DELIMITER : FAIL_DELIMITER).append(PEOPLE_DELIMITER);
        }
        return result.toString();
    }

    public int size() {
        return lineInfo.size();
    }

    public int move(int resultNum) {
        if (canMoveLeft(resultNum, lineInfo)) {
            return resultNum - 1;
        }
        if (canMoveRight(resultNum, lineInfo)) {
            return resultNum + 1;
        }
        return resultNum;
    }
}
