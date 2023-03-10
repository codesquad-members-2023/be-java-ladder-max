package kr.codesquad.domain;

import static kr.codesquad.domain.LineDelimiterType.FAIL_DELIMITER;
import static kr.codesquad.domain.LineDelimiterType.PEOPLE_DELIMITER;
import static kr.codesquad.domain.LineDelimiterType.SUCCESS_DELIMITER;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineInfo {


    private final List<Boolean> lineInfo;

    public LineInfo(List<Boolean> lineInfo) {
        this.lineInfo = lineInfo;
    }

    public static LineInfo createRandomLineInfo(int size) {
        Random random = new Random();
        List<Boolean> store = new ArrayList<>();
        boolean hasLine = false;
        for (int j = 0; j < size; j++) {
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
            result.append(isExist ? SUCCESS_DELIMITER.getValue() : FAIL_DELIMITER.getValue())
                    .append(PEOPLE_DELIMITER.getValue());
        }
        return result.toString();
    }

    public int size() {
        return lineInfo.size();
    }

    public int move(int resultNum) {
        if (canMoveLeft(resultNum, lineInfo)) {
            return --resultNum;
        }
        if (canMoveRight(resultNum, lineInfo)) {
            return ++resultNum;
        }
        return resultNum;
    }
}
