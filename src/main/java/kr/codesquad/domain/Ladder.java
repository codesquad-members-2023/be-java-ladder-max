package kr.codesquad.domain;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    protected ArrayList<ArrayList<String>> ladder = new ArrayList<>();

    public Ladder(int verticalLine, int horizontalLine) {
        makeLadder(verticalLine, horizontalLine);
    }

    private void makeLadder(int verticalLine, int horizontalLine) {
        for (int i = 0; i < horizontalLine; i++) {
            ladder.add(new ArrayList<>());
            fillLine(i, verticalLine);
        }
    }

    private void fillLine(int row, int column) {
        for (int j = 0; j < column - 1; j++) {
            fillVerticalLine(row);
            fillHorizontalLine(row, j);
        }
        fillVerticalLine(row);
    }

    private void fillVerticalLine(int row) {
        ladder.get(row).add("|");
    }

    private void fillHorizontalLine(int row, int column) {
        String[] str = {"-----", "     "};
        if (column >= 1 && ladder.get(row).get((2 * column) - 1).equals("-----")) {
            ladder.get(row).add("     ");
            return;
        }
        ladder.get(row).add(str[new Random().nextInt(2)]);
    }
}
