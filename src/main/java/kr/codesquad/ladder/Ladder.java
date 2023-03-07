package kr.codesquad.ladder;

import java.util.stream.Stream;

public class Ladder {

    private final char BLANK_LETTER = ' ';
    private final char BAR_LETTER = '-';
    private final char LADDER_LINE = '|';
    private char[][] ladder;

    private Ladder(char[][] ladder) {
        this.ladder = ladder;
    }

    public static Ladder createLadder(int height, int participantCount) {
        return new Ladder(new char[height][participantCount * 2 - 1]);
    }

    public void fillLine() {
        for (int i = 0; i < ladder.length; i++) {
            fillVerticalLine(i);
        }
    }

    private void fillVerticalLine(int i) {
        for (int j = 0; j < ladder[0].length; j += 2) {
            ladder[i][j] = LADDER_LINE;
        }
    }

    public void fillWidthLine() {
        for (int i = 0; i < ladder.length; i++) {
            fillRandomWidthLine(i);
        }
    }

    private void fillRandomWidthLine(int i) {
        for (int j = 1; j < ladder[0].length; j += 2) {
            fillValuesByRandom(i, j);
        }
    }

    private void fillValuesByRandom(int i, int j) {
        boolean randomBoolean = Stream.generate(() -> (int) (Math.random() * 2))
                .limit(1).anyMatch(x -> x == 1);

        if (randomBoolean) {
            ladder[i][j] = BAR_LETTER;
            return;
        }
        ladder[i][j] = BLANK_LETTER;
    }

    public String getLadderStatus() {
        StringBuilder sb = new StringBuilder();
        for (char[] row : ladder) {
            sb.append(row);
            sb.append(System.lineSeparator());
        }
        return String.valueOf(sb);
    }

}
