package kr.codesquad.ladder;

import java.util.Arrays;
import java.util.stream.Collectors;
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
            for (int j = 0; j < ladder[0].length; j += 2) {
                ladder[i][j] = LADDER_LINE;
            }
        }
    }

    public void fillRandomWidthLine() {
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 1; j < ladder[0].length; j += 2) {
                boolean randomBoolean = Stream.generate(() -> (int) (Math.random() * 2))
                        .limit(1).anyMatch(x -> x == 1);

                if (randomBoolean) {
                    ladder[i][j] = BAR_LETTER;
                    continue;
                }
                ladder[i][j] = BLANK_LETTER;
            }
        }
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
