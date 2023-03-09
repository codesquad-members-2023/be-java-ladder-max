package kr.codesquad.domain;

import java.util.List;

public class LadderDrawer {

    static final String SUCCESS_DELIMITER = "-----";
    static final String FAIL_DELIMITER = "     ";
    static final String PEOPLE_DELIMITER = "|";
    static final String NEXT_LINE = "\n";
    static final String PREFIX = "   ";

    public String draw(List<List<Boolean>> linesStateInfo) {
        StringBuilder result = new StringBuilder();
        for (List<Boolean> rowLineStateInfo : linesStateInfo) {
            connectLines(rowLineStateInfo, result);
        }
        return result.toString();
    }

    private void connectLines(List<Boolean> rowLineStateInfo, StringBuilder result) {
        result.append(PREFIX)
            .append(PEOPLE_DELIMITER);
        for (Boolean isExist : rowLineStateInfo) {
            result.append(isExist ? SUCCESS_DELIMITER : FAIL_DELIMITER)
                .append(PEOPLE_DELIMITER);
        }
        result.append(NEXT_LINE);
    }
}
