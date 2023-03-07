package kr.codesquad;

import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final String[][] ladders;

    Ladder(int people, int length) {
        this.ladders = new String[length][people - 1]; // 출력할 때 | 추가할거임
        makeLadder();
    }

    void makeLadder() {
        for(String[] ladder : ladders) {
            makeLine(ladder);
        }
    }

    private void makeLine(String[] ladder) {
        Random random = new Random();
        for(int idx = 0; idx < ladder.length; idx++) {
            int num = random.nextInt(2);
            drawLine(num, idx, ladder);
        }
    }

    private void drawLine(int num, int idx, String[] ladder) {
        if(num == 0) {
            ladder[idx] = "-";
            return;
        }
        ladder[idx] = " ";
    }

    void printLadder() {
        for(String[] ladder : ladders) {
            System.out.print("|");
            System.out.println(Arrays.stream(ladder)
                    .reduce(new StringBuilder(), (sb, o) ->
                                    sb.append(o).append("|")
                            , StringBuilder::append));
        }
    }
}
