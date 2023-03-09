package kr.codesquad.domain;

import java.util.List;

public class LadderDrawer {

    static final String FAIL_DELIMITER = "     ";
    static final String PEOPLE_DELIMITER = "|";
    static final String NEXT_LINE = "\n";
    static final String PREFIX = "   ";

    public String draw(List<LineInfo> linesStateInfo) {
        StringBuilder result = new StringBuilder();
        for (LineInfo lineInfo : linesStateInfo) {
            result.append(PREFIX)
                .append(PEOPLE_DELIMITER)
                .append(lineInfo.connectLine())
                .append(NEXT_LINE);
        }
        return result.toString();
    }
}
