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

    public int moveLine(int index) {
        if (index == 0) {
            return checkRightLine(index);
        }

        if (index == row.size()) {
            return checkLeftLine(index);
        }

        if (checkLeftLine(index) == index) {
            return checkRightLine(index);
        }
        return index - 1;
    }

    private int checkLeftLine(int index) {
        if (isLine(row.get(index - 1))) {
            return index - 1;
        }
        return index;
    }

    private int checkRightLine(int index) {
        if (isLine(row.get(index))) {
            return index + 1;
        }
        return index;
    }

    private boolean isLine(String line) {
        if (line.equals(LINE)) {
            return true;
        }
        return false;
    }
}
