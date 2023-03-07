package kr.codesquad;

import java.util.Arrays;
import java.util.Random;

public class Ladder {
    private final String[][] ladders;

    private final int rows, cols;

    Ladder(int people, int length) {
        this.ladders = new String[length][people - 1]; // 출력할 때 | 추가할거임
        this.rows = length;
        this.cols = people - 1;
        makeLadder();
    }

    void makeLadder() {
        Random random = new Random();
        for(int idx1 = 0; idx1 < rows; idx1++) {
            for(int idx2 = 0; idx2 < cols; idx2++) {
                int curr = random.nextInt(2);
                if(curr == 0) {
                    ladders[idx1][idx2] = "-";
                } else {
                    ladders[idx1][idx2] = " ";
                }
            }
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
