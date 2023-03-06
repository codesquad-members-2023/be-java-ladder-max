package kr.codesquad.util;

import kr.codesquad.Ladder;

public class OutputHandler {
    void outPut(String str) {
        System.out.println(str);
    }

    void printLadder(Ladder ladder){
        StringBuilder sb = new StringBuilder();
        char[][] tempLadder = ladder.getLadder();
        int ladderHeight = ladder.getLadderHeight();
        int ladderWidth = ladder.getPeopleNum() * 2 - 1;

        for (int i = 0; i < ladderHeight; i++) {
            appendToSb(sb, ladderWidth, tempLadder[i]);
        }
        System.out.println(sb);
    }

    private static void appendToSb(StringBuilder sb, int ladderWidth, char[] tempLadder) {
        for (int j = 0; j < ladderWidth; j++) {
            sb.append(tempLadder[j]);
        }
        sb.append("\n");
    }
}
