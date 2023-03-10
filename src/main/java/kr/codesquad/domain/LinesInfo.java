package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LinesInfo {
    static final String PEOPLE_DELIMITER = "|";
    static final String NEXT_LINE = "\n";
    static final String PREFIX = "   ";
    private final List<LineInfo> linesInfo;

    public LinesInfo() {
        this.linesInfo = new ArrayList<>();
    }

    public void add(LineInfo lineInfo) {
        linesInfo.add(lineInfo);
    }


    public static LinesInfo create(int namesSize, int ladderHeight) {
        LinesInfo linesInfo = new LinesInfo();
        for (int i = 0; i < ladderHeight; i++) {
            linesInfo.add(LineInfo.createRandomLineStateInfo(namesSize));
        }
        return linesInfo;
    }

    public String draw() {
        StringBuilder result = new StringBuilder();
        for (LineInfo lineInfo : linesInfo) {
            result.append(PREFIX)
                    .append(PEOPLE_DELIMITER)
                    .append(lineInfo.connectLine())
                    .append(NEXT_LINE);
        }
        return result.toString();
    }

    public void calculator(LadderResultRepository ladderResultRepository) {
        int columnLength = linesInfo.get(0).size();
        for (int j = 0; j < columnLength + 1; j++) {
            int resultNum = j;
            for (LineInfo lineInfo : linesInfo) {
                resultNum = lineInfo.move(resultNum);
            }
            ladderResultRepository.put(j, resultNum);
        }
    }
}
