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
            int curr = random.nextInt(2);
            if(curr == 0) {
                ladder[idx] = "-";
                continue;
            }
            ladder[idx] = " ";
        }
    }

    void printLadder() {
        for(String[] ladder : ladders) {
            System.out.print("|");
            System.out.print(Arrays.stream(ladder)
                    .reduce((o1, o2) -> o1 + "|" + o2).orElse(""));
            System.out.println("|");
        }
    }
}
