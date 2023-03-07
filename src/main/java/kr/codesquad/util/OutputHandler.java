package kr.codesquad.util;

import kr.codesquad.Ladder;

public class OutputHandler {
    void outPut(String str) {
        System.out.println(str);
    }

    void printLadder(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        char[][] tempLadder = ladder.getLadder();
        for (char[] row : tempLadder) {
            appendToSb(sb, row);
        }
        System.out.println(sb);
    }

    private static void appendToSb(StringBuilder sb, char[] tempLadder) {
        sb.append(tempLadder).append("\n");
    }
}
