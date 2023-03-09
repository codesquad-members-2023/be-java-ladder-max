package kr.codesquad;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Ladder {
    protected String[][] ladder;

    public Ladder(int verticalLine, int horizontalLine) {
        ladder = new String[horizontalLine][(2 * verticalLine) - 1];
        fillVerticalLine();
        fillHorizontalLine();
    }

    public void fillVerticalLine() {
        Arrays.stream(ladder).forEach(row -> Arrays.fill(row, "|"));
    }

    public void fillHorizontalLine() {
        String[] str = {"-", " "};
        IntStream.range(0, ladder.length)
                .forEach(x -> IntStream.range(0, ladder[0].length)
                        .filter(y -> y % 2 == 1)
                        .forEach(y -> ladder[x][y] = str[new Random().nextInt(2)]));
    }
}
