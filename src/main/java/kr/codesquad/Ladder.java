package kr.codesquad;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Ladder {
    private StringBuilder sb = new StringBuilder();
    int n;
    int m;
    // n과 m 받아서 for문 만들기
    // n은 참여할 사람 , m은 사다리의 높이
    public Ladder(int n, int m) {
        this.n = n;
        this.m = m;
    }
    public StringBuilder makeLadder() {
        String[][] printLadder = new String[m][n+n-1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n+n-1; j++) {
                printLadder[i][j] = "|";
                if (j % 2 != 0) {
                    printLadder[i][j] = randomLadder();
                }
            }
        }
        for (String s[] : printLadder) {
            String s1 = Arrays.stream(s).collect(Collectors.joining());
            sb.append(s1).append("\n");
        }
        return sb;
    }
    String randomLadder() {
        String[] ladderRandom = {" ", "-"};
        Random random = new Random();
        return ladderRandom[random.nextInt(2)];
    }

}
