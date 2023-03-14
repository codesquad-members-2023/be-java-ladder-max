package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final String VERTICAL_LINE = "|";
    private final int ODD_INDEX_START = 1;
    private final int ODD_INDEX_JUMP = 2;
    private final String EMPTY_STRING = "";

    private final List<String> lines = new ArrayList<>();

    public void fillLadder(int ladderWidth) {

        lines.add(VERTICAL_LINE);
        String before = EMPTY_STRING;
        for (int j = ODD_INDEX_START; j < ladderWidth; j += ODD_INDEX_JUMP) {
            before = fillLadderRandomOrStick(before);
            lines.add(before);
            lines.add(VERTICAL_LINE);
        }
    }

    private String fillLadderRandomOrStick(String before) {
        if (isLine(before)) {
            return LadderLine.blank.getValue();
        }
        return LadderLine.takeRandom();
    }

    public boolean isLine(String before) {
        return before.equals(LadderLine.stick.getValue());
    }

    public String show() {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(line);
        }
        return sb.toString();
    }
}
