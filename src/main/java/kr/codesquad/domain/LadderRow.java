package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private final String LINE = "-----";
    private final String BLANK = "     ";

    private List<String> row = new ArrayList<>();

    public LadderRow(int width) {
        String prevLine = "";
        for (int i = 0; i < width; i++) {
            String line = getRandomLine(prevLine);
            row.add(line);
            prevLine = line;
        }
    }

    private String getRandomLine(String prevLine) {
        if (prevLine.equals(LINE)) {
            return BLANK;
        }
        int random = (int) (Math.random() * 2);
        if (random == 1) {
            return LINE;
        }
        return BLANK;
    }

    public String toString() {
        String rowString = "  |";
        for (int i = 0; i < row.size(); i++) {
            rowString += row.get(i) + "|";
        }
        return rowString;
    }

    public boolean isRowHasLine() {
        for (String s : row) {
            if (s.equals(LINE)) {
                return true;
            }
        }
        return false;
    }
}
